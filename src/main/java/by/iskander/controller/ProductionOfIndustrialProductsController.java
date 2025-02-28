package by.iskander.controller;

import by.iskander.TypeOfPeriod;
import by.iskander.domain.model.Period;
import by.iskander.domain.model.PeriodDto;
import by.iskander.domain.model.ProductionOfProducts;
import by.iskander.repository.PeriodRepository;
import by.iskander.repository.ProductionOfProductsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/statistics/production-of-industrial-products")
@RequiredArgsConstructor
@Slf4j
public class ProductionOfIndustrialProductsController {
    private final PeriodRepository periodRepository;
    private final ProductionOfProductsRepository productionOfProductsRepository;
    private final ModelMapper modelMapper;

//    @PostMapping(value = "/upload-file", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,
//            MediaType.APPLICATION_OCTET_STREAM_VALUE})
//    public ResponseEntity<String> uploadFile(
//            @RequestPart(value = "files", required = false) MultipartFile[] files,
//            @RequestPart(value = "period", required = false) Period period,
//            @RequestParam(value = "date", required = false, defaultValue = "#{T(java.time.LocalDate).now()}")
//            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
//            @RequestParam(value = "date", required = false, defaultValue = "#{T(java.time.LocalDate).now()}")
//            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
//    ) {
//        // Обработка файлов и параметров
//        return ResponseEntity.ok("Files uploaded successfully.");
//    }

    @PostMapping(value = "/upload-files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> uploadFiles(
            @RequestPart(value = "file1", required = false) MultipartFile file1,
            @RequestPart(value = "file2", required = false) MultipartFile file2,
            @RequestPart(value = "period", required = false) PeriodDto periodDto,
            @RequestParam(value = "date", required = false, defaultValue = "#{T(java.time.LocalDateTime).now()}") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "date", required = false, defaultValue = "#{T(java.time.LocalDateTime).now()}") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate
    ) {
        // Устанавливаем текущую дату, если дата не передана
        if (startDate == null) {
            startDate = LocalDateTime.now();
        }

        Period period = modelMapper.map(periodDto, Period.class);

        Period deepCopyOfPeriod = SerializationUtils.clone(modelMapper.map(periodDto, Period.class));
//        Period period1 = periodRepository.save(period);

        ProductionOfProducts productionOfProducts1 = ProductionOfProducts.builder().countOfEmployers(new BigDecimal(10))
                .period(period).build();
        ProductionOfProducts products1 = productionOfProductsRepository.save(productionOfProducts1);

        deepCopyOfPeriod.setType(TypeOfPeriod.QUARTER);
        ProductionOfProducts productionOfProducts2 = ProductionOfProducts.builder().countOfEmployers(new BigDecimal(10))
                .period(deepCopyOfPeriod).build();
        ProductionOfProducts products2 = productionOfProductsRepository.save(productionOfProducts2);

        try {
            // Логируем файлы
            System.out.println("Received file1: " + file1.getOriginalFilename() + ", size: " + file1.getSize());
            System.out.println("Received file2: " + file2.getOriginalFilename() + ", size: " + file2.getSize());

            // Логируем объект и дату
            System.out.println("Received data object: " + period);
            System.out.println("Received date: " + startDate);

            // Обрабатываем файлы (например, сохраняем)
//        saveFile(file1, "uploads/");
//        saveFile(file2, "uploads/");

            List<ProductionOfProducts> byPeriodType1 = productionOfProductsRepository.getByPeriod_Type(TypeOfPeriod.YEAR);
            List<ProductionOfProducts> byPeriodType2 = productionOfProductsRepository.getByPeriod_Type(TypeOfPeriod.QUARTER);

            return ResponseEntity.ok("Files and data uploaded successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request: " + e.getMessage());
        }
    }

    // Метод сохранения файла
    private void saveFile(MultipartFile file, String uploadDir) throws IOException {
        Path filePath = Paths.get(uploadDir + file.getOriginalFilename());
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, file.getBytes());
        System.out.println("File saved to: " + filePath);
    }
}