package com.ponto_360.core.user.domain.service.impl;

import com.ponto_360.core.common.exception.UserAlreadyExistsException;
import com.ponto_360.core.user.app.DTO.request.UserRequestDTO;
import com.ponto_360.core.user.app.DTO.response.UserResponseDTO;
import com.ponto_360.core.user.domain.service.UserService;
import com.ponto_360.core.user.infra.db.entity.User;
import com.ponto_360.core.user.infra.db.entity.UserWorkSchedule;
import com.ponto_360.core.user.infra.db.repository.UserRepository;
import com.ponto_360.core.user.mapper.UserMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UsersServiceImpl implements UserService {
    private static final String DEFAULT_PASSWORD = "123456";
    private static final String DEFAULT_AVATAR = "https://cdn.pixabay.com/photo/2023/02/18/11/00/icon-7797704_1280.png";

    @Inject
    UserMapper userMapper;

    @Inject
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponseDTO save(UserRequestDTO requestDTO) {
        userRepository.findByCpf(requestDTO.getCpf())
            .ifPresent(user -> {
                throw new UserAlreadyExistsException("User with CPF " + requestDTO.getCpf() + " already exists");
            });

        UserWorkSchedule userWorkSchedule = new UserWorkSchedule();
        userWorkSchedule.setDailyHours(requestDTO.getDailyHours());
        userWorkSchedule.setStartTime(requestDTO.getStartTime());
        userWorkSchedule.setEndTime(requestDTO.getEndTime());

        User user = userMapper.toEntity(requestDTO);
        user.setPassword(passwordEncoder.encode(DEFAULT_PASSWORD));
        user.setAvatar(DEFAULT_AVATAR);
        user.setUserWorkSchedule(userWorkSchedule);

        userWorkSchedule.setUser(user);
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public List<UserResponseDTO> getAll(String name, String cpf) {
        return userMapper.toResponseList(userRepository.findAllFilter(name, cpf));
    }

    @Override
    public UserResponseDTO getByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toResponse(user);
    }

    @Transactional
    public UserResponseDTO update(String cpf, UserRequestDTO request) {
        User user = userRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("User not found"));

        UserWorkSchedule userWorkSchedule = user.getUserWorkSchedule();
        userMapper.toResponseUpdate(user, userWorkSchedule, request);
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public void delete(String cpf){
        User user = userRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
