/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw;

/**
 *
 * @author Hashirhalaldeen
 */
 public class Patient extends Person{
    
    private MedicalRecord medicalRecord;
    private String healthStatus;

    public Patient(){}
    public Patient(MedicalRecord medicalRecord, String healthStatus, String name, String address, Integer contact) {
        super(name, address, contact);
        this.medicalRecord = medicalRecord;
        this.healthStatus = healthStatus;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    @Override
    public String toString() {
        return "Patient{" +super.toString()+" "+ "medicalRecord=" + medicalRecord + ", healthStatus=" + healthStatus + '}';
    }
    
    
}
