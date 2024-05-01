/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.DAO;
import com.mycompany.cw.Billing;

/**
 *
 * @author Hashirhalaldeen
 */
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BillingDAO {
    private static final Logger log = Logger.getLogger(BillingDAO.class.getName());
    private List<Billing> billingList = new ArrayList<>();

   

    // Method to add a billing record to the list
    public void addBillingRecord(Billing billingRecord) {
        billingList.add(billingRecord);
        log.info("Billing record added" );
    }

    // Method to get all billing records
    public List<Billing> getAllBillingRecords() {
        log.info("Billing record returned"); 
        return billingList;
    }

    // Method to update a billing record
    public void updateBillingRecord(Billing oldBillingRecord, Billing newBillingRecord) {
        int index = billingList.indexOf(oldBillingRecord);
        if (index != -1) {
            billingList.set(index, newBillingRecord);
            log.info("Billing record updated" );
        } else {
            log.info("Error: Billing record not found or unable to update");
        }
    }

    // Method to remove a billing record
    public void removeBillingRecord(Billing billingRecord) {
        billingList.remove(billingRecord);
        log.info("Billing record removed");
    }
}

