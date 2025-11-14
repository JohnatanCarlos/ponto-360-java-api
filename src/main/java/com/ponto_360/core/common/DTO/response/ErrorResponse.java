package com.ponto_360.core.common.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private List<ErrorResponseDTO> errors;
}
