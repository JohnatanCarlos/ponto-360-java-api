package com.ponto_360.core.auth.domain.service.impl;

import com.ponto_360.core.auth.infra.repository.UserAuthenticated;
import com.ponto_360.core.user.infra.db.repository.UserRepository;
import jakarta.inject.Inject;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Inject
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        return userRepository.findByCpf(cpf)
                .map(UserAuthenticated::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with CPF: " + cpf));
    }
}
