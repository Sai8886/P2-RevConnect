package com.example.revconnect.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.revconnect.dto.PostAnalyticsResponse;
import com.example.revconnect.dto.PostResponse;
import com.example.revconnect.entity.Post;
import com.example.revconnect.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    // Create Post
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/user/{userId}")
    public ResponseEntity<PostResponse> createPost(
            @PathVariable Long userId,
            @RequestBody Post post) {

        return ResponseEntity.ok(postService.createPost(userId, post));
    }

    // Get All Posts
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    // Get Posts By User
    @GetMapping("/user/{viewerId}/{targetUserId}")
    public ResponseEntity<List<Post>> getPostsByUser(
            @PathVariable Long viewerId,
            @PathVariable Long targetUserId) {

        return ResponseEntity.ok(
                postService.getPostsByUser(viewerId, targetUserId));
    }

    // Get Post By Id
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    // Edit Post
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/user/{userId}/post/{postId}")
    public ResponseEntity<String> editPost(
            @PathVariable Long userId,
            @PathVariable Long postId,
            @RequestBody Map<String, String> request) {

        return ResponseEntity.ok(
                postService.editPost(userId, postId, request.get("content")));
    }

    // Delete Post (Admin Only)
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/user/{userId}/post/{postId}")
    public ResponseEntity<String> deletePost(
            @PathVariable Long userId,
            @PathVariable Long postId) {

        return ResponseEntity.ok(
                postService.deletePost(userId, postId));
    }

    // Search by Hashtag
    @GetMapping("/hashtag/{tag}")
    public ResponseEntity<List<PostResponse>> searchByHashtag(
            @PathVariable String tag) {

        return ResponseEntity.ok(
                postService.searchByHashtagResponse(tag));
    }

    // Search by Content
    @GetMapping("/search")
    public ResponseEntity<List<Post>> searchPosts(
            @RequestParam String keyword) {

        return ResponseEntity.ok(
                postService.searchPosts(keyword));
    }

    // Trending Posts
    @GetMapping("/trending")
    public ResponseEntity<List<Post>> getTrendingPosts() {

        return ResponseEntity.ok(
                postService.getTrendingPosts());
    }

    // Unlike Post
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/unlike/user/{userId}/post/{postId}")
    public ResponseEntity<String> unlikePost(
            @PathVariable Long userId,
            @PathVariable Long postId) {

        postService.unlikePost(userId, postId);
        return ResponseEntity.ok("Post unliked successfully");
    }

    // Update Post
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/update/{postId}")
    public ResponseEntity<String> updatePost(
            @PathVariable Long postId,
            @RequestParam Long userId,
            @RequestBody Map<String,String> body) {

        postService.updatePost(postId, userId, body.get("content"));
        return ResponseEntity.ok("Post updated successfully");
    }

    // Share Post
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/share/{postId}")
    public ResponseEntity<String> sharePost(
            @PathVariable Long postId,
            @RequestParam Long userId) {

        postService.sharePost(postId, userId);
        return ResponseEntity.ok("Post shared successfully");
    }

    // Feed (Pagination Enabled)
    @GetMapping("/feed/{userId}")
    public ResponseEntity<List<PostResponse>> getFeed(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<PostResponse> posts = postService.getFeed(userId, pageable);

        return ResponseEntity.ok(posts.getContent());
    }

    // Get User Posts
    @GetMapping("/users/{userId}/posts")
    public ResponseEntity<List<Post>> getUserPosts(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                postService.getPostsByUser(userId));
    }

    // Trending Hashtags
    @GetMapping("/trending/hashtags")
    public ResponseEntity<List<Map<String, Object>>> getTrendingHashtags() {

        return ResponseEntity.ok(
                postService.getTrendingHashtags());
    }

    // Filtered Feed
    @GetMapping("/feed/{userId}/filter")
    public ResponseEntity<List<PostResponse>> getFilteredFeed(
            @PathVariable Long userId,
            @RequestParam String type) {

        return ResponseEntity.ok(
                postService.getFilteredFeed(userId, type));
    }

    // Pin Post
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/pin/{postId}")
    public ResponseEntity<String> pinPost(
            @PathVariable Long postId,
            @RequestParam Long userId) {

        return ResponseEntity.ok(
                postService.pinPost(userId, postId));
    }

    // Unpin Post
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/unpin/{postId}")
    public ResponseEntity<String> unpinPost(
            @PathVariable Long postId,
            @RequestParam Long userId) {

        return ResponseEntity.ok(
                postService.unpinPost(userId, postId));
    }

    // Post Analytics
    @GetMapping("/{postId}/analytics")
    public ResponseEntity<PostAnalyticsResponse> getPostAnalytics(@PathVariable Long postId) {

        return ResponseEntity.ok(postService.getPostAnalytics(postId));
    }
    // Engagement Metrics
    @GetMapping("/engagement/{postId}")
    public ResponseEntity<Map<String, Object>> getEngagementMetrics(
            @PathVariable Long postId) {

        return ResponseEntity.ok(
                postService.getEngagementMetrics(postId));
    }

    // View Post
    @GetMapping("/view/{postId}")
    public ResponseEntity<Post> viewPost(
            @PathVariable Long postId) {

        return ResponseEntity.ok(
                postService.viewPost(postId));
    }

    // Paginated Posts
    @GetMapping("/paginated")
    public Page<PostResponse> getPosts(Pageable pageable) {
        return postService.getPosts(pageable);
    }

    // Sorted Posts
    @GetMapping("/feed/sorted")
    public Page<PostResponse> getSortedPosts(Pageable pageable) {
        return postService.getSortedPosts(pageable);
    }
}