package com.example.revconnect.repository;

import com.example.revconnect.entity.Block;
import com.example.revconnect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlockRepository extends JpaRepository<Block, Long> {

    Optional<Block> findByBlockerAndBlocked(User blocker, User blocked);

    boolean existsByBlockerUserIdAndBlockedUserId(Long blockerId, Long blockedId);
}