package com.clipit.clipitback.model.dto;

public class MarkedVideo extends Video {

    private String userId;
    private String markDate;

    public MarkedVideo() {
    }

    public MarkedVideo(String userId, String markDate) {
        this.userId = userId;
        this.markDate = markDate;
    }

    public MarkedVideo(String id, String title, String url, int videoLength, int index, String userId, String markDate) {
        super(id, title, url, videoLength, index);
        this.userId = userId;
        this.markDate = markDate;
    }

    public String getMarkDate() {
        return markDate;
    }

    public void setMarkDate(String markDate) {
        this.markDate = markDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "MarkedVideo{" +
                "userId='" + userId + '\'' +
                ", markDate='" + markDate + '\'' +
                '}';
    }
}
