package com.example.revconnect.service;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.revconnect.entity.NotificationType;
import com.example.revconnect.dto.CommentResponse;
import com.example.revconnect.entity.Comment;
import com.example.revconnect.entity.Post;
import com.example.revconnect.entity.User;
import com.example.revconnect.exception.BadRequestException;
import com.example.revconnect.exception.ResourceNotFoundException;
import com.example.revconnect.exception.UnauthorizedException;
import com.example.revconnect.repository.CommentRepository;
import com.example.revconnect.repository.PostRepository;
import com.example.revconnect.repository.UserRepository;

@Service
public class CommentService {
	
	@Autowired
	private NotificationService notificationService;
	
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public CommentResponse addComment(Long userId, Long postId, String content) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found"));

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setContent(content);
        comment.setCreatedAt(LocalDateTime.now());

        Comment savedComment = commentRepository.save(comment);

        notificationService.createNotification(
                user,
                post.getUser(),
                NotificationType.COMMENT,
                user.getUserName() + " commented on your post"
        );

        return mapToDto(savedComment);
    }

    public List<CommentResponse> getCommentsByPost(Long postId) {

        List<Comment> comments = commentRepository.findByPostPostId(postId);

        return comments.stream()
                .map(this::mapToDto)
                .toList();
    }

    public void deleteComment(Long commentId, Long userId) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));

        if (!comment.getUser().getUserId().equals(userId)) {
            throw new UnauthorizedException("You are not authorized to delete this comment");
        }

        commentRepository.delete(comment);
    }

    public Comment replyToComment(Long userId, Long commentId, String content) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Comment parent = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));

        if(content == null || content.trim().isEmpty()){
            throw new BadRequestException("Reply content cannot be empty");
        }

        Comment reply = new Comment();
        reply.setUser(user);
        reply.setPost(parent.getPost());
        reply.setContent(content);
        reply.setParentComment(parent);

        return commentRepository.save(reply);
    }
    private CommentResponse mapToDto(Comment comment) {

        CommentResponse dto = new CommentResponse();

        dto.setCommentId(comment.getCommentId());
        dto.setUserId(comment.getUser().getUserId());
        dto.setUserName(comment.getUser().getUserName());
        dto.setPostId(comment.getPost().getPostId());
        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt());

        return dto;
    }
}