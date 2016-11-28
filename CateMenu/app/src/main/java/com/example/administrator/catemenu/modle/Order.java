package com.example.administrator.catemenu.modle;

/**
 * Created by Administrator on 2016/11/28.
 */
public class Order {
    int image;
    String name;
    String caiZi;
    double price;
    int number;
    String state;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaiZi() {
        return caiZi;
    }

    public void setCaiZi(String caiZi) {
        this.caiZi = caiZi;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
