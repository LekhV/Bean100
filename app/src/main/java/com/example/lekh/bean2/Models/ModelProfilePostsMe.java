package com.example.lekh.bean2.Models;

public class ModelProfilePostsMe {

    private int imgIconPostMe;
    private int imgPostPostMe;

    private String namePostMe;
    private String dataPostMe;
    private String postPostMe;

    public ModelProfilePostsMe(int imgIconPostMe, int imgPostPostMe, String namePostMe, String dataPostMe, String postPostMe) {
        this.imgIconPostMe = imgIconPostMe;
        this.imgPostPostMe = imgPostPostMe;
        this.namePostMe = namePostMe;
        this.dataPostMe = dataPostMe;
        this.postPostMe = postPostMe;
    }

    public int getImgIconPostMe() {
        return imgIconPostMe;
    }

    public void setImgIconPostMe(int imgIconPostMe) {
        this.imgIconPostMe = imgIconPostMe;
    }

    public int getImgPostPostMe() {
        return imgPostPostMe;
    }

    public void setImgPostPostMe(int imgPostPostMe) {
        this.imgPostPostMe = imgPostPostMe;
    }

    public String getNamePostMe() {
        return namePostMe;
    }

    public void setNamePostMe(String namePostMe) {
        this.namePostMe = namePostMe;
    }

    public String getDataPostMe() {
        return dataPostMe;
    }

    public void setDataPostMe(String dataPostMe) {
        this.dataPostMe = dataPostMe;
    }

    public String getPostPostMe() {
        return postPostMe;
    }

    public void setPostPostMe(String postPostMe) {
        this.postPostMe = postPostMe;
    }
}
