package com.example.newsroom.entity;

import java.util.Date;

public class Article {
    private int id;
    private String title;
    private String format;
    private int academicsec;
    private int column;
    private String keyword1_cn = new String();
    private String keyword2_cn = new String();
    private String keyword3_cn = new String();
    private String keyword4_cn = new String();
    private String keyword1_en = new String();
    private String keyword2_en = new String();
    private String keyword3_en = new String();
    private String keyword4_en = new String();
    private String summary_cn = new String();
    private String summary_en = new String();
    private int writer_id;
    private String writers_info = new String();
    private String writer_prefer = new String();
    private String writer_avoid = new String();
    private Date date_sub;
    private Date date_pub;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setAcademicsec(int academicsec) {
        this.academicsec = academicsec;
    }

    public int getAcademicsec() {
        return academicsec;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public void setKeyword1_cn(String keyword1_cn) {
        this.keyword1_cn = keyword1_cn;
    }

    public String getKeyword1_cn() {
        return keyword1_cn;
    }

    public void setKeyword2_cn(String keyword2_cn) {
        this.keyword2_cn = keyword2_cn;
    }

    public String getKeyword2_cn() {
        return keyword2_cn;
    }

    public void setKeyword3_cn(String keyword3_cn) {
        this.keyword3_cn = keyword3_cn;
    }

    public String getKeyword3_cn() {
        return keyword3_cn;
    }

    public void setKeyword4_cn(String keyword4_cn) {
        this.keyword4_cn = keyword4_cn;
    }

    public String getKeyword4_cn() {
        return keyword4_cn;
    }

    public void setKeyword1_en(String keyword1_en) {
        this.keyword1_en = keyword1_en;
    }

    public String getKeyword1_en() {
        return keyword1_en;
    }

    public void setKeyword2_en(String keyword2_en) {
        this.keyword2_en = keyword2_en;
    }

    public String getKeyword2_en() {
        return keyword2_en;
    }

    public void setKeyword3_en(String keyword3_en) {
        this.keyword3_en = keyword3_en;
    }

    public String getKeyword3_en() {
        return keyword3_en;
    }

    public void setKeyword4_en(String keyword4_en) {
        this.keyword4_en = keyword4_en;
    }

    public String getKeyword4_en() {
        return keyword4_en;
    }

    public void setSummary_cn(String summary_cn) {
        this.summary_cn = summary_cn;
    }

    public String getSummary_cn() {
        return summary_cn;
    }

    public void setSummary_en(String summary_en) {
        this.summary_en = summary_en;
    }

    public String getSummary_en() {
        return summary_en;
    }

    public void setWriter_id(int writer_id) {
        this.writer_id = writer_id;
    }

    public int getWriter_id() {
        return writer_id;
    }

    public void setWriters_info(String writers_info) {
        this.writers_info = writers_info;
    }

    public String getWriters_info() {
        return writers_info;
    }

    public void setWriter_prefer(String writer_prefer) {
        this.writer_prefer = writer_prefer;
    }

    public String getWriter_prefer() {
        return writer_prefer;
    }

    public void setWriter_avoid(String writer_avoid) {
        this.writer_avoid = writer_avoid;
    }

    public String getWriter_avoid() {
        return writer_avoid;
    }

    public void setDate_sub(Date date_sub) {
        this.date_sub = date_sub;
    }

    public Date getDate_sub() {
        return date_sub;
    }

    public void setDate_pub(Date date_pub) {
        this.date_pub = date_pub;
    }

    public Date getDate_pub() {
        return date_pub;
    }
}
