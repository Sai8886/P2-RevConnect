package com.example.revconnect.dto;

public class PostAnalyticsResponse {

    private Long postId;
    private Long totalLikes;
    private Long totalComments;
    private Long totalShares;

    public PostAnalyticsResponse(Long postId, Long totalLikes, Long totalComments, Long totalShares) {
        this.postId = postId;
        this.totalLikes = totalLikes;
        this.totalComments = totalComments;
        this.totalShares = totalShares;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getTotalLikes() {
        return totalLikes;
    }

    public Long getTotalComments() {
        return totalComments;
    }

    public Long getTotalShares() {
        return totalShares;
    }
}