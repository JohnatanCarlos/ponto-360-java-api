package com.ponto_360.core.user.mapper;


import com.ponto_360.core.user.app.DTO.request.UserRequestDTO;
import com.ponto_360.core.user.app.DTO.response.UserResponseDTO;
import com.ponto_360.core.user.infra.db.entity.User;
import com.ponto_360.core.user.infra.db.entity.UserWorkSchedule;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
                .role(request.getRole())
                .build();
    }

    // ENTITY PARA DTO
    public UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(user);
    }

    // LISTA DE ENTITY PARA DTO
    public List<UserResponseDTO> toResponseList(List<User> users) {
        return users.stream().map(UserResponseDTO::new).collect(Collectors.toList());
    }

    public void toResponseUpdate(User user, UserWorkSchedule userWorkSchedule, UserRequestDTO request){
        user.setFullName(request.getFullName());
        user.setCpf(request.getCpf());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setDateBirthday(request.getDateBirthday());
        user.setRole(request.getRole());
        user.setAvatar(request.getAvatar());
        userWorkSchedule.setDailyHours(request.getDailyHours());
        userWorkSchedule.setStartTime(request.getStartTime());
        userWorkSchedule.setEndTime(request.getEndTime());
    }
}
