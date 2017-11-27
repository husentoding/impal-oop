/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import database.DatabaseHelper;
import model.*;
import java.util.*;

/**
 *
 * @author Jorgie Bartelsi P
 */
public class DatabaseModule {
    //helper
    DatabaseHelper db;

    //list
    private ArrayList<Employee> employeeList;
    private ArrayList<Item> itemList;
    private ArrayList<Transaction> transactionList;
    private ArrayList<ProcurementOrder> procurementList;
    
    public DatabaseModule(Context context) {
        db= new DatabaseHelper(context);
        employeeList = new ArrayList<>();
        itemList = new ArrayList<>();
        transactionList = new ArrayList<>();
        procurementList = new ArrayList<>();
    }

    public ArrayList<Employee> setEmployeeList(){
        return db.selectAllEmployee();
    }


    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }


    public ArrayList<Item> getItemList() {
        return itemList;
    }


    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }


    public ArrayList<ProcurementOrder> getProcurementList() {
        return procurementList;
    }

    
    /*
    //experimental
    //for transactionList sort
    public void sortTransactionList() {
        Collections.sort(this.transactionList, new TLSort());
    }
    
    class TLSort implements Comparator<Transaction> {            
        @Override
        public int compare(Transaction a, Transaction b) {
            return (a.gettID().compareTo(b.gettID()));
        }
    }
    */
    
}


