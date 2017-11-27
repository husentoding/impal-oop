/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import android.content.Context;

import model.*;

/**
 *
 * @author Jorgie Bartelsi P
 */
public class StockModule extends Module {

    public StockModule(Context context) {
        super(context);
    }
    
    //Create new item entry
    public boolean addItem(String iBarcode, String name, String status, int stock, int price, boolean consignment) {
        Item i= new Item(iBarcode, name, status, stock, price, consignment);
        StockModule.db.getItemList().add(i);
        
        //Search the new Item in DB for confirmation
        for (Item i2: db.getItemList()) {
            if (i2.getiBarcode().equals(iBarcode)) {                
                return true;
            }
        }        
        return false;
    }
    
    //Edit an Item in DB
    public boolean editItem(String iBarcode, String name, String status, int stock, int price, boolean consignment) {
        
        //Search for Item with matching iBarcode in DB
        for (Item i: db.getItemList()) {
            if (i.getiBarcode().equals(iBarcode)) {
                i.setName(name);
                i.setStatus(status);
                i.setStock(stock);
                i.setPrice(price);
                i.setConsignment(consignment);
                return true;
            }
        }
        
        return false;
    }
    
    //Delete an Item in DB
    public boolean removeItem(String iBarcode) {
        
        //Search for Item with matching iBarcode in DB
        for (Item i: db.getItemList()) {
            if (i.getiBarcode().equals(iBarcode)) {
                db.getItemList().remove(i);
                return true;
            }
        }
        
        return false;
    }
    
    //Show all item
    public void showStock() {
        for (Item i: db.getItemList())
            System.out.println("Barcode: " + i.getiBarcode() + " Name: " + i.getName() + " Status: " + i.getStatus() + " Stock: " + i.getStock());
    }
}
