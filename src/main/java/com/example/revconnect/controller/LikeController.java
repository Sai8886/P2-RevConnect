package com.example.revconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.revconnect.dto.LikeResponse;
import com.example.revconnect.service.LikeService;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;
    
    @GetMapping("/post/{postId}/count")
    public ResponseEntity<Long> getLikeCount(@PathVariable Long postId) {
        return ResponseEntity.ok(likeService.getLikeCount(postId));
    }

    // LIKE
    @PostMapping("/user/{userId}/post/{postId}")
    public ResponseEntity<String> likePost(@PathVariable Long userId,
                                           @PathVariable Long postId) {

        return ResponseEntity.ok(
                likeService.likePost(userId, postId)
        );
    }
    @GetMapping
    public List<LikeResponse> getAllLikes() {
        return likeService.getAllLikes();
    }
    // UNLIKE
    @DeleteMapping("/user/{userId}/post/{postId}")
    public ResponseEntity<String> unlikePost(@PathVariable Long userId,
                                             @PathVariable Long postId) {

        return ResponseEntity.ok(
                likeService.unlikePost(userId, postId)
        );
    }
}