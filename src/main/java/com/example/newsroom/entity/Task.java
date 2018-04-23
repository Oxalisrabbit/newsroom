package com.example.newsroom.entity;

import java.util.Date;

public class Task {
    private int id;
    private int id_article;
    private int id_role;
    private String content;
    private int stat;
    private int role;
    private int flag;
    private Date date;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public int getId_role() {
        return id_role;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public int getStat() {
        return stat;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
