package com.example.revconnect.controller;

import com.example.revconnect.entity.NotificationPreference;
import com.example.revconnect.service.NotificationPreferenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification-preferences")
public class NotificationPreferenceController {

    @Autowired
    private NotificationPreferenceService preferenceService;

    @GetMapping("/{userId}")
    public NotificationPreference getPreferences(@PathVariable Long userId) {
        return preferenceService.getPreferences(userId);
    }

    @PutMapping("/{userId}")
    public NotificationPreference updatePreferences(
            @PathVariable Long userId,
            @RequestBody NotificationPreference pref) {

        return preferenceService.updatePreferences(userId, pref);
    }
}