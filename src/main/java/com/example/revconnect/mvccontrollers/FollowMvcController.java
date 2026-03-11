package com.example.revconnect.mvccontrollers;

import com.example.revconnect.dto.FollowResponse;
import com.example.revconnect.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/follow")
public class FollowMvcController {

    @Autowired
    private FollowService followService;

    /**
     * Follow a user — triggered from feed or profile page.
     */
    @PostMapping("/{targetUserId}")
    public String followUser(
            @PathVariable Long targetUserId,
            @RequestParam Long userId,
            @RequestParam(defaultValue = "") String redirectTo,
            RedirectAttributes redirectAttributes) {

        try {
            followService.followUser(userId, targetUserId);
            redirectAttributes.addFlashAttribute("successMessage", "Now following!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        String redirect = redirectTo.isEmpty()
                ? "/profile?userId=" + userId + "&targetUserId=" + targetUserId
                : redirectTo;
        return "redirect:" + redirect;
    }

    /**
     * Unfollow a user.
     */
    @PostMapping("/{targetUserId}/unfollow")
    public String unfollowUser(
            @PathVariable Long targetUserId,
            @RequestParam Long userId,
            @RequestParam(defaultValue = "") String redirectTo,
            RedirectAttributes redirectAttributes) {

        try {
            followService.unfollowUser(userId, targetUserId);
            redirectAttributes.addFlashAttribute("successMessage", "Unfollowed.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        String redirect = redirectTo.isEmpty()
                ? "/profile?userId=" + userId + "&targetUserId=" + targetUserId
                : redirectTo;
        return "redirect:" + redirect;
    }

    /**
     * View followers list page.
     */
    @GetMapping("/followers")
    public String viewFollowers(
            @RequestParam Long userId,
            Model model) {

        List<FollowResponse> followers = followService.getFollowers(userId);
        long followerCount = followService.getFollowersCount(userId);

        model.addAttribute("followers", followers);
        model.addAttribute("followerCount", followerCount);
        model.addAttribute("userId", userId);
        model.addAttribute("pageTitle", "Followers");

        return "followers";
    }

    /**
     * View following list page.
     */
    @GetMapping("/following")
    public String viewFollowing(
            @RequestParam Long userId,
            Model model) {

        List<FollowResponse> following = followService.getFollowing(userId);
        long followingCount = followService.getFollowingCount(userId);

        model.addAttribute("following", following);
        model.addAttribute("followingCount", followingCount);
        model.addAttribute("userId", userId);
        model.addAttribute("pageTitle", "Following");

        return "following";
    }

    /**
     * Remove a follower (from the current user's followers list).
     */
    @PostMapping("/remove/{followerId}")
    public String removeFollower(
            @PathVariable Long followerId,
            @RequestParam Long userId,
            RedirectAttributes redirectAttributes) {

        followService.removeFollower(userId, followerId);
        redirectAttributes.addFlashAttribute("successMessage", "Follower removed.");
        return "redirect:/follow/followers?userId=" + userId;
    }
}
