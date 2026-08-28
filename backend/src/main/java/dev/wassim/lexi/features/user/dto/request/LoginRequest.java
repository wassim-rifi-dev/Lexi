package dev.wassim.lexi.features.user.dto.request;

import lombok.Builder;

@Builder
public record LoginRequest(
    String email,

    String password
) {}
