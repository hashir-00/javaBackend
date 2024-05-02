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
import com.mycompany.exception.ResourceNotFoundException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author Hashirhalaldeen
 */
@Path("Patient")
public class PatientResource {

    private PatientDAO patientDAO = new PatientDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Patient> getAllPatient() {
        ArrayList<Patient> patient = patientDAO.getAllPatients();
        if (patient != null) {
            return patient;
        } else {
            throw new ResourceNotFoundException("No Patients Found");
        }
    }

    @GET
    @Path("/{patientName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatientByName(@PathParam("patientName") String patient) {
        Patient patients = patientDAO.getPatientByName(patient);
        if (patients != null) {
            return patients;
        } else {
            throw new ResourceNotFoundException("Patient with Name: " + patient + " not found");
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPatient(Patient patient) {
        if (patient.getName() == null) {
            throw new ResourceNotFoundException("Cannot add Patient");
        }
        patientDAO.addPatient(patient);
        return Response.ok().build();

    }

    @PUT
    @Path("/{patientName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("patientName") String name, Patient person) {
        Patient existingPatient = patientDAO.getPatientByName(name);

        if (existingPatient != null) {
            patientDAO.updatePatient(person.getName(), person.getContact(), person.getAddress()); return Response.ok().build();
        }else {
           throw new ResourceNotFoundException("Patient with Name: " + name + " not found");
    }}

    @DELETE
    @Path("/{patientName}")
    public Response deletePerson(@PathParam("patientName") String patientName) {
       
        
         if(patientDAO.getPatientByName(patientName)!= null){
         patientDAO.removePatient(patientName);
       return Response.ok().build();
        }
       throw new ResourceNotFoundException("Patient with Name: " + patientName + " not found");
    }
    

}
