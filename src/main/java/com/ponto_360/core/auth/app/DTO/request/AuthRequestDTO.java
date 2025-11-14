package com.ponto_360.core.auth.app.DTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequestDTO {
    private String cpf;
    private String password;
}