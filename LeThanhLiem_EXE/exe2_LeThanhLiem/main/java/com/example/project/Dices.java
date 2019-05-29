package com.example.project;

public class Dices {
    private int img1, img2;
    private String score;

    public Dices(int img1, int img2, String score) {
        this.img1 = img1;
        this.img2 = img2;
        this.score = score;
    }

    public int getImg1() {
        return img1;
    }

    public int getImg2() {
        return img2;
    }

    public String getScore() {
        return score;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String toString(){
        String s;
        s = img1 + img2 + "";
        return s;
    }
}
