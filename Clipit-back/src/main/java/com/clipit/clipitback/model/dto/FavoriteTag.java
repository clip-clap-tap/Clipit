package com.clipit.clipitback.model.dto;

public class FavoriteTag {

    private String userId;
    private int tagId;
    private String tagName;

    public FavoriteTag() {

    }

    public FavoriteTag(String userId, int tagId) {
        this.userId = userId;
        this.tagId = tagId;
    }

    public FavoriteTag(String userId, int tagId, String tagName) {
        this.userId = userId;
        this.tagId = tagId;
        this.tagName = tagName;
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

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "FavoriteTag{" +
                "userId='" + userId + '\'' +
                ", tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                '}';
    }
}
