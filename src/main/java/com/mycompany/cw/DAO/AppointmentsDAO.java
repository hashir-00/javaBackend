/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.DAO;
import com.mycompany.cw.model.Appointments;
import com.mycompany.cw.model.Doctor;
import com.mycompany.cw.model.MedicalRecord;
import com.mycompany.cw.model.Patient;
import com.mycompany.cw.model.Billing;

/**
 *
 * @author Hashirhalaldeen
 */
import java.util.ArrayList;
import java.util.logging.Logger;


public class AppointmentsDAO {
    private static ArrayList<Appointments> appointmentsList = new ArrayList<>();
    private static final Logger log = Logger.getLogger(AppointmentsDAO.class.getName());

    static {
        appointmentsList.add(new Appointments("233", "21-12-2009", new Patient(new MedicalRecord(), "ee", "sss", "sssa", 1, new Billing()), "Sss", new Doctor("medical", "bean", "sssds", 32)));
        appointmentsList.add(new Appointments("122", "21-12-2009", new Patient(new MedicalRecord(), "ee", "bro", "sssa", 1, new Billing()), "Sss", new Doctor("medical", "eansdn", "sssds", 32)));
    }

    // Method to add an appointment to the list
    public void addAppointment(Appointments appointment) {
        appointmentsList.add(appointment);
        log.info("Appointment added: " + appointment);
    }

    // Method to get all appointments
    public ArrayList<Appointments> getAllAppointments() {
        log.info("Retrieving all appointments");
        return appointmentsList;
    }

    // Method to get appointments for a specific patient
    public Appointments getAppointmentsByID(String ID) {
        for (Appointments appointment : appointmentsList) {
            if (appointment.getId().equals(ID)) {
                log.info("Appointment found by ID: " + ID);
                return appointment;
            }
        }
        log.warning("Appointment not found by ID: " + ID);
        return null;
    }

    // Method to remove an appointment
    public void removeAppointment(String ID) {
        appointmentsList.removeIf(appointment -> {
            if (appointment.getId().equals(ID)) {
                log.info("Appointment removed by ID: " + ID);
                return true;
            }
            return false;
        });
    }

    public void updateAppointment(String date, String ID) {
        for (Appointments appointment : appointmentsList) {
            if (appointment.getId().equals(ID)) {
                try {
                    appointment.setDateTime(date);
                    log.info("Appointment updated - Date: " + date + ", ID: " + ID);
                } catch (Exception e) {
                    log.warning("Error updating appointment - " + e.toString());
                }
            }
        }
    }
    
}