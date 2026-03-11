package com.example.revconnect.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blockId;

    @ManyToOne
    private User blocker;

    @ManyToOne
    private User blocked;

    private LocalDateTime createdAt;

    public Long getBlockId() {
        return blockId;
    }

    public User getBlocker() {
        return blocker;
    }

    public void setBlocker(User blocker) {
        this.blocker = blocker;
    }

    public User getBlocked() {
        return blocked;
    }

    public void setBlocked(User blocked) {
        this.blocked = blocked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}