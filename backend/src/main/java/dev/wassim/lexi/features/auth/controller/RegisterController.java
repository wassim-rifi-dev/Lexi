package dev.wassim.lexi.features.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.wassim.lexi.common.constants.ApiPaths;
import dev.wassim.lexi.domain.modal.User;
import dev.wassim.lexi.features.auth.dto.request.RegisterRequest;
import dev.wassim.lexi.features.auth.services.RegisterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(ApiPaths.API_AUTH)
@AllArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping("/register")
    public User register(@RequestBody @Valid RegisterRequest request) {
        return registerService.register(request);
    }
    
}
