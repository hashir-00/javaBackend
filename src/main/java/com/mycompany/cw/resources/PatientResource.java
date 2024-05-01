/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.resources;

import com.mycompany.cw.DAO.PatientDAO;
import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mycompany.cw.model.Patient;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 *
 * @author Hashirhalaldeen
 */
@Path("Patient")
public class PatientResource {
    
    private PatientDAO patientDAO = new PatientDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Patient> getAllPatient(){
        return patientDAO.getAllPatients();
    }
    
    @GET
    @Path("/{patientName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientByName(@PathParam("patientName") String patient){
        return patientDAO.getPatientByName(patient);
        
    }
        
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPatient(Patient patient) {
        patientDAO.addPatient(patient);
    }
    @PUT
    @Path("/{patientName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(@PathParam("patientName") String name,Patient person ) {
        Patient existingPatient = patientDAO.getPatientByName(name);

        if (existingPatient != null) {
             patientDAO.updatePatient(person.getName(),person.getContact(),person.getAddress());
        }
    }
    @DELETE
    @Path("/{patientName}")
    public void deletePerson(@PathParam("patientName") String patientName){
        patientDAO.removePatient(patientName);
    }
   
}
