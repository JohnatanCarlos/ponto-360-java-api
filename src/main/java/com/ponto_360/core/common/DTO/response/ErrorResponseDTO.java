package com.ponto_360.core.common.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {
    private String code;
    private String message;
}
