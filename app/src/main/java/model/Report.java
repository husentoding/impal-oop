/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author Jorgie Bartelsi P
 */
public class Report {
    private String iBarcode;
    private String name;
    private int price;
    private int sold;
    private int total;

    public Report() {
    }

    public String getiBarcode() {
        return iBarcode;
    }

    public void setiBarcode(String iBarcode) {
        this.iBarcode = iBarcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = ( this.price * this.sold);
    }    
}
