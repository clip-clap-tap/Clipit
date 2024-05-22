package com.clipit.clipitback.model.dto.mapperDTO;

public class HistoryMap {
    private String date;
    private int count;

    private int dateDiff;

    public HistoryMap() {
    }

    public HistoryMap(String date, int count, int dateDiff) {
        this.date = date;
        this.count = count;
        this.dateDiff = dateDiff;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDateDiff() {
        return dateDiff;
    }

    public void setDateDiff(int dateDiff) {
        this.dateDiff = dateDiff;
    }

    @Override
    public String toString() {
        return "HistoryMap{" +
                "date=" + date +
                ", count=" + count +
                '}';
    }
}
