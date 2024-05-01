/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.resources;

import com.mycompany.cw.model.Person;
import com.mycompany.cw.DAO.PersonDAO;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

/**
 *
 * @author Hashirhalaldeen
 */

@Path("/Person")
        public class PersonResource {
    private PersonDAO personDAO = new PersonDAO();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Person> getAllPerson(){
        return personDAO.getAllPersons();
    }
    
    @GET
    @Path("/{personName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByName(@PathParam("personName") String guy) {
        return personDAO.getPersonByName(guy);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPerson(Person guy) {
        personDAO.addPerson(guy);
    }
    
    @PUT
    @Path("/{personName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(@PathParam("personName") String name,Person person ) {
        Person existingPerson = personDAO.getPersonByName(name);

        if (existingPerson != null) {
             personDAO.updatePerson(person.getName(),person.getContact(),person.getAddress());
        }
    }
    
    @DELETE
    @Path("/{personName}")
    public void deletePerson(@PathParam("personName") String personName ) {
        personDAO.deletePerson(personName);
    }
}
