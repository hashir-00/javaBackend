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
import com.mycompany.cw.model.Doctor;
import com.mycompany.exception.ResourceNotCreatedException;
import com.mycompany.exception.ResourceNotFoundException;
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
@Path("/Doctor")
public class DoctorResource {
    private DoctorDAO doctorDAO =new DoctorDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Doctor> getAllDoctor(){
        ArrayList<Doctor> doctors= doctorDAO.getAllDoctors();
        if(doctors !=null){
            return doctors;
        } throw new ResourceNotFoundException("No Doctors Found");
       
    }
    @GET
    @Path("/{doctorName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor getDoctorByName(@PathParam("doctorName") String name){
        Doctor doctor= doctorDAO.getDoctorByName(name);
       if (doctor != null) {
            return doctor;
        } else {
           throw new ResourceNotFoundException("Doctor with Name: "+name+" not found");
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDoctor(Doctor doctor) {
        if(doctor.getName() == null){
          throw new ResourceNotCreatedException("Doctor cannot be added");
      }
      doctorDAO.addDoctor(doctor);
             return Response.ok().build();
    }
    
    @PUT
    @Path("/{doctorName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("doctorName") String name,Doctor doctor ) {
        Doctor existingDoctor = doctorDAO.getDoctorByName(name);

        if (existingDoctor!= null) {
             doctorDAO.updateDoctor(doctor.getName(),doctor.getContact(),doctor.getAddress(),doctor.getProfession());
             return Response.ok().build();
        }else {
            throw new ResourceNotFoundException("No Doctors found with Name:" + name);
        }
    }
    @DELETE
    @Path("/{personName}")
    public Response deleteDoctor(@PathParam("personName") String doctorName ) {
       
          if(doctorDAO.getDoctorByName(doctorName)!= null){
   doctorDAO.deleteDoctor(doctorName);
       return Response.ok().build();
        }
       throw new ResourceNotFoundException("No Doctors found with Name:" +doctorName);
    }
    
}
