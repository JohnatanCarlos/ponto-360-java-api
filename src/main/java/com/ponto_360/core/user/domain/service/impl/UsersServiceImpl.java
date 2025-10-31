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

        User user = userMapper.toEntity(requestDTO);
        return userMapper.toResponse(userRepository.save(user));
    }
}
