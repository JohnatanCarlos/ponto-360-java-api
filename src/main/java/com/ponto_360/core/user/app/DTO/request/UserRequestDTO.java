package com.ponto_360.core.user.app.DTO.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class UserRequestDTO {
    @NotBlank(message = "Nome completo é obrigatório")
    private String fullName;

    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF deve ser composto por 11 dígitos numéricos")
    private String cpf;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotBlank(message = "Phone é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "Telefon deve ser composto por 11 dígitos numéricos")
    private String phone;

    @Past(message = "Data de nascimento deve ser uma data passada")
    private LocalDate dateBirthday;

    @NotBlank(message = "Senha é obrigatório")
    @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres")
    private String password;

    private String role;
    private String avatar;

    @Positive(message = "Horas diárias deve ser um número positivo")
    private int dailyHours;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;
}
