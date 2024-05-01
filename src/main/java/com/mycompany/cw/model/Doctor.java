/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.model;

import com.mycompany.cw.*;

/**
 *
 * @author Hashirhalaldeen
 */
public class Doctor extends Person{
    private String profession;

    public Doctor() {
    }

    public Doctor(String profession, String name, String address, Integer contact) {
        super(name, address, contact);
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Doctor{" +super.toString()+" "+ "profession=" + profession + '}';
    }
    
    
    
}
