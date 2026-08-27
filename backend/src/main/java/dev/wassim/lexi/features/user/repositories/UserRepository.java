package dev.wassim.lexi.features.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.wassim.lexi.domain.modal.User;

public interface UserRepository extends JpaRepository<User , Long> {
    
}
