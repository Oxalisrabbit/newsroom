package com.example.newsroom.entity;

public class Professor {

    private int id;
    private String password;
    private String name;
    private int gender;
    private int card;
    private int academicsec1;
    private int academicsec2;
    private int academicsec3;
    private String safeque1;
    private String safeque2;
    private String safeque3;
    private String username;
    private int alive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public int getCard() {
        return card;
    }

    public void setAcademicsec3(int academicsec3) {
        this.academicsec3 = academicsec3;
    }

    public int getAcademicsec3() {
        return academicsec3;
    }

    public void setAcademicsec2(int academicsec2) {
        this.academicsec2 = academicsec2;
    }

    public int getAcademicsec2() {
        return academicsec2;
    }

    public void setAcademicsec1(int academicsec1) {
        this.academicsec1 = academicsec1;
    }

    public int getAcademicsec1() {
        return academicsec1;
    }

    public String getSafeque1() {
        return safeque1;
    }

    public void setSafeque1(String safeque1) {
        this.safeque1 = safeque1;
    }

    public String getSafeque2() {
        return safeque2;
    }

    public void setSafeque2(String safeque2) {
        this.safeque2 = safeque2;
    }

    public String getSafeque3() {
        return safeque3;
    }

    public void setSafeque3(String safeque3) {
        this.safeque3 = safeque3;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAlive() {
        return alive;
    }

    public void setAlive(int alive) {
        this.alive = alive;
    }
}
