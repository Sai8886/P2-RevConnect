package com.example.revconnect.controller;

import com.example.revconnect.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/share")
public class ShareController {

    @Autowired
    private ShareService shareService;

    @PostMapping("/{userId}/{postId}")
    public String sharePost(@PathVariable Long userId,
                            @PathVariable Long postId) {

        return shareService.sharePost(userId, postId);
    }
}