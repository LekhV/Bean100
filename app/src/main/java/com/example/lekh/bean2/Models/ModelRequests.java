package com.example.lekh.bean2.Models;

public class ModelRequests {

    private int imgIconFR;

    private String nameFR;
    private String emailFR;

    public ModelRequests(int imgIconFR, String nameFR, String emailFR) {
        this.imgIconFR = imgIconFR;
        this.nameFR = nameFR;
        this.emailFR = emailFR;
    }

    public int getImgIconFR() {
        return imgIconFR;
    }

    public void setImgIconFR(int imgIconFR) {
        this.imgIconFR = imgIconFR;
    }

    public String getNameFR() {
        return nameFR;
    }

    public void setNameFR(String nameFR) {
        this.nameFR = nameFR;
    }

    public String getEmailFR() {
        return emailFR;
    }

    public void setEmailFR(String emailFR) {
        this.emailFR = emailFR;
    }
}
