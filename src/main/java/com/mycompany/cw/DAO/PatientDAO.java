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
        patientList.add(new Patient(new MedicalRecord(), "ee", "sss", "sssa", 1, new Billing()));
    }

    // Method to add a patient to the list
    public void addPatient(Patient patient) {
        patientList.add(patient);
        log.info("Patient added: " + patient);
    }

    // Method to get all patients
    public ArrayList<Patient> getAllPatients() {
        log.info("Retrieving all patients");
        return patientList;
    }

    // Method to get a patient by name
    public Patient getPatientByName(String name) {
        for (Patient patient : patientList) {
            if (patient.getName().equals(name)) {
                log.info("Patient found by name: " + name);
                return patient;
            }
        }
        log.warning("Patient not found by name: " + name);
        return null;
    }

    // Method to update a patient
    public void updatePatient(String name, int contact, String address) {
        for (Patient patient : patientList) {
            if (patient.getName().equals(name)) {
                patient.setAddress(address);
                patient.setContact(contact);
                log.info("Patient updated: " + patient);
                return;
            }
        }
        log.warning("Patient not found for update with name: " + name);
    }

    // Method to remove a patient
    public void removePatient(String name) {
        patientList.removeIf(patient -> {
            if (patient.getName().equals(name)) {
                log.info("Patient removed: " + patient);
                return true;
            }
            return false;
        });
    }
}