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
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Hashirhalaldeen
 */
@Path("/MedicRecord")
public class MedicalRecordResource {
    private MedicalRecordDAO mRRDAO = new MedicalRecordDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<MedicalRecord> getAllMedicalRecords(){
        return mRRDAO.getAllMedicalRecords();
    }
    
    @GET
    @Path("/{medicalRecordId}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord getMedicalRecordsByID(@PathParam("medicalRecordId") String ID){
        return mRRDAO.getMedicalRecordByID(ID);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMedicalRecord(MedicalRecord mr){
        mRRDAO.addMedicalRecord(mr);
    }
    @PUT
    @Path("/{medicalRecordId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(@PathParam("medicalRecordId") String ID,MedicalRecord mr ) {
        MedicalRecord existingMedicRecord = mRRDAO.getMedicalRecordByID(ID);

        if (existingMedicRecord != null) {
             mRRDAO.updateMedicalRecord(mr.getDiagnose(),mr.getTreatment(),ID);
        }
    }
    @DELETE
    @Path("/{medicalRecordId}")
    public void deleteMedicalRecord(@PathParam("medicalRecordId") String ID ) {
       mRRDAO.removeMedicalRecord(ID);
    }
}
