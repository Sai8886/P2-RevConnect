package com.example.revconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.revconnect.entity.Comment;
import com.example.revconnect.entity.Post;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	List<Comment> findByPostPostId(Long postId);
	void deleteByPost(Post post);
	long countByPostPostId(Long postId);

}
