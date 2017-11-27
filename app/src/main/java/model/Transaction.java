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
public class Transaction {
    private final String tID; // yyyyMMddHHmmssSSz + employee ID
    private final Employee tAuthor; // who make the transaction (current account)
    private String timestamp; // yyyy.MM.dd/HH:mm:ss:SS z
    
    private ArrayList<CartItem> itemCart; //list of item in transaction
    private int bill; //total price of items in cart

    public Transaction(String tID, Employee tAuthor, String timestamp) {
        this.tID = tID;
        this.tAuthor = tAuthor;
        this.timestamp = timestamp;
        this.itemCart = new ArrayList<>();
    }

    public String gettID() {
        return tID;
    }

    public Employee gettAuthor() {
        return tAuthor;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public ArrayList<CartItem> getItemCart() {
        return itemCart;
    }

    public void setItemCart(ArrayList<CartItem> itemCart) {
        this.itemCart = itemCart;
    }

    public int getBill() {
        return bill;
    }

    //bill= (item price * item number) for all item in cart
    public void setBill() {
        for (CartItem ci: this.itemCart) {
            this.bill = this.bill + (ci.getItem().getPrice() * ci.getNumber());
        }
    }
    
}