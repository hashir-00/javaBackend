/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;


/**
 *
 * @author Hashirhalaldeen
 */
import com.mycompany.cw.DAO.AppointmentsDAO;
import java.util.ArrayList;
import javax.ws.rs.core.MediaType;
import com.mycompany.cw.model.Appointments;
import com.mycompany.exception.ResourceNotCreatedException;
import com.mycompany.exception.ResourceNotFoundException;
import javax.ws.rs.core.Response;

@Path("/Appointment")
public class AppointmentResource {
    private AppointmentsDAO appointmentDAO = new AppointmentsDAO();
     
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Appointments> getAllAppointments() {
        ArrayList<Appointments> appointments = appointmentDAO.getAllAppointments();
        if (appointments != null) {
            return appointments;
        } else {
           throw new ResourceNotFoundException("No appointments Found");
        }
    }

    @GET
    @Path("/{appointmentID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointments getAppointmentByID(@PathParam("appointmentID") String ID) {
        Appointments appointment = appointmentDAO.getAppointmentsByID(ID);
        if (appointment != null) {
            return appointment;
        } else {
           throw new ResourceNotFoundException("Appointment with ID: "+ID+" not found");
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAppointment(Appointments appointment) {
      if(appointment.getId() == null){
          throw new ResourceNotCreatedException("Cannot add appointment");
      }
      appointmentDAO.addAppointment(appointment);
             return Response.ok().build();
      
    }

    @PUT
    @Path("/{appointmentID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAppointment(@PathParam("appointmentID") String ID, Appointments appointment) {
        Appointments existingAppointment = appointmentDAO.getAppointmentsByID(ID);
        if (existingAppointment != null) {
            appointmentDAO.updateAppointment(appointment.getDateTime(), ID);
                   return Response.ok().build();
        } else {
            throw new ResourceNotFoundException("No appointments found with ID:" +ID);
        }
    }

    @DELETE
    @Path("/{appointmentID}")
    public Response deleteAppointmentByID(@PathParam("appointmentID") String ID) {
        if(appointmentDAO.getAppointmentsByID(ID)!= null){
        appointmentDAO.removeAppointment(ID);
       return Response.ok().build();
        }
       throw new ResourceNotFoundException("No appointments found with ID:" +ID);
    }
}
