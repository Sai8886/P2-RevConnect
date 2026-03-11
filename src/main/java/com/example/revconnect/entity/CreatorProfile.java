package com.example.revconnect.entity;

import jakarta.persistence.*;

@Entity

public class CreatorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creatorId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String creatorName;

    @Column(length = 1000)
    private String detailedBio;

    private String socialLinks;

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getDetailedBio() {
		return detailedBio;
	}

	public void setDetailedBio(String detailedBio) {
		this.detailedBio = detailedBio;
	}

	public String getSocialLinks() {
		return socialLinks;
	}

	public void setSocialLinks(String socialLinks) {
		this.socialLinks = socialLinks;
	}
    
}