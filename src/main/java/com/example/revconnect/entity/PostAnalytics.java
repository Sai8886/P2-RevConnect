package com.example.revconnect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "post_analytics")
public class PostAnalytics {

    @Id
    @Column(name = "post_id")
    private Long postId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "post_id")
    private Post post;

    private Long totalLikes;

    private Long totalShares;

    private Long totalComments;

    public PostAnalytics() {}

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(Long totalLikes) {
        this.totalLikes = totalLikes;
    }

    public Long getTotalShares() {
        return totalShares;
    }

    public void setTotalShares(Long totalShares) {
        this.totalShares = totalShares;
    }

    public Long getTotalComments() {
        return totalComments;
    }

    public void setTotalComments(Long totalComments) {
        this.totalComments = totalComments;
    }
}