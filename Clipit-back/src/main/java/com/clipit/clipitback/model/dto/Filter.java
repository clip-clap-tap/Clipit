package com.clipit.clipitback.model.dto;

import java.util.List;

public class Filter {

    private List<Integer> ageRange;
    private List<String> bodyPart;
    private int strength;

    public Filter() {
    }

    public Filter(List<Integer> ageRange, List<String> bodyPart, int strength) {
        this.ageRange = ageRange;
        this.bodyPart = bodyPart;
        this.strength = strength;
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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "ageRange=" + ageRange +
                ", bodyPart=" + bodyPart +
                ", strength='" + strength + '\'' +
                '}';
    }
}
