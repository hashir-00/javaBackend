/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.DAO;

/**
 *
 * @author Hashirhalaldeen
 */



import com.mycompany.cw.model.Doctor;
import java.util.ArrayList;
import java.util.logging.Logger;

public class DoctorDAO {
    private static final Logger log = Logger.getLogger(DoctorDAO.class.getName());
    private static ArrayList<Doctor> doctors = new ArrayList<>();

    static {
        doctors.add(new Doctor("medical", "sss", "sssds", 32));
    }

    // Create operation
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        log.info("Doctor added: " + doctor);
    }

    // Read operation
    public ArrayList<Doctor> getAllDoctors() {
        log.info("Retrieving all doctors");
        return doctors;
    }

    public Doctor getDoctorByName(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equals(name)) {
                log.info("Doctor found by name: " + name);
                return doctor;
            }
        }
        log.warning("Doctor not found by name: " + name);
        return null; // Doctor not found
    }

    // Update operation
    public void updateDoctor(String name, int contact, String address, String profession) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equals(name)) {
                doctor.setAddress(address);
                doctor.setContact(contact);
                doctor.setProfession(profession);
                log.info("Doctor updated: " + doctor);
                return;
            }
        }
        log.warning("Doctor not found for update with name: " + name);
        // If the doctor is not found, you can throw an exception or handle it according to your requirements
    }

    // Delete operation
    public void deleteDoctor(String name) {
        doctors.removeIf(doctor -> {
            if (doctor.getName().equals(name)) {
                log.info("Doctor removed: " + doctor);
                return true;
            }
            return false;
        });
    }
}
