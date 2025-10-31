package com.ponto_360.core.user.app.DTO.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class UserRequestDTO {
    private String fullName;
    private String cpf;
    private String email;
    private String phone;
    private LocalDate dateBirthday;
    private String password;
    private String role;
    private String avatar;
    private int dailyHours;
    private LocalTime startTime;
    private LocalTime endTime;
}
