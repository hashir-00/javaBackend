/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.DAO;

/**
 *
 * @author Hashirhalaldeen
 */
import java.util.ArrayList;
import java.util.logging.Logger;
import com.mycompany.cw.model.MedicalRecord;
import com.mycompany.cw.model.Prescription;

public class MedicalRecordDAO {
    private static final Logger log = Logger.getLogger(MedicalRecordDAO.class.getName());
    private static ArrayList<MedicalRecord> medicalRecordList = new ArrayList<>();

    static {
        medicalRecordList.add(new MedicalRecord("123", "test", "ssd", new Prescription()));
        medicalRecordList.add(new MedicalRecord("1273", "test", "ssd", new Prescription()));
    }

    // Method to add a medical record to the list
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordList.add(medicalRecord);
        log.info("Medical record added: " + medicalRecord);
    }

    // Method to get all medical records
    public ArrayList<MedicalRecord> getAllMedicalRecords() {
        log.info("Retrieving all medical records");
        return medicalRecordList;
    }
    
    // Method to get a medical record by ID
    public MedicalRecord getMedicalRecordByID(String ID) {
        for (MedicalRecord mr : medicalRecordList) {
            if (mr.getID().equals(ID)) {
                log.info("Medical record found by ID: " + ID);
                return mr;
            }
        }
        log.warning("Medical record not found by ID: " + ID);
        return null;
    }

    // Method to update a medical record
    public void updateMedicalRecord(String diagnose, String treatment, String ID) {
        for (MedicalRecord mr : medicalRecordList) {
            if (mr.getID().equals(ID)) {
                mr.setDiagnose(diagnose);
                mr.setTreatment(treatment);
                log.info("Medical record updated: " + mr);
                return;
            }
        }
        log.warning("Medical record not found for update with ID: " + ID);
    }

    // Method to remove a medical record
    public void removeMedicalRecord(String ID) {
        medicalRecordList.removeIf(medicalRecord -> {
            if (medicalRecord.getID().equals(ID)) {
                log.info("Medical record removed: " + medicalRecord);
                return true;
            }
            return false;
        });
    }
}
