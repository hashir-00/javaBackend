/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw;

/**
 *
 * @author Hashirhalaldeen
 */
public class MedicalRecord {
    private String ID,diagnose,treatment;

    public MedicalRecord() {
    }

    public MedicalRecord(String ID,String diagnose, String treatment) {
        this.ID= ID;
        this.diagnose = diagnose;
        this.treatment = treatment;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" + "diagnose=" + diagnose + ", treatment=" + treatment + '}';
    }
    
    
}
