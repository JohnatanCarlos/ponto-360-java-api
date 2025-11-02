package com.ponto_360.core.user.infra.db.repository;

import com.ponto_360.core.user.app.DTO.response.UserResponseDTO;
import com.ponto_360.core.user.infra.db.entity.User;

import java.util.List;

public interface UserRepositoryFilter {
    List<User> findAllFilter(String name, String cpf);
}
