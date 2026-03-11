package com.example.revconnect.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.revconnect.dto.RegisterRequest;
import com.example.revconnect.dto.ResetPasswordRequest;
import com.example.revconnect.dto.UserSearchResponse;
import com.example.revconnect.entity.User;
import com.example.revconnect.service.FollowService;
import com.example.revconnect.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // Logger
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private FollowService followService;

    @Autowired
    private UserService userService;

    // ================= REGISTER =================

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {

        logger.info("Register request received for email: {}", request.getEmail());

        User user = new User();
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setAccountType(request.getAccountType());
        user.setSecurityQuestion(request.getSecurityQuestion());
        user.setSecurityAnswer(request.getSecurityAnswer());

        User savedUser = userService.registerUser(user);

        logger.info("User registered successfully with id: {}", savedUser.getUserId());

        return ResponseEntity.ok(savedUser);
    }

    // ================= GET ALL USERS =================

    @GetMapping
    public ResponseEntity<List<User>> getAll() {

        logger.info("Fetching all users");

        return ResponseEntity.ok(userService.getAllUsers());
    }

    // ================= GET USER BY ID =================

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        logger.info("Fetching user with id: {}", id);

        return ResponseEntity.ok(userService.getUserById(id));
    }

    // ================= UPDATE USER =================

    @PutMapping("/id/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestBody User user) {

        logger.info("Updating user with id: {}", id);

        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    // ================= DELETE USER =================

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {

        logger.warn("Deleting user with id: {}", id);

        userService.deleteUser(id);

        return ResponseEntity.ok("User deleted successfully");
    }

    // ================= SEARCH USERS =================

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<UserSearchResponse>> searchUsers(
            @PathVariable String keyword) {

        logger.info("Searching users with keyword: {}", keyword);

        return ResponseEntity.ok(userService.searchUsers(keyword));
    }

    // ================= UPDATE PRIVACY =================

    @PutMapping("/{userId}/privacy")
    public ResponseEntity<String> updatePrivacy(
            @PathVariable Long userId,
            @RequestParam boolean isPrivate) {

        logger.info("Updating privacy for userId: {} to {}", userId, isPrivate);

        return ResponseEntity.ok(
                userService.updatePrivacy(userId, isPrivate)
        );
    }

    // ================= FOLLOWERS COUNT =================

    @GetMapping("/{userId}/followers-count")
    public ResponseEntity<Long> getFollowersCount(@PathVariable Long userId) {

        logger.info("Fetching followers count for userId: {}", userId);

        return ResponseEntity.ok(
                followService.getFollowersCount(userId)
        );
    }

    // ================= FOLLOWING COUNT =================

    @GetMapping("/{userId}/following-count")
    public ResponseEntity<Long> getFollowingCount(@PathVariable Long userId) {

        logger.info("Fetching following count for userId: {}", userId);

        return ResponseEntity.ok(
                followService.getFollowingCount(userId)
        );
    }

    // ================= LOGIN =================

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {

        logger.info("Login attempt for email: {}", loginRequest.getEmail());

        User user = userService.loginUser(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        logger.info("Login successful for email: {}", loginRequest.getEmail());

        return ResponseEntity.ok(user);
    }

    // ================= FOLLOWER DEMOGRAPHICS =================

    @GetMapping("/{userId}/follower-demographics")
    public ResponseEntity<Map<String, Long>> getFollowerDemographics(@PathVariable Long userId) {

        logger.info("Fetching follower demographics for userId: {}", userId);

        return ResponseEntity.ok(userService.getFollowerDemographics(userId));
    }
    
    @GetMapping("/security-question")
    public ResponseEntity<String> getSecurityQuestion(@RequestParam String email) {

        String question = userService.getSecurityQuestion(email);

        return ResponseEntity.ok(question);
    }
    @PostMapping("/forgot-password/reset")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {

        userService.resetPassword(request);

        return ResponseEntity.ok("Password reset successful");
    }
    // ================= UPDATE BUSINESS PROFILE =================

    @PutMapping("/{userId}/business-profile")
    public ResponseEntity<User> updateBusinessProfile(
            @PathVariable Long userId,
            @RequestBody User user) {

        logger.info("Updating business profile for userId: {}", userId);

        return ResponseEntity.ok(
                userService.updateBusinessProfile(userId, user)
        );
    }
}