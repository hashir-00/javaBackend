/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.DAO;

/**
 *
 * @author Hashirhalaldeen
 */



import com.mycompany.cw.Doctor;
import java.util.ArrayList;


public class DoctorDAO {
    private static ArrayList<Doctor> doctors = new ArrayList<>();

    
    static{
        doctors.add(new Doctor("medical","sss","sssds",32));
    }
  
    // Create operation
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Read operation
    public ArrayList<Doctor> getAllDoctors() {
        return doctors;
    }

    public Doctor getDoctorByName(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equals(name)) {
                return doctor;
            }
        }
        return null; // Doctor not found
    }

    // Update operation
    public void updateDoctor(String name,int contact,String address,String profession ) {
         for(Doctor doctor:doctors){
          if(doctor.getName().equals(name)){
             doctor.setAddress(address);
             doctor.setContact(contact);
             doctor.setProfession(profession);
          }
      }
        // If the doctor is not found, you can throw an exception or handle it according to your requirements
    }

    // Delete operation
    public void deleteDoctor(String name) {
        doctors.removeIf(doctor -> doctor.getName().equals(name));
    }
}
