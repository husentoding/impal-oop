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
public class Employee {
    private int eID;
    public static int emp_number=0;
    private int level; //Employee level
    private String username;
    private String password;
    private String name;
    private String address;

    public Employee(int level, String username, String password, String name, String address) {
        Employee.emp_number++;
        this.eID = emp_number;
        this.level = level;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public int geteID() {
        return eID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
