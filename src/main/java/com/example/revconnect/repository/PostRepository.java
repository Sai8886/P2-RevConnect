package com.example.revconnect.repository;


import java.util.List;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.revconnect.entity.Post;
import com.example.revconnect.entity.User;

public interface PostRepository extends JpaRepository<Post, Long> {

    // User posts (latest first)
    List<Post> findByUserUserIdOrderByCreatedAtDesc(Long userId);

    // Hashtag search
    List<Post> findByHashtagIgnoreCase(String hashtag);

    // Keyword search
    List<Post> findByContentContainingIgnoreCase(String keyword);

    // Feed posts from multiple users
    List<Post> findByUserUserIdInOrderByCreatedAtDesc(List<Long> userIds);
    Page<Post> findByUserUserIdInOrderByCreatedAtDesc(List<Long> userIds, Pageable pageable);
    // Profile posts (pinned first)
    List<Post> findByUserUserIdOrderByPinnedDescCreatedAtDesc(Long userId);

    // Count posts by user
    long countByUser(User user);


    // Trending posts (based on likes)
    @Query("""
           SELECT p FROM Post p
           LEFT JOIN Like l ON l.post = p
           GROUP BY p
           ORDER BY COUNT(l) DESC
           """)
    List<Post> findTrendingPosts();


    // Trending hashtags
    @Query("""
           SELECT p.hashtag, COUNT(p)
           FROM Post p
           GROUP BY p.hashtag
           ORDER BY COUNT(p) DESC
           """)
    List<Object[]> findTrendingHashtags();


    // Posts from connections
    @Query("""
           SELECT p FROM Post p
           WHERE p.user.userId IN (
               SELECT c.sender.userId
               FROM Connection c
               WHERE c.receiver.userId = :userId
               AND c.status = 'ACCEPTED'
           )
           AND (p.scheduledAt IS NULL OR p.scheduledAt <= CURRENT_TIMESTAMP)
           ORDER BY p.createdAt DESC
           """)
    List<Post> getConnectionPosts(Long userId);


    // Posts from followed users
    @Query("""
           SELECT p FROM Post p
           WHERE p.user.userId IN (
               SELECT f.following.userId
               FROM Follow f
               WHERE f.follower.userId = :userId
           )
           AND (p.scheduledAt IS NULL OR p.scheduledAt <= CURRENT_TIMESTAMP)
           ORDER BY p.createdAt DESC
           """)
    List<Post> getFollowingPosts(Long userId);


    // Posts from creators
    @Query("""
           SELECT p FROM Post p
           WHERE p.user.accountType = 'CREATOR'
           AND (p.scheduledAt IS NULL OR p.scheduledAt <= CURRENT_TIMESTAMP)
           ORDER BY p.createdAt DESC
           """)
    List<Post> getCreatorPosts();


    // Only visible posts (hide future scheduled posts)
    @Query("""
           SELECT p FROM Post p
           WHERE p.scheduledAt IS NULL
           OR p.scheduledAt <= CURRENT_TIMESTAMP
           ORDER BY p.createdAt DESC
           """)
    List<Post> findVisiblePosts();
    @Query("""
    		SELECT p FROM Post p
    		WHERE p.user.userId IN :userIds
    		AND (p.scheduledAt IS NULL OR p.scheduledAt <= CURRENT_TIMESTAMP)
    		ORDER BY p.createdAt DESC
    		""")
    		List<Post> findFeedPosts(List<Long> userIds);
    
        Page<Post> findAll(Pageable pageable);
        Page<Post> findByUserUserIdIn(List<Long> userIds, Pageable pageable);

    
}