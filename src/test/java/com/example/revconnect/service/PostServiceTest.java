package com.example.revconnect.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.example.revconnect.entity.Post;
import com.example.revconnect.repository.PostRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPostById() {

        Post post = new Post();
        post.setPostId(1L);

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));

        Post result = postService.getPostById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getPostId());
    }
}