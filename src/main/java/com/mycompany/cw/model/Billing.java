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
public class Billing {
    private String invoiceId;
    private Integer payments,creditBalance;
    

    public Billing() {
    }

    public Billing(String invoiceId, Integer payments, Integer creditBalance) {
        this.invoiceId = invoiceId;
        this.payments = payments;
        this.creditBalance = creditBalance;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getPayments() {
        return payments;
    }

    public void setPayments(Integer payments) {
        this.payments = payments;
    }

    public Integer getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(Integer creditBalance) {
        this.creditBalance = creditBalance;
    }

    @Override
    public String toString() {
        return "Billing{" + "invoiceId=" + invoiceId + ", payments=" + payments + ", creditBalance=" + creditBalance + '}';
    }
    
}
