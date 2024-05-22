package com.clipit.clipitback.model.dto;

public class FavoriteTag {

    private String userId;
    private int tagId;

    public FavoriteTag() {

    }

    public FavoriteTag(String userId, int tagId) {
        this.userId = userId;
        this.tagId = tagId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "FavoriteTag{" +
                "userId='" + userId + '\'' +
                ", tagId=" + tagId +
                '}';
    }
}
