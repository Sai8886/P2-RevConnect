package com.example.revconnect.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.revconnect.entity.Block;
import com.example.revconnect.entity.User;
import com.example.revconnect.exception.BadRequestException;
import com.example.revconnect.exception.ResourceNotFoundException;
import com.example.revconnect.repository.BlockRepository;
import com.example.revconnect.repository.UserRepository;

@Service
public class BlockService {

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private UserRepository userRepository;

    public String blockUser(Long blockerId, Long blockedId) {

        if (blockerId.equals(blockedId)) {
            throw new BadRequestException("You cannot block yourself");
        }

        User blocker = userRepository.findById(blockerId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        User blocked = userRepository.findById(blockedId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (blockRepository.findByBlockerAndBlocked(blocker, blocked).isPresent()) {
            throw new BadRequestException("User already blocked");
        }

        Block block = new Block();
        block.setBlocker(blocker);
        block.setBlocked(blocked);
        block.setCreatedAt(LocalDateTime.now());

        blockRepository.save(block);

        return "User blocked successfully";
    }

    public String unblockUser(Long blockerId, Long blockedId) {

        User blocker = userRepository.findById(blockerId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        User blocked = userRepository.findById(blockedId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Block block = blockRepository
                .findByBlockerAndBlocked(blocker, blocked)
                .orElseThrow(() -> new ResourceNotFoundException("Block not found"));

        blockRepository.delete(block);

        return "User unblocked successfully";
    }

    public boolean isBlocked(Long blockerId, Long blockedId) {
        return blockRepository.existsByBlockerUserIdAndBlockedUserId(blockerId, blockedId);
    }
}