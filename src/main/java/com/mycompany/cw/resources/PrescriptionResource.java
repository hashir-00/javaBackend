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
import com.mycompany.cw.Prescription;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 *
 * @author Hashirhalaldeen
 */
@Path("/Prescription")
public class PrescriptionResource {
    private PrescriptionDAO prescriptionDAO = new  PrescriptionDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Prescription> getAllPrescriptions(){
        return prescriptionDAO.getAllPrescriptions();
    }
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   public void addPrescription(Prescription prescription)
   {
       prescriptionDAO.addPrescription(prescription);
   }
   @PUT
   @Path("/{prescriptionId}")
   @Consumes(MediaType.APPLICATION_JSON)
   public void updatePrescription(@PathParam("prescriptionId") String id,Prescription prescription){
       Prescription existingPrescription = prescriptionDAO.getPrescriptionByID(id);

        if (existingPrescription!= null) {
           prescriptionDAO.updatePrescription(id,prescription.getDosage(),prescription.getPrescribedMedics(),prescription.getInstructions(), prescription.getDuration());
        }
   }
   @DELETE
   @Path("{prescriptionId}")
   public void deletePrescription(@PathParam("prescriptionId")String id){
       prescriptionDAO.removePrescription(id);
   }
}
