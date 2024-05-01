/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw;

/**
 *
 * @author Hashirhalaldeen
 */
 public class Person {
    
    private String name,address;
    private Integer contact;

  public Person(){}
    public Person(String name, String address, Integer contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
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

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "name=" + name + ", address=" + address + ", contact=" + contact;
    }
    
}
