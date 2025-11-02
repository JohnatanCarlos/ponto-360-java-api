package com.ponto_360.core.user.app.DTO.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class UserRequestDTO {
    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "CPF is required")
    @Pattern(regexp = "\\d{11}", message = "CPF must be 11 digits")
    private String cpf;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateBirthday;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    private String role;
    private String avatar;

    @Positive(message = "Daily hours must be positive")
    private int dailyHours;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;
}
