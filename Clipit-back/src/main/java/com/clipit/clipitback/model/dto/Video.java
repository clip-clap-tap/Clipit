package com.clipit.clipitback.model.dto;

public class Video {
    public Video() {
    }

    public Video(int id, String title, String url, int videoLength, String markDate) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.videoLength = videoLength;
        this.markDate = markDate;
    }

    private int id;
    private String title;
    private String url;
    private int videoLength;
    private String markDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(int videoLength) {
        this.videoLength = videoLength;
    }

    public String getMarkDate() {
        return markDate;
    }

    public void setMarkDate(String markDate) {
        this.markDate = markDate;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", videoLength=" + videoLength +
                ", markDate='" + markDate + '\'' +
                '}';
    }
}
