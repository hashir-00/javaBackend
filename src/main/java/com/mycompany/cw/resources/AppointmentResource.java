/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.resources;

import com.mycompany.cw.DAO.AppointmentsDAO;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mycompany.cw.Appointments;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 *
 * @author Hashirhalaldeen
 */
@Path("/Appointment")
public class AppointmentResource {
    private AppointmentsDAO appointmentDAO = new AppointmentsDAO();
     
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Appointments> getAllAppointments(){
        return appointmentDAO.getAllAppointments();
    }

    @GET
    @Path("/{personID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointments getAppointmentByID(@PathParam("personID")String ID,Appointments appointment){
        return appointmentDAO.getAppointmentsByID(ID);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAppointment(Appointments appointment){
        appointmentDAO.addAppointment(appointment);
    }
    @PUT
    @Path("/{personID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAppointment(@PathParam("personID") String ID,Appointments appointment ) {
        Appointments existingAppointmentPatient = appointmentDAO.getAppointmentsByID(ID);


        if (existingAppointmentPatient != null  ) {
             appointmentDAO.updateAppointment(appointment.getDateTime(),ID);
        }
    }
     @DELETE
    @Path("/{appointmentID}")
    public void deleteAppointmentByID(@PathParam("appointmentID") String ID) {
        appointmentDAO.removeAppointment(ID);
    }

}
