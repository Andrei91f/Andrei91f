package ru.studying.springboot.personsdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.studying.springboot.personsdemo.dao.PersonDAO;
import ru.studying.springboot.personsdemo.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO;
	
	@Autowired
	public PersonServiceImpl(PersonDAO thePersonDAO) {
		personDAO = thePersonDAO;
	}	
	
	@Override
	@Transactional
	public Person getPersonById(int theId) {
		return personDAO.getPersonById(theId);
	}

	@Override
	@Transactional
	public void addPerson(Person thePerson) {
		personDAO.addPerson(thePerson);
	}
}
