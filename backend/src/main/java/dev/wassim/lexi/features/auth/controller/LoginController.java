package dev.wassim.lexi.features.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.wassim.lexi.common.constants.ApiPaths;
import dev.wassim.lexi.domain.modal.User;
import dev.wassim.lexi.features.auth.dto.request.LoginRequest;
import dev.wassim.lexi.features.auth.services.LoginService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(ApiPaths.API_AUTH)
@AllArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public User postMethodName(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }
    
}
