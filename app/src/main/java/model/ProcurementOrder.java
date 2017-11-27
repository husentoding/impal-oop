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
public class ProcurementOrder extends Transaction {
    private String supplier;

    public ProcurementOrder(String tID, Employee tAuthor, String timestamp, String supplier) {
        super(tID, tAuthor, timestamp);
        this.supplier = supplier;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
}
