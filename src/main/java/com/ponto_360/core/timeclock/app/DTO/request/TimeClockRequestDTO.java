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
    @NotBlank(message = "CPF is required")
    private String cpf;

    @NotNull
    private LocalDateTime timestamp;

    @NotNull(message = "Record type is required")
    private RecordType type;

    private String location;
    private String latitude;
    private String longitude;
}
