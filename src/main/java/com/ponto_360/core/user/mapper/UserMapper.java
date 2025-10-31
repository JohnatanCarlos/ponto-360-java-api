package com.ponto_360.core.user.mapper;


import com.ponto_360.core.user.app.DTO.request.UserRequestDTO;
import com.ponto_360.core.user.app.DTO.response.UserResponseDTO;
import com.ponto_360.core.user.infra.db.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // DTO PARA ENTITY
    public User toEntity(UserRequestDTO request) {
        return User.builder()
                .fullName(request.getFullName())
                .cpf(request.getCpf())
                .email(request.getEmail())
                .phone(request.getPhone())
                .dateBirthday(request.getDateBirthday())
                .password(request.getPassword())
                .role(request.getRole())
                .avatar(request.getAvatar())
                .build();
    }

    public UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(user);
    }
}
