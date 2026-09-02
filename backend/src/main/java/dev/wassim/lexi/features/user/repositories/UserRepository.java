package dev.wassim.lexi.features.user.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.wassim.lexi.domain.modal.User;


public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
