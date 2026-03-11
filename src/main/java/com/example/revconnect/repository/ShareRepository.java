package com.example.revconnect.repository;

import com.example.revconnect.entity.Share;
import com.example.revconnect.entity.Post;
import com.example.revconnect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShareRepository extends JpaRepository<Share, Long> {

    Optional<Share> findByUserAndPost(User user, Post post);
    long countByUser(User user);
    void deleteByPost(Post post);
    long countByPostPostId(Long postId);
}