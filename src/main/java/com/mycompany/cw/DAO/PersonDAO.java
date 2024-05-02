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
        personsList.add(new Person("hashir", "add", 1));
        personsList.add(new Person("hashisr", "add", 3));
        personsList.add(new Person("hashisdsr", "add", 2));
        personsList.add(new Person("hashaair", "add", 14));
    }
    
    public ArrayList<Person> getAllPersons(){
        log.info("Retrieving all person details");
        return personsList;
    }
    
    public Person getPersonByName(String name){
        for(Person person : personsList){
            if(person.getName().equals(name)){
                log.info("Person found by name: " + name);
                return person;
            }
        }
        log.warning("Person not found by name: " + name);
        return null;
    }
    
    public void addPerson(Person person){
        personsList.add(person);
        log.info("Person added: " + person);
    }
    
    public void deletePerson(String name){
        personsList.removeIf(person -> {
            if(person.getName().equals(name)){
                log.info("Person removed: " + person);
                return true;
            }
            return false;
        });
    } 
    
    public void updatePerson(String name, int contact, String address) {
        for(Person person : personsList){
            if (person.getName().equals(name)) {
                person.setContact(contact);
                person.setAddress(address);
                log.info("Person updated: " + person);
                return;
            }
        }
        log.warning("Person not found for update with name: " + name);
    }
}