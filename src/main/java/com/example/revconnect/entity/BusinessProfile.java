package com.example.revconnect.entity;

import jakarta.persistence.*;

@Entity
public class BusinessProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long businessId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String businessName;

    @Column(length = 1000)
    private String detailedBio;

    private String category;
    private String contactInfo;
    private String businessAddress;
    private String businessHours;

    public BusinessProfile() {}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getDetailedBio() {
		return detailedBio;
	}

	public void setDetailedBio(String detailedBio) {
		this.detailedBio = detailedBio;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public String getBusinessHours() {
		return businessHours;
	}

	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}

}