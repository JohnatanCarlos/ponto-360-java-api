package com.ponto_360.core.user.domain.service.impl;

import com.ponto_360.core.user.app.DTO.request.UserRequestDTO;
import com.ponto_360.core.user.app.DTO.response.UserResponseDTO;
import com.ponto_360.core.user.domain.service.UserService;
import com.ponto_360.core.user.infra.db.entity.User;
import com.ponto_360.core.user.infra.db.entity.UserWorkSchedule;
import com.ponto_360.core.user.infra.db.repository.UserRepository;
import com.ponto_360.core.user.mapper.UserMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Primary
public class UsersServiceImpl implements UserService {
    @Inject
    UserMapper userMapper;

    @Inject
    UserRepository userRepository;

    @Transactional
    public UserResponseDTO save(UserRequestDTO requestDTO) {
        UserWorkSchedule userWorkSchedule = new UserWorkSchedule();
        userWorkSchedule.setDailyHours(requestDTO.getDailyHours());
        userWorkSchedule.setStartTime(requestDTO.getStartTime());
        userWorkSchedule.setEndTime(requestDTO.getEndTime());

        User user = userMapper.toEntity(requestDTO);
        user.setUserWorkSchedule(userWorkSchedule);

        userWorkSchedule.setUser(user);
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public List< UserResponseDTO > getAll() {
        return userMapper.toResponseList(userRepository.findAll());
    }

    @Override
    public UserResponseDTO getByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return userMapper.toResponse(user);
    }

    @Transactional
    public UserResponseDTO update(String cpf, UserRequestDTO request) {
        User user = userRepository.findByCpf(cpf);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        UserWorkSchedule userWorkSchedule = user.getUserWorkSchedule();
        userMapper.toResponseUpdate(user, userWorkSchedule, request);
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public void delete(String cpf){
        User user = userRepository.findByCpf(cpf);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        userRepository.delete(user);
    }
}
