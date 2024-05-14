package com.clipit.clipitback.model.dto;

import java.util.List;

public class Post {
    private int id;
    private String title;
    private String description;
    private String writerId;
    private String status;
    private String createDate;
    private int viewCount;
    private String updateDate;
    private String visitDate;
    private List<Tag> tags;

    private List<Video> videos;

    public Post() {
    }

    public Post(int id, String title, String description, String writerId, String status, String createDate, int viewCount, String updateDate, String visitDate, List<Tag> tags, List<Video> videos) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.writerId = writerId;
        this.status = status;
        this.createDate = createDate;
        this.viewCount = viewCount;
        this.updateDate = updateDate;
        this.visitDate = visitDate;
        this.tags = tags;
        this.videos = videos;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", writerId='" + writerId + '\'' +
                ", status='" + status + '\'' +
                ", createDate='" + createDate + '\'' +
                ", viewCount=" + viewCount +
                ", updateDate='" + updateDate + '\'' +
                ", visitDate='" + visitDate + '\'' +
                ", tags=" + tags +
                ", videos=" + videos +
                '}';
    }
}
