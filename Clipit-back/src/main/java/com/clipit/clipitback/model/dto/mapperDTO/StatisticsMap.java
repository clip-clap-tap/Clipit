package com.clipit.clipitback.model.dto.mapperDTO;

public class StatisticsMap {
    private int count;
    private String bodyPart;
    private String user;

    public StatisticsMap() {
    }

    public StatisticsMap(int count, String bodyPart, String user) {
        this.count = count;
        this.bodyPart = bodyPart;
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
