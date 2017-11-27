/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import model.*;
import java.util.*;

/**
 *
 * @author Jorgie Bartelsi P
 */
public class LoginModule {
    private Employee employee;
    private DatabaseModule db;

    public LoginModule(DatabaseModule db) {
        this.db = db;
        this.employee = null;
    }

    public Employee getEmployee() {
        return employee;
    }

    //Return boolean for easy testing
    public boolean Login(String username, String password) {
        if (this.employee != null)
            return false;
        
        //Find Employee with matching Username and PassWord in DB
        for (Employee e: db.getEmployeeList()){ 
            if (e.getUsername().equals(username) && e.getPassword().equals(password)) {
                this.employee = e;
                return true;
            }                 
        }
        return false;
    }
    
    //For logging Out
    public void Logout() {
        this.employee = null;
    }
}
