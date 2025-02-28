package by.iskander.controller;

import by.iskander.domain.dto.UpdateEstimationDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import by.iskander.domain.model.User;
import by.iskander.service.UserService;

import java.time.Instant;
import java.time.LocalDate;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
@Tag(name = "UserController", description = "Work with users")
public class UserController {
    private final UserService service;

    @GetMapping("/all")
    @Operation(summary = "Get all " +
                         "- available only to authorized users with the ADMIN role")
    public Iterable<User> getAllUsers() {
        return service.getAll();
    }

       @PostMapping("/update-estimated-date-for-user")
       @Operation(summary = "update estimated date for User " +
                         "- available only to authorized users with the ADMIN and USER role")
        public void updateEstimatedDateTimeForUser(@RequestBody UpdateEstimationDTO estimationDTO) {
        service.updateEstimatedDateTimeForUser(estimationDTO.getLocalDate(),estimationDTO.getUserId());
    }

    @GetMapping("/get-users-where-estimation-expired")
    @Operation(summary = "get Users where estimation is expired " +
                         "- available only to authorized users with the ADMIN role")
    public Iterable<User> getUsersWhereEstimationExpired() {
        return service.getUsersWhereEstimationExpired(LocalDate.now());
    }
}