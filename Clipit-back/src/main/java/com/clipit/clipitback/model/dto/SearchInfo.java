package com.clipit.clipitback.model.dto;

import java.util.ArrayList;
import java.util.List;

public class SearchInfo {
    private String category;
    private String keyword;
    private List<Integer> ageRange;
    private List<String> bodyParts;
    Integer strength;

    private int limit;
    private int page;

    public SearchInfo() {
        this.category = "all";
        this.keyword = "";
        this.ageRange = new ArrayList<>();
        this.bodyParts = new ArrayList<>();
        this.strength = 0;
    }

    public SearchInfo(String category, String keyword, List<Integer> ageRange, List<String> bodyParts, int strength, int limit, int page) {
        this.category = category;
        this.keyword = keyword;
        this.ageRange = ageRange;
        this.bodyParts = bodyParts;
        this.strength = strength;
        this.limit = limit;
        this.page = page;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Integer> getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(List<Integer> ageRange) {
        this.ageRange = ageRange;
    }

    public List<String> getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(List<String> bodyParts) {
        this.bodyParts = bodyParts;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "SearchInfo{" +
                "category='" + category + '\'' +
                ", keyword='" + keyword + '\'' +
                ", ageRange=" + ageRange +
                ", bodyParts=" + bodyParts +
                ", strength=" + strength +
                ", limit=" + limit +
                ", page=" + page +
                '}';
    }
}
