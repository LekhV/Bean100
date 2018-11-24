package com.example.lekh.bean2.Models;

import java.util.List;

public class Data {

    public static final int VIEW_PAGER = 0;
    public static final int IMAGE_TYPE = 1;
    public static final int POST_TYPE = 2;

    public int type;
    public int data;
    public String text;
    public String text2;

    public Data(int data, String text, String text2) {
        this.data = data;
        this.text = text;
        this.text2 = text2;
    }

    public Data(int type, String text) {
        this.text = text;
    }

    public Data(int type, String text, String text2, int data) {
        this.type = type;
        this.data = data;
        this.text = text;
        this.text2 = text2;
    }
}

