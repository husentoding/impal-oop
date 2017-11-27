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
public class ProcurementModule extends Module {
    private String tempTID;

    public ProcurementModule(Context context) {
        super(context);
    }

    public String getTempTID() {
        return tempTID;
    }

    public void setTempTID(String tempTID) {
        this.tempTID = tempTID;
    }
    
    //Create new ProcurementOrder
    public boolean addOrder(String supplier) {
        String tID;
        String timestamp;
        ProcurementOrder po;
        
        //Get timestamp for tID
        String time = new SimpleDateFormat("yyyyMMddHHmmssSSz").format(new Date());
        
        //Set tID by combining time and Employee ID
        tID = ("P" + time + login.getEmployee().geteID()); //error
        
        //Set TimeStamp
        timestamp = new SimpleDateFormat("yyyy.MM.dd/HH:mm:ss:SS z").format(new Date());
        
        //Create the object
        po = new ProcurementOrder(tID, login.getEmployee(), timestamp, supplier);
        
        //Add the object to DB
        db.getProcurementList().add(po);
        
        //Search newly added order in DB for confirmation
        for (ProcurementOrder po2: db.getProcurementList()) {
            if (po2.gettID().equals(tID)){
                this.tempTID = tID;
                return true;
            }
        }
        
        return false;
    }
    
    //Create new ProcurementOrder
    //No Depedency Version
    public boolean addOrder(String tID, String supplier) {
        String timestamp;
        ProcurementOrder po;
        
        //Set tID by combining time and Employee ID
        tID = ("P" + tID); //error
        
        //Set TimeStamp
        timestamp = new SimpleDateFormat("yyyy.MM.dd/HH:mm:ss:SS z").format(new Date());
        
        //Create the object
        po = new ProcurementOrder(tID, login.getEmployee(), timestamp, supplier);
        
        //Add the object to DB
        db.getProcurementList().add(po);
        
        //Search newly added order in DB for confirmation
        for (ProcurementOrder po2: db.getProcurementList()) {
            if (po2.gettID().equals(tID)) {
                this.tempTID = tID;
                return true;
            }
        }
        
        return false;
    }
    //Change supplier of a ProcurementOrder
    public boolean editSupplier(String tID, String supplier) {
        
        //Search ProcurementOrder with matching tID in DB
        for (ProcurementOrder po: db.getProcurementList()) {
            if (po.gettID().equals(tID)) {
                po.setSupplier(supplier);
                return true;
            }
        }
        
        return false;
    }
    
    //Remove a ProcurementOrder
    public boolean removeOrder(String tID) {
        
        //Search for ProcurementOrder with matching tID in DB
        for (ProcurementOrder po: db.getProcurementList()) {
            if (po.gettID().equals(tID)) {
                db.getProcurementList().remove(po);
                return true;
            }
        }
        
        return false;
    }
    
    //Printout all order ID and author
    public void showProcurementOrder() {
        for (ProcurementOrder po: db.getProcurementList())
            System.out.println("ID: " + po.gettID() + " Author: " + po.gettAuthor().getName());
    }
    
    //Add CartItem to a ProcurementOrder
    public boolean addCartItem(String tID, String iBarcode, int number) {
        
        //Search for ProcurementOrder with matching tID in DB
        for (ProcurementOrder po: db.getProcurementList()) {
            if (po.gettID().equals(tID)) {
                
                //Search for Item with matching iBarcode in DB
                for (Item i: db.getItemList()) {
                    if (i.getiBarcode().equals(iBarcode)) {
                        CartItem temp = new CartItem(i, number);
                        po.getItemCart().add(temp);
                        po.setBill();
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    //Change the number of CartItem in ProcurementOrder's itemCart
    public boolean editCartItem(String tID, String iBarcode, int number) {
        
        //Search for ProcurementOrder with matching tID in DB
        for (ProcurementOrder po: db.getProcurementList()) {
            if (po.gettID().equals(tID)) {
                
                //Search for Item with matching iBarcode in DB
                for (CartItem ci: po.getItemCart()) {
                    if (ci.getItem().getiBarcode().equals(iBarcode)) {
                        ci.setNumber(number);
                        po.setBill();
                        return true;
                    }
                }
            }
        }        
        return false;
    }

    //Remove item from item cart
    public boolean removeCartItem(String tID, String iBarcode) {
        
        //Search for ProcurementOrder with matching tID in DB
        for (ProcurementOrder po: db.getProcurementList()) {
            if (po.gettID().equals(tID)) {
                
                //Search for Item with matching iBarcode in DB
                for (CartItem ci: po.getItemCart()) {
                    if (ci.getItem().getiBarcode().equals(iBarcode)) {
                        po.getItemCart().remove(ci);
                        po.setBill();
                        return true;
                    }
                }
            }
        }        
        return false;
    }
    
}
