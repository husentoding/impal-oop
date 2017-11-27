/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import android.content.Context;

import model.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Jorgie Bartelsi P
 */
public class TransactionModule extends Module {
    private String tempTID; //for ease of use

    public TransactionModule(Context context) {
        super(context);
    }

    public String getTempTID() {
        return tempTID;
    }

    public void setTempTID(String tempTID) {
        this.tempTID = tempTID;
    }

    
    //Add a new transaction
    public boolean addTransaction() {
        String tID;
        String timestamp;
        Transaction t;
        
        //Get timestamp for tID
        String time = new SimpleDateFormat("yyyyMMddHHmmssSSz").format(new Date());
        
        //Set tID by combining time and Employee ID
        tID = ("T" + time + login.getEmployee().geteID());
        
        //Set TimeStamp
        timestamp = new SimpleDateFormat("yyyy.MM.dd/HH:mm:ss:SS z").format(new Date());
        
        //Create the object
        t = new Transaction(tID,login.getEmployee(),timestamp);
        
        //Add the object to DB
        db.getTransactionList().add(t);
        
        //Search newly added order in DB for confirmation
        for (Transaction t2: db.getTransactionList()) {
            if (t2.gettID().equals(tID)) {
                this.tempTID = tID;
                return true;
            }
        }
        return false;
    }    
    
    //Add a new transaction
    //No Dependency Version
    public boolean addTransaction(String tID) {
        String timestamp;
        Transaction t;

        tID = ("T" + tID);
        
        //Set TimeStamp
        timestamp = new SimpleDateFormat("yyyy.MM.dd/HH:mm:ss:SS z").format(new Date());
        
        //Create the object
        t = new Transaction(tID,login.getEmployee(),timestamp);
        
        //Add the object to DB
        db.getTransactionList().add(t);
        
        //Search newly added order in DB for confirmation
        for (Transaction t2: db.getTransactionList()) {
            if (t2.gettID().equals(tID)) {
                this.tempTID = tID;
                return true;
            }
        }
        return false;
    }
    
    //Remove transaction from list
    public boolean removeTransaction(String tID) {
        
        //Search Transaction with matching tID in DB
        for (Transaction t: db.getTransactionList()) {
            if (t.gettID().equals(tID)) {
                db.getTransactionList().remove(t);
                return true;
            }
        }
        return false;
    }
    
    //Add a number of item to item cart of a transaction
    public boolean addCartItem(String tID, String iBarcode, int number) {
        
        //Search Transaction with matching tID in DB
        for (Transaction t: db.getTransactionList()) {            
            if (t.gettID().equals(tID)) {
                
                //Search for Item with matching iBarcode in DB
                for (Item i: db.getItemList()) {                    
                    if (i.getiBarcode().equals(iBarcode)) {
                        CartItem temp = new CartItem(i, number);
                        t.getItemCart().add(temp);
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    //Edit the number of an item in a cart
    public boolean editCartItem(String tID, String iBarcode, int number) {
        
        //Search Transaction with matching tID in DB
        for (Transaction t: db.getTransactionList()) {
            if (t.gettID().equals(tID)) {
                
                //Search for Item with matching iBarcode in DB
                for (CartItem ci: t.getItemCart()) {
                    if (ci.getItem().getiBarcode().equals(iBarcode)) {
                        ci.setNumber(number);
                        t.setBill();
                        return true;
                    }
                }
            }
        }        
        return false;
    }

    //Remove item from item cart
    public boolean removeCartItem(String tID, String iBarcode) {
        
        //Search Transaction with matching tID in DB
        for (Transaction t: db.getTransactionList()) {
            if (t.gettID().equals(tID)) {
                
                //Search for Item with matching iBarcode in DB
                for (CartItem ci: t.getItemCart()) {
                    if (ci.getItem().getiBarcode().equals(iBarcode)) {          
                        t.getItemCart().remove(ci);
                        return true;
                    }
                }
            }
        }        
        
        return false;
    }
    
    //Show All Transaction
    public void showTransaction() {
        for (Transaction t: db.getTransactionList())
            System.out.println("ID: " + t.gettID() + " Author: " + t.gettAuthor().getName());
    }
}
