package com.example.gooddeals;

import android.provider.SyncStateContract;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {

    private String name;
    private String surname;
    private String id = UUID.randomUUID().toString();
    private int karma = 10;

    public User() {}

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = UUID.randomUUID().toString();
        this.karma = 10;
    }

    public User(String name, String surname, int karma) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.karma = karma;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getKarma() {
        return karma;
    }

    public void setKarma(int karma) {
        this.karma = karma;
    }

}
