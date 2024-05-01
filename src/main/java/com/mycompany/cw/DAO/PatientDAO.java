/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.DAO;

/**
 *
 * @author Hashirhalaldeen
 */
import com.mycompany.cw.model.Billing;
import com.mycompany.cw.model.MedicalRecord;
import java.util.ArrayList;
import java.util.logging.Logger;
import com.mycompany.cw.model.Patient;

public class PatientDAO {
    private static final Logger log = Logger.getLogger(PatientDAO.class.getName());
    private static ArrayList<Patient> patientList = new ArrayList<>();

     static {
     patientList.add(new Patient(new MedicalRecord(),"ee","sss","sssa",1,new Billing()));
  }
  
    // Method to add a patient to the list
    public void addPatient(Patient patient) {
        patientList.add(patient);
        log.info("Patient added" );
    }

    // Method to get all patients
    public ArrayList<Patient> getAllPatients() {
        return patientList;
    }
  public Patient getPatientByName(String guy){
        for(Patient person :patientList){
            if(person.getName().equals(guy)){
                log.info("Person details returned");
                return person;
            }
        }
        return null;
    }
    // Method to update a patient
    public void updatePatient(String name, int contact,String address ) {
      for(Patient patient:patientList){
          if(patient.getName().equals(name)){
              patient.setAddress(address);
              patient.setContact(contact);
          }
      }
    }

    // Method to remove a patient
    public void removePatient(String guy) {
        for (Patient patient : patientList ){
            if (patient.getName().equals(guy)){
                patientList.remove(patient);
                   log.info("Patient removed" );
            }
         log.info("Error: Patient not found or unable to remove");
      
            
        
    }
}
}
