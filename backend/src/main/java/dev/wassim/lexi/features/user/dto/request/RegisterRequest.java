package dev.wassim.lexi.features.user.dto.request;

import lombok.Builder;

@Builder
public record RegisterRequest(
    String first_name,

    String last_name,

    String username,

    String email,

    String password
) {}
