package com.clipit.clipitback.model.dto;

public class Comment {
    private int id;
    private int postId;
    private String writerId;
    private String writerName;
    private String content;

    public Comment() {
    }

    public Comment(int id, int postId, String writerId, String writerName, String content) {
        this.id = id;
        this.postId = postId;
        this.writerId = writerId;
        this.writerName = writerName;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", postId=" + postId +
                ", writerId='" + writerId + '\'' +
                ", writerName='" + writerName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
