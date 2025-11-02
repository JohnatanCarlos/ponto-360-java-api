package com.ponto_360.core.user.infra.db.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "users_work_schedules")
public class UserWorkSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int dailyHours;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updateAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
