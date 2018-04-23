package com.example.newsroom.entity;

public class Professor_ {
    private int id;
    private String username = new String();
    private String name = new String();
    private int gender;
    private String academicsec = new String();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        return gender;
    }

    public void setAcademicsec(String academicsec) {
        this.academicsec = academicsec;
    }

    public String getAcademicsec() {
        return academicsec;
    }
}
