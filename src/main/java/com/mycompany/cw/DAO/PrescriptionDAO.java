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
import java.util.List;
import java.util.logging.Logger;
import com.mycompany.cw.Prescription;

public class PrescriptionDAO {
    private static final Logger log = Logger.getLogger(PrescriptionDAO.class.getName());
    private static ArrayList<Prescription> prescriptionList = new ArrayList<>();

 
   static {
        prescriptionList.add(new Prescription("2","23","34df","fe3df",21));
    }
    
    // Method to add a prescription to the list
    public void addPrescription(Prescription prescription) {
        prescriptionList.add(prescription);
        log.info("Prescription added" );
    }

    // Method to get all prescriptions
    public ArrayList<Prescription> getAllPrescriptions() {
        return prescriptionList;
    }
public Prescription getPrescriptionByID(String id){
        for(Prescription prescription :prescriptionList){
            if(prescription.getId().equals(id)){
                log.info("Person details returned");
                return prescription;
            }
        }
        return null;
    }
    // Method to update a prescription
    public void updatePrescription(String id,String dosage,String prescribedMedics,String instructions,Integer duration) {
        for(Prescription prescription:prescriptionList){
            if(prescription.getId().equals(id)){
                prescription.setDosage(dosage);
                prescription.setDuration(duration);
                prescription.setInstructions(instructions);
                prescription.setPrescribedMedics(prescribedMedics);
            }
        }
        
    }

    // Method to remove a prescription
    public void removePrescription(String id) {
       prescriptionList.removeIf(prescription -> prescription.getId().equals(id));
    }
}
