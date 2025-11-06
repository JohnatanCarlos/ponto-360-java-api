package com.ponto_360.core.timeclock.app.DTO.request;

import com.ponto_360.core.timeclock.enums.RecordType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TimeClockRequestDTO {
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotNull
    private LocalDateTime timestamp;

    @NotNull(message = "Tipo de registro é obrigatório")
    private RecordType type;

    private String location;
    private String latitude;
    private String longitude;
}
