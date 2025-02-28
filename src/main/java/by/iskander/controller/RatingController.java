package by.iskander.controller;

import by.iskander.domain.dto.RatingDto;
import by.iskander.domain.dto.SummaryRatingDto;
import by.iskander.domain.model.Rating;
import by.iskander.service.RatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rating")
@RequiredArgsConstructor
@Tag(name = "RatingController", description = "Получение и работа с рейтингами")
public class RatingController {
    private final RatingService service;

    @GetMapping("/all")
    @Operation(summary = "Get all Ratings, available only to authorized users with the ADMIN role")
    public ResponseEntity<List<Rating>> getAllRatings() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    @Operation(summary = "Create Rating available only to authorized users with the USER role")
    public Rating addRating(@RequestBody RatingDto ratingDto) {
        return service.add(ratingDto);
    }

    @PutMapping
    @Operation(summary = "Update Rating available only to authorized users with the USER role")
    public Rating updateRating(@RequestBody RatingDto ratingDto) {
        return service.update(ratingDto);
    }

    @GetMapping("get-summary-rating")
    @Operation(summary = "get-summary-rating Update Rating available only to authorized users with the ADMIN role")
    public SummaryRatingDto getSummaryRating() {
        return service.getSummaryRating();
    }
}