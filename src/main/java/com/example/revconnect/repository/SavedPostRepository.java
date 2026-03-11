package com.example.revconnect.repository;

import com.example.revconnect.entity.SavedPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SavedPostRepository extends JpaRepository<SavedPost, Long> {

    Optional<SavedPost> findByUserUserIdAndPostPostId(Long userId, Long postId);

    List<SavedPost> findByUserUserId(Long userId);
}