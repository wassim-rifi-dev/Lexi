package dev.wassim.lexi.features.auth.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.wassim.lexi.domain.modal.User;
import dev.wassim.lexi.features.auth.dto.request.RegisterRequest;
import dev.wassim.lexi.features.user.repositories.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("This email is existes.");
        }

        if (userRepository.existsByUsername(request.username())) {
            throw new RuntimeException("This username is already existes.");
        }

        User user = User.builder()
                    .first_name(request.first_name())
                    .last_name(request.last_name())
                    .username(request.username())
                    .email(request.email())
                    .password(passwordEncoder.encode(request.password()))
                    .build();
        
        userRepository.save(user);
        
        return user;
    }
}
