package ru.studying.springboot.personsdemo.service;

import ru.studying.springboot.personsdemo.entity.Person;

public interface PersonService {
	public Person getPersonById(int theId);
	
	public void addPerson(Person theEmployee);
}
