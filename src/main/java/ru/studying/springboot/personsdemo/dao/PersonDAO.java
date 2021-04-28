package ru.studying.springboot.personsdemo.dao;

import ru.studying.springboot.personsdemo.entity.Person;

public interface PersonDAO {
	
	public Person getPersonById(int theId);
	
	public void addPerson(Person thePerson);
}
