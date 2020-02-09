package com.example.freshmarket.model;

public class ModelpagerViewe {
    private int img;
    private  String des,title;

    public ModelpagerViewe(int img, String title , String des) {
        this.img = img;
        this.des = des;
        this.title = title;
    }

    public ModelpagerViewe(int img) {
        this.img = img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }
}
