/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jorgie Bartelsi P
 */
public class Item {
    private final String iBarcode;
    
    private String name;
    private String status;
    private int stock;
    private int price;
    private boolean consignment;

    public Item(String iBarcode) {
        this.iBarcode = iBarcode;
    }

    public Item(String iBarcode, String name, String status, int stock, int price, boolean consignment) {
        this.iBarcode = iBarcode;
        this.name = name;
        this.status = status;
        this.stock = stock;
        this.price = price;
        this.consignment = consignment;
    }  

    public String getiBarcode() {
        return iBarcode;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isConsignment() {
        return consignment;
    }

    public void setConsignment(boolean consignment) {
        this.consignment = consignment;
    }
    
}
