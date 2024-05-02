/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.resources;

import com.mycompany.cw.model.Person;
import com.mycompany.cw.DAO.PersonDAO;
import com.mycompany.exception.ResourceNotCreatedException;
import com.mycompany.exception.ResourceNotFoundException;
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
import javax.ws.rs.core.Response;

/**
 *
 * @author Hashirhalaldeen
 */
@Path("/Person")
public class PersonResource {

    private PersonDAO personDAO = new PersonDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Person> getAllPerson() {
        ArrayList<Person> person = personDAO.getAllPersons();
        if (person != null) {
            return person;
        }
        throw new ResourceNotFoundException("No Persons found Found");
    }

    @GET
    @Path("/{personName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByName(@PathParam("personName") String guy) {
        Person person = personDAO.getPersonByName(guy);
        if (person != null) {
            return person;
        }
        throw new ResourceNotFoundException("No Personwith Name: " + guy + "found Found");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person guy) {
        if (guy.getName() != null) {
            personDAO.addPerson(guy);
            return Response.ok().build();
        }
        throw new ResourceNotCreatedException("Cannot add Person");
    }

    @PUT
    @Path("/{personName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("personName") String name, Person person) {
        Person existingPerson = personDAO.getPersonByName(name);

        if (existingPerson != null) {
            personDAO.updatePerson(person.getName(), person.getContact(), person.getAddress());
            return Response.ok().build();
        }
        throw new ResourceNotFoundException("No Person found with Name:" + name);
    }

    @DELETE
    @Path("/{personName}")
    public Response deletePerson(@PathParam("personName") String personName) {
        if (personDAO.getPersonByName(personName )!= null){
               personDAO.deletePerson(personName);  return Response.ok().build();
        }
      throw new ResourceNotFoundException("No Person found with Name:" + personName);
    }
}
