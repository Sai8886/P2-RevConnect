package com.example.revconnect.mvccontrollers;

import com.example.revconnect.dto.UserSearchResponse;
import com.example.revconnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserSearchMvcController {

    @Autowired
    private UserService userService;

    /**
     * Search users by username or email.
     */
    @GetMapping("/search")
    public String searchUsers(
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "1") Long userId,
            Model model) {

        if (keyword != null && !keyword.isBlank()) {
            try {
                List<UserSearchResponse> results = userService.searchUsers(keyword);
                model.addAttribute("results", results);
            } catch (Exception e) {
                model.addAttribute("noResults", true);
            }
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("userId", userId);
        return "user-search";
    }
}
