package com.example.revconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.revconnect.entity.Like;
import com.example.revconnect.entity.Post;

public interface LikeRepository extends JpaRepository <Like,Long> {
	Optional <Like> findByUserUserIdAndPostPostId(Long UserId,Long postId);
	long countByPostPostId(Long postId);
 
	void deleteByPost(Post post);
	}


