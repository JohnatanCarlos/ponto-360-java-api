// java
package com.ponto_360.core.common.exception;

import com.ponto_360.core.common.DTO.ErrorResponse;
import com.ponto_360.core.common.DTO.ErrorResponseDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Map<String, String> CODE_MAP = Map.ofEntries(
            Map.entry("NotBlank", "MSG101"),
            Map.entry("Size", "MSG123"),
            Map.entry("Pattern", "MSG124"),
            Map.entry("Email", "MSG125"),
            Map.entry("Positive", "MSG126"),
            Map.entry("NotNull", "MSG127"),
            Map.entry("Past", "MSG128")
    );

    private String mapCode(String validatorCode) {
        if (validatorCode == null) return "MSG000";
        return CODE_MAP.getOrDefault(validatorCode, "MSG000");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ErrorResponseDTO> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::toErrorDTO)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }

    private ErrorResponseDTO toErrorDTO(FieldError fe) {
        String validatorCode = fe.getCode(); // ex: "Size", "NotBlank"
        String code = mapCode(validatorCode);
        String message = fe.getDefaultMessage();
        return new ErrorResponseDTO(code, message);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex) {
        List<ErrorResponseDTO> errors = ex.getConstraintViolations()
                .stream()
                .map(this::toErrorDTO)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }



    private ErrorResponseDTO toErrorDTO(ConstraintViolation<?> violation) {
        String annotationName = violation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName(); // ex: "Size"
        String code = mapCode(annotationName);
        String message = violation.getMessage();
        return new ErrorResponseDTO(code, message);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExists(UserAlreadyExistsException ex) {

        ErrorResponseDTO error = new ErrorResponseDTO("USR001", ex.getMessage());
        List<ErrorResponseDTO> errors = List.of(error);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(errors));
    }
}
