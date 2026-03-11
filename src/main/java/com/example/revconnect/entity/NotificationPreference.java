package com.example.revconnect.entity;

import jakarta.persistence.*;

@Entity
public class NotificationPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private boolean likeNotifications = true;
    private boolean commentNotifications = true;
    private boolean followNotifications = true;
    private boolean shareNotifications = true;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLikeNotifications() {
        return likeNotifications;
    }

    public void setLikeNotifications(boolean likeNotifications) {
        this.likeNotifications = likeNotifications;
    }

    public boolean isCommentNotifications() {
        return commentNotifications;
    }

    public void setCommentNotifications(boolean commentNotifications) {
        this.commentNotifications = commentNotifications;
    }

    public boolean isFollowNotifications() {
        return followNotifications;
    }

    public void setFollowNotifications(boolean followNotifications) {
        this.followNotifications = followNotifications;
    }

    public boolean isShareNotifications() {
        return shareNotifications;
    }

    public void setShareNotifications(boolean shareNotifications) {
        this.shareNotifications = shareNotifications;
    }
}