package com.ponto_360.core.user.infra.db.repository;

import com.ponto_360.core.user.infra.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByCpf(String cpf);
}
