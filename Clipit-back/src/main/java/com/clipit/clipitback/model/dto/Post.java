package com.clipit.clipitback.model.dto;

import java.util.List;

public class Post {
    private int id;
    private String title;
    private String description;
    private String writerId;

    private String writerName;
    private String status;
    private String createDate;
    private String updateDate;
    private int viewCount;
    private String visitDate;
    private List<Tag> tags;
    private List<Video> videos;
    private List<Integer> ageRange;
    private List<String> bodyPart;
    private String strength;

    public Post() {
    }

    public Post(int id, String title, String description, String writerId, String writerName, String status, String createDate, String updateDate, int viewCount, String visitDate, List<Tag> tags, List<Video> videos, List<Integer> ageRange, List<String> bodyPart, String strength) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.writerId = writerId;
        this.writerName = writerName;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.viewCount = viewCount;
        this.visitDate = visitDate;
        this.tags = tags;
        this.videos = videos;
        this.ageRange = ageRange;
        this.bodyPart = bodyPart;
        this.strength = strength;
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

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
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

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
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

    public List<Integer> getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(List<Integer> ageRange) {
        this.ageRange = ageRange;
    }

    public List<String> getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(List<String> bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }
}
