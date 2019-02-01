package com.example.gooddeals;

public class User {

    private String name;
    private String surname;
    private int id;
    private int karma;

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        this.name = userName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String userSurname) {
        this.surname = userSurname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKarma() {
        return karma;
    }

    public void setKarma(int karma) {
        this.karma = karma;
    }
}
