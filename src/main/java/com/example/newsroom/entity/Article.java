package com.example.newsroom.entity;

import java.util.Date;

public class Article {
    private int id;
    private String title;
    private String format;
    private int academicsec;
    private int column;
    private String keyword1_ch = new String();
    private String keyword2_ch = new String();
    private String keyword3_ch = new String();
    private String keyword4_ch = new String();
    private String keyword1_en = new String();
    private String keyword2_en = new String();
    private String keyword3_en = new String();
    private String keyword4_en = new String();
    private String summary_ch = new String();
    private String summary_en = new String();
    private int writer_id;
    private String writers_info = new String();
    private String writer_prefer = new String();
    private String writer_avoid = new String();
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

    public void setKeyword1_ch(String keyword1_ch) {
        this.keyword1_ch = keyword1_ch;
    }

    public String getKeyword1_ch() {
        return keyword1_ch;
    }

    public void setKeyword2_ch(String keyword2_ch) {
        this.keyword2_ch = keyword2_ch;
    }

    public String getKeyword2_ch() {
        return keyword2_ch;
    }

    public void setKeyword3_ch(String keyword3_ch) {
        this.keyword3_ch = keyword3_ch;
    }

    public String getKeyword3_ch() {
        return keyword3_ch;
    }

    public void setKeyword4_ch(String keyword4_ch) {
        this.keyword4_ch = keyword4_ch;
    }

    public String getKeyword4_ch() {
        return keyword4_ch;
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

    public void setSummary_ch(String summary_ch) {
        this.summary_ch = summary_ch;
    }

    public String getSummary_ch() {
        return summary_ch;
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

    public void setDate_pub(Date date_pub) {
        this.date_pub = date_pub;
    }

    public Date getDate_pub() {
        return date_pub;
    }
}
