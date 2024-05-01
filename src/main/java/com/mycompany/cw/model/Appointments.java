/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.model;



/**
 *
 * @author Hashirhalaldeen
 */
public class Appointments {
   
    private String Id;
    private String dateTime;
    private Patient patientName;
    private Doctor doctorName;
  private String patientsParticipant;
   
  

   
  

    public  Appointments(){}
    
    public Appointments(String Id,String dateTime, Patient patientName,String patientsParticipant,Doctor doctorName){
         this.Id=Id;
         this.patientsParticipant=patientsParticipant;
        this.dateTime = dateTime;
        this.patientName = patientName;
        this.doctorName = doctorName;
        
       
    }  
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
public Patient getPatientName() {
        return patientName;
    }

    public void setPatientName(Patient patientName) {
        this.patientName = patientName;
    }

    public Doctor getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(Doctor doctorName) {
        this.doctorName = doctorName;
    }
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime)  {
        this.dateTime = dateTime;
    }
   

  

   

    
 public String getPatientsParticipant() {
        return patientsParticipant;
    }

    public void setPatientsParticipant(String patientsParticipant) {
        this.patientsParticipant = patientsParticipant;
    }

    @Override
    public String toString() {
        return "Appointments{" + "Id=" + Id + ", dateTime=" + dateTime + ", patientName=" + patientName + ", doctorName=" + doctorName + ", patientsParticipant=" + patientsParticipant + '}';
    }

  
    
    
}
