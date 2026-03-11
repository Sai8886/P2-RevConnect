package com.example.revconnect.dto;

import java.time.LocalDateTime;



import com.example.revconnect.entity.Post;

public class PostResponse {

    private Long postId;
    private String content;
    private String hashtag;
    private LocalDateTime createdAt;
    private String userName;
    private boolean shared;
    private Long originalPostId;
    private String imageUrl;
    private Boolean pinned;
    
    private String ctaLabel;
    public String getCtaLabel() {
		return ctaLabel;
	}

	public void setCtaLabel(String ctaLabel) {
		this.ctaLabel = ctaLabel;
	}

	public String getCtaLink() {
		return ctaLink;
	}

	public void setCtaLink(String ctaLink) {
		this.ctaLink = ctaLink;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductLink() {
		return productLink;
	}

	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}
	private String ctaLink;

    private String productName;
    private String productLink;


    // Empty constructor
    public PostResponse() {
    }

    // Constructor to convert Post entity → PostResponse DTO
    public PostResponse(Post post) {
        this.postId = post.getPostId();
        this.content = post.getContent();
        this.hashtag = post.getHashtag();
        this.createdAt = post.getCreatedAt();
        this.imageUrl = post.getImageUrl();  // ADD THIS LINE
        this.pinned = false;
        this.ctaLabel = post.getCtaLabel();
        this.ctaLink = post.getCtaLink();
        this.productName = post.getProductName();
        this.productLink = post.getProductLink();

        if (post.getUser() != null) {
            this.userName = post.getUser().getUserName();
        }

        if (post.getOriginalPost() != null) {
            this.shared = true;
            this.originalPostId = post.getOriginalPost().getPostId();
        } else {
            this.shared = false;
        }
    }

    // Getters and Setters
    
    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public Long getOriginalPostId() {
        return originalPostId;
    }

    public void setOriginalPostId(Long originalPostId) {
        this.originalPostId = originalPostId;
    }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}