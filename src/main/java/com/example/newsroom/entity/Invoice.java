package com.example.newsroom.entity;

import java.util.Date;

public class Invoice {
    private int id;
    private int id_article;
    private int flag;
    private String format;
    private String receipt_title;
    private String receipt_num;
    private String address;
    private String receiver;
    private int type;
    private int expense;
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

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setReceipt_title(String receipt_title) {
        this.receipt_title = receipt_title;
    }

    public String getReceipt_title() {
        return receipt_title;
    }

    public void setReceipt_num(String receipt_num) {
        this.receipt_num = receipt_num;
    }

    public String getReceipt_num() {
        return receipt_num;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public int getExpense() {
        return expense;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
