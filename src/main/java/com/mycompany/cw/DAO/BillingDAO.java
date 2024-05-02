/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.DAO;
import com.mycompany.cw.model.Billing;

/**
 *
 * @author Hashirhalaldeen
 */
import java.util.ArrayList;
import java.util.logging.Logger;
public class BillingDAO {
    private static final Logger log = Logger.getLogger(BillingDAO.class.getName());
    private static ArrayList<Billing> billingList = new ArrayList<>();

    static {
        billingList.add(new Billing("1", 1222, 12212));
        billingList.add(new Billing("2", 1222, 12212));
        billingList.add(new Billing("3", 1222, 12212));
    }

    // Method to add a billing record to the list
    public void addBillingRecord(Billing billingRecord) {
        billingList.add(billingRecord);
        log.info("Billing record added: " + billingRecord);
    }

    // Method to get all billing records
    public ArrayList<Billing> getAllBillingRecords() {
        log.info("Returning all billing records");
        return billingList;
    }

    // Method to get a billing record by invoice ID
    public Billing getBillByInvoiceId(String Id) {
        for (Billing bill : billingList) {
            if (bill.getInvoiceId().equals(Id)) {
                log.info("Billing record found for invoice ID: " + Id);
                return bill;
            }
        }
        log.warning("Billing record not found for invoice ID: " + Id);
        return null;
    }

    // Method to update a billing record
    public void updateBillingRecord(Integer payment, Integer creditBalance, String ID) {
        for (Billing bill : billingList) {
            if (bill.getInvoiceId().equals(ID)) {
                bill.setCreditBalance(creditBalance);
                bill.setPayments(payment);
                log.info("Billing record updated for invoice ID: " + ID);
                return;
            }
        }
        log.warning("Billing record not found for invoice ID: " + ID);
    }

    // Method to remove a billing record
    public void removeBillingRecord(String ID) {
        billingList.removeIf(bill -> bill.getInvoiceId().equals(ID));
        log.info("Billing record removed for invoice ID: " + ID);
    }
}
