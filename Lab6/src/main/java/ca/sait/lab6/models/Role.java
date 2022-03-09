/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sait.lab6.models;

import java.io.Serializable;

public class Role implements Serializable {
    private int id;
    private String name;
    
    public Role(){
        
    }
    public Role(int roleID,String roleName){
        this.id = roleID;
        this.name = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
