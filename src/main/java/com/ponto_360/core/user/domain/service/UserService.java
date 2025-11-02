package com.ponto_360.core.user.domain.service;

import com.ponto_360.core.user.app.DTO.request.UserRequestDTO;
import com.ponto_360.core.user.app.DTO.response.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponseDTO save(UserRequestDTO request);

    List<UserResponseDTO> getAll(String name, String cpf);

    UserResponseDTO getByCpf(String cpf);

    UserResponseDTO update(String cpf, UserRequestDTO request);

    void delete(String cpf);
}
