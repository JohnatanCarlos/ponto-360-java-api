package com.ponto_360.core.user.controller;

import com.ponto_360.core.common.DTO.Response;
import com.ponto_360.core.user.app.DTO.request.UserRequestDTO;
import com.ponto_360.core.user.app.DTO.response.UserResponseDTO;
import com.ponto_360.core.user.domain.service.UserService;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    @Inject
    UserService userService;

    @PostMapping
    public Response<UserResponseDTO> save(@RequestBody UserRequestDTO request) {
        return new Response<>(userService.save(request));
    }
}
