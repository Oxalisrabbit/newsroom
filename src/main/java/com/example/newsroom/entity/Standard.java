package com.example.newsroom.entity;

import java.util.Date;

public class Standard {
    private int[] num;
    private Date[] ddl;

    public void setNum(int[] num) {
        this.num = num;
    }

    public int[] getNum() {
        return num;
    }

    public void setDdl(Date[] ddl) {
        this.ddl = ddl;
    }

    public Date[] getDdl() {
        return ddl;
    }
}
