package com.example.revconnect.controller;

import java.util.List;
import java.util.Map;
import com.example.revconnect.dto.FollowResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 import com.example.revconnect.service.FollowService;

@RestController
@RequestMapping("/api/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/{followerId}/{followingId}")
    public String followUser(@PathVariable Long followerId,
                             @PathVariable Long followingId) {
        return followService.followUser(followerId, followingId);
    }

    @DeleteMapping("/{followerId}/{followingId}")
    public String unfollowUser(@PathVariable Long followerId,
                               @PathVariable Long followingId) {
        return followService.unfollowUser(followerId, followingId);
    }

    @GetMapping("/followers/{userId}")
    public List<FollowResponse> getFollowers(@PathVariable Long userId) {
        return followService.getFollowers(userId);
    }
    @GetMapping("/following/count/{userId}")
    public long getFollowingCount(@PathVariable Long userId) {
        return followService.getFollowingCount(userId);
    }
    
    @GetMapping("/following/{userId}")
    public List<FollowResponse> getFollowing(@PathVariable Long userId) {
        return followService.getFollowing(userId);
    }
    @GetMapping("/followers/count/{userId}")
    public long getFollowersCount(@PathVariable Long userId) {
        return followService.getFollowersCount(userId);
    }

 
    @DeleteMapping("/remove/{targetUserId}/{followerId}")
    public String removeFollower(@PathVariable Long targetUserId,
                                 @PathVariable Long followerId) {

        return followService.removeFollower(targetUserId, followerId);
    }
    @GetMapping("/analytics/{userId}")
    public Map<String, Long> getFollowerDemographics(@PathVariable Long userId){
        return followService.getFollowerDemographics(userId);
    }
}