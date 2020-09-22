package com.directory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.directory.model.Person;
import com.directory.repository.PersonRepository;

public class PersonService {
//
//	@Autowired
//	private PersonRepository personRepository;
//	
//	public Person updateEmployee(Long personId, Person payload) {		
//		
//		Optional<Person> foundPerson = personRepository.findById(personId);
//
//		Person employee = foundPerson.map(personToUpdate -> {
//
//					personToUpdate.setPersonName(payload.getPersonName());
//					personToUpdate.setDob(payload.getDob());
//					personToUpdate.setEmail(payload.getEmail());
//					personToUpdate.setCountry(payload.getCountry());
//					personToUpdate.setAvatar(payload.getAvatar());
//					
//					return personRepository.save(personToUpdate);
//				}).orElseThrow(PersonNotFoundException::new );
//		
//		return employee;
//	}
//
}
