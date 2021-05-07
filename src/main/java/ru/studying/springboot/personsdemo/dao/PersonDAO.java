package ru.studying.springboot.personsdemo.dao;

import ru.studying.springboot.personsdemo.entity.Person;

public interface PersonDAO {
	
	 Person getPersonById(int theId);
	
	 void addPerson(Person thePerson);
}
