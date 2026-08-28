package dev.wassim.lexi.features.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record RegisterRequest(
    String first_name,

    String last_name,

    @NotBlank(message = "Username is required")
    String username,

    @NotBlank(message = "Email is required")
    @Email
    String email,

    @NotBlank(message = "Password is required")
    @Size(min = 8)
    String password
) {}
