package dev.wassim.lexi.features.auth.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.wassim.lexi.domain.modal.User;
import dev.wassim.lexi.features.auth.dto.request.LoginRequest;
import dev.wassim.lexi.features.user.repositories.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email())
                                    .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.password() , user.getPassword())) {
            throw new RuntimeException("Password is incorrect");
        }

        return user;
    }
}
