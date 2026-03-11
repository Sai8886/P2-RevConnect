package com.example.revconnect.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "follow")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followId; 

    @ManyToOne  //many people followign from one user based
    @JoinColumn(name = "follower_id") //primarykey
    private User follower;

    @ManyToOne
    @JoinColumn(name = "following_id")
    private User following;

    private LocalDateTime createdAt;
  
    // Getters & Setters

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowing() {
        return following;
    }

    public void setFollowing(User following) {
        this.following = following;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}