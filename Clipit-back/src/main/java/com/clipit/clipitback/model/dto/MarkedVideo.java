package com.clipit.clipitback.model.dto;

public class MarkedVideo extends Video {
    private String markDate;

    public MarkedVideo() {
    }

    public MarkedVideo(String markDate) {
        this.markDate = markDate;
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
