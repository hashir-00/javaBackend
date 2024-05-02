/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.resources;

import com.mycompany.cw.DAO.MedicalRecordDAO;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.mycompany.cw.model.MedicalRecord;
import com.mycompany.exception.ResourceNotCreatedException;
import com.mycompany.exception.ResourceNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Hashirhalaldeen
 */
@Path("/MedicRecord")
public class MedicalRecordResource {

    private MedicalRecordDAO mRRDAO = new MedicalRecordDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<MedicalRecord> getAllMedicalRecords() {
        ArrayList<MedicalRecord> mr = mRRDAO.getAllMedicalRecords();
        if (mr != null) {
            return mr;
        } else {
            throw new ResourceNotFoundException("No Medical records Found");
        }
    }

    @GET
    @Path("/{medicalRecordId}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord getMedicalRecordsByID(@PathParam("medicalRecordId") String ID) {
        MedicalRecord mr = mRRDAO.getMedicalRecordByID(ID);

        if (mr != null) {
            return mr;
        } else {
            throw new ResourceNotFoundException("Medical record with ID: " + ID + " not found");
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMedicalRecord(MedicalRecord mr) {
        if (mr.getID() == null) {
            throw new ResourceNotCreatedException("Medical record cannot be added");
        }
        mRRDAO.addMedicalRecord(mr);
        return Response.ok().build();
    }

    @PUT
    @Path("/{medicalRecordId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("medicalRecordId") String ID, MedicalRecord mr) {
        MedicalRecord existingMedicRecord = mRRDAO.getMedicalRecordByID(ID);

        if (existingMedicRecord != null) {
            mRRDAO.updateMedicalRecord(mr.getDiagnose(), mr.getTreatment(), ID);
            return Response.ok().build();
        } else {
            throw new ResourceNotFoundException("Medical record with ID: " + ID + " not found");
        }
    }

    @DELETE
    @Path("/{medicalRecordId}")
    public Response deleteMedicalRecord(@PathParam("medicalRecordId") String ID) {
        if(mRRDAO.getMedicalRecordByID(ID)!= null){
      mRRDAO.removeMedicalRecord(ID);
       return Response.ok().build();
        }
       throw new ResourceNotFoundException("No Medical record found with ID:" +ID);
    }
        
    
}
