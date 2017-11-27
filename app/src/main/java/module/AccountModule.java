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
public class AccountModule extends Module {

    public AccountModule(Context context) {
        super(context);
    }
    
    //Create new account
    public boolean addAccount(int eID, int level, String username, String password, String name, String address) {
        Employee e = new Employee( level, username, password, name, address);
        db.getEmployeeList().add(e);
        
        for (Employee e2: db.getEmployeeList()) {
            if (e2.geteID()==(eID))
                return true;
        }
        return false;
    }
    
    //Replace all attribute/data except eID in an account with new one
    public boolean editAccount(int eID, int level, String username, String password, String name, String address) {
        for (Employee e: db.getEmployeeList()) {
            if (e.geteID()==(eID)) {
                e.setLevel(level);
                e.setUsername(username);
                e.setPassword(password);
                e.setName(name);
                e.setAddress(address);
                return true;
            }
        }
        return false;
    }
    
    //Delete account
    public boolean removeAccount(int eID) {
        for (Employee e: db.getEmployeeList()) {
            if (e.geteID()==(eID)){
                db.getEmployeeList().remove(e);
                return true;
            }
        }
        return false;
    }
    
    //Printout all employee id and name
    public void showAccounts() {
        for (Employee e: db.getEmployeeList())
            System.out.println("ID: " + e.geteID() + " Name: " +e.getName());
    }

}
