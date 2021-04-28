package ru.studying.springboot.personsdemo.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.studying.springboot.personsdemo.entity.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	//define field for entitymanager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public PersonDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public Person getPersonById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		//get the person
		Person thePerson = currentSession.get(Person.class, theId);
		
		return thePerson;
	}

	@Override
	public void addPerson(Person thePerson) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(thePerson);
	}
}
