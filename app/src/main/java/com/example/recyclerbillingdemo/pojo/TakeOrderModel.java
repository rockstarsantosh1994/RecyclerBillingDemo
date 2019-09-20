package com.example.recyclerbillingdemo.pojo;

import java.io.Serializable;

public class TakeOrderModel implements Serializable {

    public String code;
    public String menu;
    public String quantity;
    public String servesin;
    public String rate;
    public String amount;

    public TakeOrderModel() {

    }

    public TakeOrderModel(String code, String menu, String quantity, String servesin, String rate, String amount) {
        this.code = code;
        this.menu = menu;
        this.quantity = quantity;
        this.servesin = servesin;
        this.rate = rate;
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getServesin() {
        return servesin;
    }

    public void setServesin(String servesin) {
        this.servesin = servesin;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
