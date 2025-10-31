package com.ponto_360.core.user.domain.service;

import com.ponto_360.core.user.app.DTO.request.UserRequestDTO;
import com.ponto_360.core.user.app.DTO.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO save(UserRequestDTO request);
}
