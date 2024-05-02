/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.resources;

import com.mycompany.cw.DAO.PrescriptionDAO;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mycompany.cw.model.Prescription;
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
@Path("/Prescription")
public class PrescriptionResource {

    private PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Prescription> getAllPrescriptions() {
        ArrayList<Prescription> prescriptions = prescriptionDAO.getAllPrescriptions();
        if (prescriptions != null) {
            return prescriptions;
        }
        throw new ResourceNotFoundException("No Prescriptions Found");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPrescription(Prescription prescription) {
        if (prescription.getId() != null) {
            prescriptionDAO.addPrescription(prescription);
            return Response.ok().build();
        }
        throw new ResourceNotCreatedException("Cannot add Prescription");
    }

    @PUT
    @Path("/{prescriptionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePrescription(@PathParam("prescriptionId") String id, Prescription prescription) {
        Prescription existingPrescription = prescriptionDAO.getPrescriptionByID(id);

        if (existingPrescription != null) {
            prescriptionDAO.updatePrescription(id, prescription.getDosage(), prescription.getPrescribedMedics(), prescription.getInstructions(), prescription.getDuration());
            return Response.ok().build();
        }
        throw new ResourceNotFoundException("No Prescription found with ID:" + id);

    }

    @DELETE
    @Path("{prescriptionId}")
    public Response deletePrescription(@PathParam("prescriptionId") String id) {
        if (prescriptionDAO.getPrescriptionByID(id) != null) {
            prescriptionDAO.removePrescription(id);
            return Response.ok().build();
        }
        throw new ResourceNotFoundException("No appointments found with ID:" + id);
    }
}
