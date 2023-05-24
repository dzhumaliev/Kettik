package com.kg.kettik.models;

public class ToursModel {

    private int id;
    private String title;
    private String date;
    private String day;
    private String image;

    public ToursModel(int id, String title, String date, String day, String image) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.day = day;
        this.image = image;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCount() {
        return day;
    }

    public void setCount(String count) {
        this.day = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
