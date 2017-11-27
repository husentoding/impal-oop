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

//connect item with their number in transaction

public class CartItem{
    private final Item item;
    private int number; //number of item in transaction

    public CartItem(Item item, int number) {
        this.item = item;
        this.number = number;
    }

    public Item getItem() {
        return item;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
}
