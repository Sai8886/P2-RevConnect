package com.example.revconnect.dto;

public class ProfileDTO {

    private Long userId;
    private String userName;
    private String email;
    private String accountType;

    private long totalPosts;
    private long totalFollowers;
    private long totalFollowing;
    private long totalShares;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getTotalPosts() {
		return totalPosts;
	}
	public void setTotalPosts(long totalPosts) {
		this.totalPosts = totalPosts;
	}
	public long getTotalFollowers() {
		return totalFollowers;
	}
	public void setTotalFollowers(long totalFollowers) {
		this.totalFollowers = totalFollowers;
	}
	public long getTotalFollowing() {
		return totalFollowing;
	}
	public void setTotalFollowing(long totalFollowing) {
		this.totalFollowing = totalFollowing;
	}
	public long getTotalShares() {
		return totalShares;
	}
	public void setTotalShares(long totalShares) {
		this.totalShares = totalShares;
	}
	private String name;
	private String bio;
	private String profilePic;
	private String websiteLink;
	private String location;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getBio() { return bio; }
	public void setBio(String bio) { this.bio = bio; }

	public String getProfilePic() { return profilePic; }
	public void setProfilePic(String profilePic) { this.profilePic = profilePic; }

	public String getWebsiteLink() { return websiteLink; }
	public void setWebsiteLink(String websiteLink) { this.websiteLink = websiteLink; }

	public String getLocation() { return location; }
	public void setLocation(String location) { this.location = location; }

    
}