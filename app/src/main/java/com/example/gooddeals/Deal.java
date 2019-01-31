package com.example.gooddeals;

public class Deal {

    private String id;
    private String title;
    private String discription;
    private String author;
    private Boolean isAvailable;
    private int cost;

    public Deal(String header, String text, int coast, String author, Boolean isAvailable, String id){
        this.title = header;
        this.discription = text;
        this.cost = coast;
        this.author = author;
        this.isAvailable = isAvailable;
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int coast) {
        this.cost = coast;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String header){
        this.title = header;
    }

    public String getDiscription(){
        return discription;
    }

    public void setDiscription(String text){
        this.discription = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
