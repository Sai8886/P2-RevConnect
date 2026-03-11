package com.example.revconnect.repository;

import com.example.revconnect.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUserUserId(Long userId);
}