package com.clipit.clipitback.model.entity;

import com.clipit.clipitback.model.dto.Tag;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.List;

@Document(indexName = "post")
@Setting(settingPath = "elastic/elastic-token.json")
public class Post {
    @Id
    @Field(type = FieldType.Integer)
    private int id;

    @Field(type = FieldType.Text)
    private String title;
    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Text)
    private String writer;

    @Field(type = FieldType.Text)
    private String status;

    @Field(name = "created_at", type = FieldType.Text)
    private String createDate;


    @Field(name = "view_count", type = FieldType.Integer)
    private int viewCount;

    @Field(name = "updated_at", type = FieldType.Text)
    private String updateDate;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Tag> tags;

    @Field(name = "thumbnail_url", type = FieldType.Text)
    private String thumbnailURL;

    @Field(name = "age_range", type = FieldType.Integer)
    private List<Integer> ageRange;

    @Field(name = "body_part", type = FieldType.Text)
    private List<String> bodyPart;

    @Field(type = FieldType.Integer)
    private String strength;

    public Post() {
    }

    public Post(int id, String title, String description, String writer, String status, String createDate, int viewCount, String updateDate, List<Tag> tags, String thumbnailURL, List<Integer> ageRange, List<String> bodyPart, String strength) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.writer = writer;
        this.status = status;
        this.createDate = createDate;
        this.viewCount = viewCount;
        this.updateDate = updateDate;
        this.tags = tags;
        this.thumbnailURL = thumbnailURL;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
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
