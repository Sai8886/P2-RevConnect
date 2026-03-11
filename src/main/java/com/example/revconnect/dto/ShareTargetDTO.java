package com.example.revconnect.dto;

/**
 * Represents one user the sharer can send a post to.
 * Carries enough info to render an avatar + name in the share sheet.
 */
public class ShareTargetDTO {

    private Long userId;
    private String userName;
    private String displayName;   // profile.name if set, else userName
    private String profilePic;
    private String accountType;
    private boolean alreadyShared; // true if this user already has a share record for this post

    public ShareTargetDTO() {}

    public ShareTargetDTO(Long userId, String userName, String displayName,
                          String profilePic, String accountType, boolean alreadyShared) {
        this.userId        = userId;
        this.userName      = userName;
        this.displayName   = displayName;
        this.profilePic    = profilePic;
        this.accountType   = accountType;
        this.alreadyShared = alreadyShared;
    }

    public Long getUserId()            { return userId; }
    public void setUserId(Long v)      { this.userId = v; }

    public String getUserName()            { return userName; }
    public void setUserName(String v)      { this.userName = v; }

    public String getDisplayName()         { return displayName; }
    public void setDisplayName(String v)   { this.displayName = v; }

    public String getProfilePic()          { return profilePic; }
    public void setProfilePic(String v)    { this.profilePic = v; }

    public String getAccountType()         { return accountType; }
    public void setAccountType(String v)   { this.accountType = v; }

    public boolean isAlreadyShared()       { return alreadyShared; }
    public void setAlreadyShared(boolean v){ this.alreadyShared = v; }
}