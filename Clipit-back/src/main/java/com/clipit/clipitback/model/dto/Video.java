package com.clipit.clipitback.model.dto;

public class Video {

    private String id;
    private String title;
    private String url;
    private int videoLength;


    private int index;

    public Video() {
    }

    public Video(String id, String title, String url, int videoLength, int index) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.videoLength = videoLength;

        this.index = index;
    }

    public String getVideoId() { return id;}
    public void setVideoId(String id) { this.id = id;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
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



    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", videoLength=" + videoLength + '\'' +
                '}';
    }
}
