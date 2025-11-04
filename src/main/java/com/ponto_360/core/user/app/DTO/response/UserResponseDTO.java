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

    private String avatar;
    private int dailyHours;
    private LocalTime startTime;
    private LocalTime endTime;

    public UserResponseDTO(User user) {
        this.fullName = user.getFullName();
        this.cpf = user.getCpf();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.dateBirthday = user.getDateBirthday();
        this.avatar = user.getAvatar();
        this.dailyHours = user.getUserWorkSchedule().getDailyHours();
        this.startTime = user.getUserWorkSchedule().getStartTime();
        this.endTime = user.getUserWorkSchedule().getEndTime();
        this.role = user.getRole();
    }
}
