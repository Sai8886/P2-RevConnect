package com.example.revconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.revconnect.dto.PostResponse;
import com.example.revconnect.service.SavedPostService;

@RestController
@RequestMapping("/api/saved")


public class SavedPostController {


	    @Autowired
	    private SavedPostService savedPostService;

	    @PostMapping("/user/{userId}/post/{postId}")
	    public String savePost(@PathVariable Long userId,
	                           @PathVariable Long postId) {
	        return savedPostService.savePost(userId, postId);
	    }

	    @DeleteMapping("/user/{userId}/post/{postId}")
	    public String unsavePost(@PathVariable Long userId,
	                             @PathVariable Long postId) {
	        return savedPostService.unsavePost(userId, postId);
	    }

	    @GetMapping("/user/{userId}")
	    public List<PostResponse> getSavedPosts(@PathVariable Long userId) {
	        return savedPostService.getSavedPosts(userId);
	    }
	}


