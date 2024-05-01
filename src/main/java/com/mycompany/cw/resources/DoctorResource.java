/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.resources;

import com.mycompany.cw.DAO.DoctorDAO;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mycompany.cw.Doctor;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
/**
 *
 * @author Hashirhalaldeen
 */
@Path("/Doctor")
public class DoctorResource {
    private DoctorDAO doctorDAO =new DoctorDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Doctor> getAllDoctor(){
        return doctorDAO.getAllDoctors();
    }
    @GET
    @Path("/{doctorName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctorByName(@PathParam("doctorName") String name){
        return doctorDAO.getDoctorByName(name);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
    }
    
    @PUT
    @Path("/{doctorName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(@PathParam("doctorName") String name,Doctor doctor ) {
        Doctor existingDoctor = doctorDAO.getDoctorByName(name);

        if (existingDoctor!= null) {
             doctorDAO.updateDoctor(doctor.getName(),doctor.getContact(),doctor.getAddress(),doctor.getProfession());
        }
    }
    @DELETE
    @Path("/{personName}")
    public void deleteDoctor(@PathParam("personName") String doctorName ) {
        doctorDAO.deleteDoctor(doctorName);
    }
    
}
