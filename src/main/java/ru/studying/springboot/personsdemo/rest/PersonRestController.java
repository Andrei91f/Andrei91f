package ru.studying.springboot.personsdemo.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.studying.springboot.personsdemo.entity.Person;
import ru.studying.springboot.personsdemo.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonRestController {
	
	private PersonService personService;
	
	@Autowired
	public PersonRestController(PersonService thePersonService) {
		personService = thePersonService;
	}
	
	@GetMapping("/persons/{personId}")
	public Person getEmployee(@PathVariable int personId) {
		Person thePerson = personService.getPersonById(personId);
		
		if (thePerson == null) {
			throw new RuntimeException ("Person id not found - " + personId);
		}
		
		return thePerson;
	}
	
	@PostMapping("/persons")
	public Person addEmployee(@Valid @RequestBody Person thePerson) {
		personService.addPerson(thePerson);	
		return thePerson;
	}
}
