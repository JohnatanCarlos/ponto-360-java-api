package com.ponto_360.core.user.controller;

import com.ponto_360.core.common.DTO.response.Response;
import com.ponto_360.core.user.app.DTO.request.UserRequestDTO;
import com.ponto_360.core.user.app.DTO.response.UserResponseDTO;
import com.ponto_360.core.user.domain.service.UserService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    @Inject
    UserService userService;

    @PostMapping
    public Response<UserResponseDTO> save(@RequestBody @Valid UserRequestDTO request) {
        return new Response<>(userService.save(request));
    }

    @GetMapping
    public Response<List<UserResponseDTO>> getAll(@RequestParam(value = "name", required = false) String name,  @RequestParam(value = "cpf", required = false) String cpf) {
        List <UserResponseDTO> users = userService.getAll(name, cpf);
        return new Response<>( users, users.size() );
    }

    @GetMapping(value = "/{cpf}")
    public Response<UserResponseDTO> getById(@PathVariable String cpf){
        return new Response<>(userService.getByCpf(cpf));
    }

    @PutMapping(value = "/{cpf}")
    public Response<UserResponseDTO> update(@PathVariable String cpf, @RequestBody UserRequestDTO request) {
        return new Response<>(userService.update(cpf, request));
    }

    @DeleteMapping(value = "/{cpf}")
    public Response<Void> delete(@PathVariable String cpf){
        userService.delete(cpf);
        return new Response<>();
    }
}
