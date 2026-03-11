package com.example.revconnect.repository;

import com.example.revconnect.entity.NotificationPreference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationPreferenceRepository
        extends JpaRepository<NotificationPreference, Long> {

    Optional<NotificationPreference> findByUserUserId(Long userId);
}