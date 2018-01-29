package com.itdragon.pojo;

public class PersonService {
	
	private final PersonDao personDao; 
    public PersonService(PersonDao personDao) { 
        this.personDao = personDao; 
        } 
    public boolean update(int id, String name) { 
        Person person = personDao.getPerson(id); 
        if (person == null) 
        { return false; } 
        Person personUpdate = new Person(person.getId(), name); 
        return personDao.update(personUpdate); 
        }
    
    public Person getPersonById(int id){
    	
    	return personDao.getPerson(id);
    }
}
