package com.example.revconnect.service;

import com.example.revconnect.dto.PostResponse;
import com.example.revconnect.entity.*;
import com.example.revconnect.repository.*;
import com.example.revconnect.exception.BadRequestException;
import com.example.revconnect.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SavedPostService {

    @Autowired
    private SavedPostRepository savedPostRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    // Save Post
    public String savePost(Long userId, Long postId) {

        if (savedPostRepository
                .findByUserUserIdAndPostPostId(userId, postId)
                .isPresent()) {

            throw new BadRequestException("Post already saved");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found"));

        SavedPost savedPost = new SavedPost();
        savedPost.setUser(user);
        savedPost.setPost(post);

        savedPostRepository.save(savedPost);

        return "Post saved successfully";
    }

    // Unsave Post
    public String unsavePost(Long userId, Long postId) {

        SavedPost savedPost = savedPostRepository
                .findByUserUserIdAndPostPostId(userId, postId)
                .orElseThrow(() -> new ResourceNotFoundException("Saved post not found"));

        savedPostRepository.delete(savedPost);

        return "Post removed from saved list";
    }

    // Get Saved Posts
    public List<PostResponse> getSavedPosts(Long userId) {

        return savedPostRepository.findByUserUserId(userId)
                .stream()
                .map(saved -> new PostResponse(saved.getPost()))
                .toList();
    }
}