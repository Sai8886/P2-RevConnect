package com.example.revconnect.repository;

import com.example.revconnect.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByReceiverUserIdOrderByCreatedAtDesc(Long userId);
    List<Notification> findByReceiverUserIdAndIsReadFalse(Long userId);

    long countByReceiverUserIdAndIsReadFalse(Long userId);
}