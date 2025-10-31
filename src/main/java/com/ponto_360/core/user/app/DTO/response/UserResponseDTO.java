package com.ponto_360.core.user.app.DTO.response;


import com.ponto_360.core.user.infra.db.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class UserResponseDTO {
    private String fullName;
    private String cpf;
    private String email;
    private String phone;
    private LocalDate dateBirthday;
    private String role;
    private int dailyHours;
    private LocalTime startTime;
    private LocalTime endTime;

    public UserResponseDTO(User user) {
        this.fullName = user.getFullName();
        this.cpf = user.getCpf();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.dateBirthday = user.getDateBirthday();
        //this.dailyHours =  user.getDa;
        //this.startTime =  user.startTime;
        //this.endTime =  user.endTime;
        this.role = user.getRole();
    }
}
