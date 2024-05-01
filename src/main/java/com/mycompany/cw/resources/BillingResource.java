/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.resources;

import javax.ws.rs.Path;
import com.mycompany.cw.model.Billing;
import com.mycompany.cw.DAO.BillingDAO;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author Hashirhalaldeen
 */
@Path("/Bill")
public class BillingResource {
    private BillingDAO billDAO = new BillingDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Billing> getAllBills(){
        return billDAO.getAllBillingRecords();
    
    }
    
    @GET
    @Path("/{billId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getBillingByInvoiceId(@PathParam("billId") String Id){
        return billDAO.getBillByInvoiceId(Id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
     public void addBill(Billing Bill){
         billDAO.addBillingRecord(Bill);
     }
    
    @PUT
    @Path("/{billId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(@PathParam("billId") String Id,Billing bill ) {
        Billing existingBill = billDAO.getBillByInvoiceId(Id);

        if (existingBill!= null) {
             billDAO.updateBillingRecord(bill.getPayments(),bill.getCreditBalance(),Id);
        }
    }
    
    @DELETE
    @Path("/{billId}")
    public void deletePerson(@PathParam("billId")String Id){
        billDAO.removeBillingRecord(Id);
    }
}
