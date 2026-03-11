package com.example.revconnect.controller;

import com.example.revconnect.dto.NotificationResponse;
import com.example.revconnect.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{userId}")
    public List<NotificationResponse> getNotifications(@PathVariable Long userId) {
        return notificationService.getUserNotifications(userId);
    }

    @GetMapping("/unread/{userId}")
    public List<NotificationResponse> getUnreadNotifications(@PathVariable Long userId) {
        return notificationService.getUnreadNotifications(userId);
    }

    @GetMapping("/unread-count/{userId}")
    public ResponseEntity<Long> getUnreadCount(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getUnreadCount(userId));
    }

    @PutMapping("/read/{notificationId}")
    public String markNotificationAsRead(@PathVariable Long notificationId) {
        return notificationService.markAsRead(notificationId);
    }
}