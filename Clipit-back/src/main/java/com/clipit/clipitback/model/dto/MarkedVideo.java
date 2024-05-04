package com.clipit.clipitback.model.dto;

public class MarkedVideo extends Video{
    String markDate;
    public MarkedVideo(){}

    public MarkedVideo(String markDate) {
        this.markDate = markDate;
    }

    public MarkedVideo(int id, String title, String url, int videoLength, String markDate, String markDate1) {
        super(id, title, url, videoLength, markDate);
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
}
