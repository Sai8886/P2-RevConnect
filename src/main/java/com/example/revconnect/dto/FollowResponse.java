package com.example.revconnect.dto;



public class FollowResponse {

    private Long followerId;
    private String followerName;
    private Long followingId;
    private String followingName;
	public Long getFollowerId() {
		return followerId;
	}
	public void setFollowerId(Long followerId) {
		this.followerId = followerId;
	}
	public String getFollowerName() {
		return followerName;
	}
	public void setFollowerName(String followerName) {
		this.followerName = followerName;
	}
	public Long getFollowingId() {
		return followingId;
	}
	public void setFollowingId(Long followingId) {
		this.followingId = followingId;
	}
	public String getFollowingName() {
		return followingName;
	}
	public void setFollowingName(String followingName) {
		this.followingName = followingName;
	}

   
}