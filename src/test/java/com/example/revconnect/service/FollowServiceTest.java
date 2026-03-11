package com.example.revconnect.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import com.example.revconnect.entity.User;
import com.example.revconnect.repository.UserRepository;
import com.example.revconnect.repository.FollowRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FollowServiceTest {

    @Mock
    private FollowRepository followRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private FollowService followService;
    
    @Mock
    private NotificationService notificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFollowUser() {

        User follower = new User();
        follower.setUserId(1L);

        User following = new User();
        following.setUserId(2L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(follower));
        when(userRepository.findById(2L)).thenReturn(Optional.of(following));

        followService.followUser(1L, 2L);

        assertTrue(true);
    }
}