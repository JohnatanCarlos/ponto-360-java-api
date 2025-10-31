package com.ponto_360.core.user.infra.db.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fullName;
    private String cpf;
    private String email;
    private String phone;
    private LocalDate dateBirthday;
    private String password;
    private String role;
    private String avatar;

    @Builder.Default
    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime updateAt;

    @Builder.Default
    private boolean isActive = true;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserWorkSchedule userWorkSchedule;

    @Builder
    public User(String fullName, String cpf, String email, String phone, LocalDate dateBirthday, String password, String role, String avatar) {
        this.fullName = fullName;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.dateBirthday = dateBirthday;
        this.password = password;
        this.role = role;
        this.avatar = avatar;
        this.createAt = LocalDateTime.now();
        this.isActive = true;
    }
}
