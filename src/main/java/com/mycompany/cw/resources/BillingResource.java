/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.resources;

import javax.ws.rs.Path;
import com.mycompany.cw.model.Billing;
import com.mycompany.cw.DAO.BillingDAO;
import com.mycompany.exception.ResourceNotCreatedException;
import com.mycompany.exception.ResourceNotFoundException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Hashirhalaldeen
 */
@Path("/Bill")
public class BillingResource {

    private BillingDAO billDAO = new BillingDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Billing> getAllBills() {
         ArrayList<Billing> bills = billDAO.getAllBillingRecords();
          if (bills != null) {
            return bills;
        } else {
           throw new ResourceNotFoundException("No Bills Found");
        }
       

    }

    @GET
    @Path("/{billId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getBillingByInvoiceId(@PathParam("billId") String Id) {
        Billing bill = billDAO.getBillByInvoiceId(Id);
         if (bill != null) {
            return bill;
        } else {
           throw new ResourceNotFoundException("Bill with ID: "+Id+" not found");
        }
        
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBill(Billing Bill) {
        if (Bill.getInvoiceId() == null) {

            throw new ResourceNotCreatedException("Bill cannot be added");
        }
        billDAO.addBillingRecord(Bill);
        return Response.ok().build();
    }

    @PUT
    @Path("/{billId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("billId") String Id, Billing bill) {
        Billing existingBill = billDAO.getBillByInvoiceId(Id);

        if (existingBill != null) {
            billDAO.updateBillingRecord(bill.getPayments(), bill.getCreditBalance(), Id);
            return Response.ok().build();
        } else {
            throw new ResourceNotFoundException("No Bills found with ID:" + Id);
        }
    }

    @DELETE
    @Path("/{billId}")
    public Response deletePerson(@PathParam("billId") String Id) {
        if (billDAO.getBillByInvoiceId(Id) != null) {
            billDAO.removeBillingRecord(Id);
            return Response.ok().build();
        }
        throw new ResourceNotFoundException("No Bills found with ID:" + Id);
    }
}
