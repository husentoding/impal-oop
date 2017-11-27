/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import android.content.Context;

import model.*;
import java.util.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author Jorgie Bartelsi P
 */
public class ReportModule extends Module {
    private final SimpleDateFormat sdf;     //for date format
    private ArrayList<Report> reportList;   //to contain the reports
    
    public ReportModule(Context context) {
        super(context);
        this.sdf = new SimpleDateFormat("yyyy.MM.dd/HH:mm:ss:SS z");
        this.reportList = new ArrayList();
    }

    public ArrayList<Report> getReportList() {
        return reportList;
    }

    public void setReportList(ArrayList<Report> reportList) {
        this.reportList = reportList;
    }
    
    //Generate daily report
    public void generateDReport(Date date) throws Exception {
        boolean reportExist = false; //for checking if a report of the same property already exist
        Report r1;
        Date date1;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date);
        
        //Search Transactions with matching date in DB
        for (Transaction t: db.getTransactionList()) {
            date1 = sdf.parse(t.getTimestamp());
            c2.setTime(date1);
            if ( (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) && (c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR)) ) {
                
                //Check the itemCart of the Transaction
                for ( CartItem ci: t.getItemCart() ) {
                    reportExist = false;
                    
                    //Search ReportList for Report of the Item
                    for ( Report r: this.reportList ) {
                        if ( r.getiBarcode().equals(ci.getItem().getiBarcode()) ) {
                            r.setSold(r.getSold() + ci.getNumber());
                            r.setTotal();
                            reportExist = true;
                            break;
                        }
                    }
                    
                    //If the Item does not have a report, this create one
                    if ( reportExist == false ) {
                        r1 = new Report();
                        r1.setiBarcode(ci.getItem().getiBarcode());
                        r1.setName(ci.getItem().getName());
                        r1.setPrice(ci.getItem().getPrice());
                        r1.setSold(ci.getNumber());
                        r1.setTotal();
                        this.reportList.add(r1); 
                    }                    
                }
            }
        }
    }
    
    //Generate monthly report
    public void generateMReport(Date date) throws Exception {
        boolean reportExist = false; //for checking if a report of the same property already exist
        Report r1;
        Date date1;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date);
        
        //Search Transactions with matching month in DB
        for (Transaction t: db.getTransactionList()) {
            date1 = sdf.parse(t.getTimestamp());
            c2.setTime(date1);
            if ( (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) && (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)) ) {
                
                //Check the itemCart of the Transaction
                for ( CartItem ci: t.getItemCart() ) {
                    reportExist = false;
                    
                    //Search ReportList for Report of the Item
                    for ( Report r: this.reportList ) {
                        if ( r.getiBarcode().equals(ci.getItem().getiBarcode()) ) {
                            r.setSold(r.getSold() + ci.getNumber());
                            r.setTotal();
                            reportExist = true;
                            break;
                        }
                    }
                    
                    //If the Item does not have a report, this create one
                    if ( reportExist == false ) {
                        r1 = new Report();
                        r1.setiBarcode(ci.getItem().getiBarcode());
                        r1.setName(ci.getItem().getName());
                        r1.setPrice(ci.getItem().getPrice());
                        r1.setSold(ci.getNumber());
                        r1.setTotal();
                        this.reportList.add(r1); 
                    }                    
                }
            }
        }
    }
    
    //Generate yearly report
    public void generateYReport(Date date) throws Exception {
        boolean reportExist = false; //for checking if a report of the same property already exist
        Report r1;
        Date date1;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date);
        
        //Search Transactions with matching year in DB
        for (Transaction t: db.getTransactionList()) {
            date1 = sdf.parse(t.getTimestamp());
            c2.setTime(date1);
            if ( (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) ) {
                
                //Check the ItemCart
                for ( CartItem ci: t.getItemCart() ) {
                    reportExist = false;
                    
                    //Search ReportList for Report of the the Item
                    for ( Report r: this.reportList ) {
                        if ( r.getiBarcode().equals(ci.getItem().getiBarcode()) ) {
                            r.setSold(r.getSold() + ci.getNumber());
                            r.setTotal();
                            reportExist = true;
                            break;
                        }
                    }
                    
                    //If the Item does not have a report, this create one
                    if ( reportExist == false ) {
                        r1 = new Report();
                        r1.setiBarcode(ci.getItem().getiBarcode());
                        r1.setName(ci.getItem().getName());
                        r1.setPrice(ci.getItem().getPrice());
                        r1.setSold(ci.getNumber());
                        r1.setTotal();
                        this.reportList.add(r1); 
                    }                    
                }
            }
        }
    }
    
    //Display report
    public void showReport() {
        for (Report r: this.reportList)
            System.out.println("Barcode: " + r.getiBarcode() + "Item: " + r.getName() + "Price: " + r.getPrice() + "Sold: " + r.getSold() + "Total: " + r.getTotal());
    }
    
}
