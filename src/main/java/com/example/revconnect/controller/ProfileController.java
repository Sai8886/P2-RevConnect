package com.example.revconnect.controller;

import com.example.revconnect.dto.ProfileDTO;
import com.example.revconnect.entity.Profile;
import com.example.revconnect.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/{userId}")
    public ResponseEntity<ProfileDTO> getProfile(@PathVariable Long userId) {
        return ResponseEntity.ok(profileService.getProfile(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ProfileDTO> updateProfile(
            @PathVariable Long userId,
            @RequestBody Profile profile) {
        return ResponseEntity.ok(profileService.updateProfile(userId, profile));
    }
}