/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cw.DAO;

import com.mycompany.cw.model.Person;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author Hashirhalaldeen
 */
public class PersonDAO {
    private static ArrayList<Person> personsList = new ArrayList<>();
   private static final Logger log = Logger.getLogger(PersonDAO.class.getName());
    
  static {
      personsList.add(new Person("hashir","add",1));
       personsList.add(new Person("hashisr","add",3));
        personsList.add(new Person("hashisdsr","add",2));
         personsList.add(new Person("hashaair","add",14));
  }
    
    public ArrayList<Person> getAllPersons(){
        log.info("All person details returned");
        return personsList;
    }
    
       
    public Person getPersonByName(String guy){
        for(Person person :personsList){
            if(person.getName().equals(guy)){
                log.info("Person details returned");
                return person;
            }
        }
        return null;
    }
    
    public void addPerson(Person person){
        personsList.add(person);
        log.info("Person added");
    }
    
    public void deletePerson(String guy){
       personsList.removeIf(person->person.getName().equals(guy));
     
    } 
    public void updatePerson( String name,int contact,String address) {
       for(Person person:personsList){
            if (person.getName().equals(name)) {
            person.setContact(contact);
            person.setAddress(address);
           
            log.info("Person updated" );
        } else {
            log.info("Error: Person not found or unable to update");
        }
       }
       
    }
}
