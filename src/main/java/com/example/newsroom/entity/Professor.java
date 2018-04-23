package com.example.newsroom.entity;

public class Professor {
    private int id;
    private String username = new String();
    private String password = new String();
    private String name = new String();
    private int gender;
    private String academicsec = new String();
    private String safeque1 = new String();
    private String safeque2 = new String();
    private String safeque3 = new String();

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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
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

    public void setSafeque1(String safeque1) {
        this.safeque1 = safeque1;
    }

    public String getSafeque1() {
        return safeque1;
    }

    public void setSafeque2(String safeque2) {
        this.safeque2 = safeque2;
    }

    public String getSafeque2() {
        return safeque2;
    }

    public void setSafeque3(String safeque3) {
        this.safeque3 = safeque3;
    }

    public String getSafeque3() {
        return safeque3;
    }
}
