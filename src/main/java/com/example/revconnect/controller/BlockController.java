package com.example.revconnect.controller;

import com.example.revconnect.service.BlockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/block")
public class BlockController {

    @Autowired
    private BlockService blockService;

    @PostMapping("/{blockerId}/{blockedId}")
    public String blockUser(@PathVariable Long blockerId,
                            @PathVariable Long blockedId) {

        return blockService.blockUser(blockerId, blockedId);
    }

    @DeleteMapping("/{blockerId}/{blockedId}")
    public String unblockUser(@PathVariable Long blockerId,
                              @PathVariable Long blockedId) {

        return blockService.unblockUser(blockerId, blockedId);
    }
}