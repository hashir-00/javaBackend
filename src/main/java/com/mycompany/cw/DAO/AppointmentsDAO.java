/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.DAO;
import com.mycompany.cw.Appointments;
import com.mycompany.cw.Doctor;
import com.mycompany.cw.MedicalRecord;
import com.mycompany.cw.Patient;

/**
 *
 * @author Hashirhalaldeen
 */
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AppointmentsDAO {
    private static ArrayList<Appointments> appointmentsList = new ArrayList<>();
  private static final Logger log = Logger.getLogger(AppointmentsDAO.class.getName());
    
  static{
    
  appointmentsList.add(new Appointments("233","21-12-2009",new Patient(new MedicalRecord(),"ee","sss","sssa",1),"Sss",new Doctor("medical","bean","sssds",32)));
    appointmentsList.add(new Appointments("122","21-12-2009",new Patient(new MedicalRecord(),"ee","bro","sssa",1),"Sss",new Doctor("medical","eansdn","sssds",32)));

  }
    // Method to add an appointment to the list
    public void addAppointment(Appointments appointment) {
        appointmentsList.add(appointment);
    }

    // Method to get all appointments
    public ArrayList<Appointments> getAllAppointments() {
        return appointmentsList;
    }

    // Method to get appointments for a specific patient
    public Appointments getAppointmentsByID(String ID) {
      
        for (Appointments appointment : appointmentsList) {
            if (appointment.getId().equals(ID)) {
                return appointment;
            }
        }return null;
        
    } 
    
    

 

    // Method to remove an appointment
    public void removeAppointment(String ID) {
        appointmentsList.removeIf(appointment -> appointment.getId().equals(ID) );
    }
   
    
    public void updateAppointment(String date,String ID) {
        for (Appointments appointment :appointmentsList){
            if (appointment.getId().equals(ID) ){
                try{
                appointment.setDateTime(date);
            }catch(Exception e){
                log.warning(e.toString());
            }
            }
        }
    }
}

