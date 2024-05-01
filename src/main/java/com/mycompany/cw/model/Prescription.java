/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.model;

import com.mycompany.cw.*;

/**
 *
 * @author Hashirhalaldeen
 */
public class Prescription {
    
    private String id,prescribedMedics,dosage,instructions;
    private Integer duration;

   

    public Prescription() {
    }

    
    public Prescription(String id,String prescribedMedics, String dosage, String instructions, Integer duration) {
        this.prescribedMedics = prescribedMedics;
        this.dosage = dosage;
        this.instructions = instructions;
        this.duration = duration;
        this.id=id;
    }
 public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getPrescribedMedics() {
        return prescribedMedics;
    }

    public void setPrescribedMedics(String prescribedMedics) {
        this.prescribedMedics = prescribedMedics;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

  
    @Override
    public String toString() {
        return "Prescription{" + "prescribedMedics=" + prescribedMedics + ", dosage=" + dosage + ", instructions=" + instructions + ", duration=" + duration + '}';
    }
    
    
}
