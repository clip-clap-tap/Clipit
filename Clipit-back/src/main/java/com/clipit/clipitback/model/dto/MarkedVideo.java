package com.clipit.clipitback.model.dto;

public class MarkedVideo extends Video {
    private String markDate;

    public MarkedVideo() {
    }

    public MarkedVideo(String markDate) {
        this.markDate = markDate;
    }

    public MarkedVideo(String id, String title, String url, int videoLength, String markDate, int index, String markDate1) {
        super(id, title, url, videoLength, markDate, index);
        this.markDate = markDate1;
    }

    @Override
    public String getMarkDate() {
        return markDate;
    }

    @Override
    public void setMarkDate(String markDate) {
        this.markDate = markDate;
    }

    @Override
    public String toString() {
        return "MarkedVideo{" +
                "markDate='" + markDate + '\'' +
                '}';
    }
}
