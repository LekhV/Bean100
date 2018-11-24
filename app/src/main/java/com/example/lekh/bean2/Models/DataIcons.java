package com.example.lekh.bean2.Models;

public class DataIcons {

    public static final int IMAGEMY_TYPE = 0;
    public static final int IMAGENOT_TYPE = 1;

    public int type;
    public int data;
  //  public int img;

    public DataIcons(int type, int data) {//, int img) {
        this.type = type;
        this.data = data;
       // this.img = img;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

  //  public int getImg() {
    //    return img;
    //}

    //public void setImg(int img) {
      //  this.img = img;
    //}
}
