package com.directory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.directory.exception.ResourceNotFoundException;
import com.directory.model.Person;
import com.directory.repository.PersonRepository;

@RestController
@RequestMapping("/api/people")
public class PersonController {
	
//	@Autowired
//	private PersonService personService;
	
	@Autowired
	private PersonRepository personRepository;
	
	/**
	 * List persons
	 * @return
	 */
	@GetMapping
	public List<Person> getAllEmployees() {
		return personRepository.findAll();
	}

	/**
	 * Get persons
	 * @param employeeId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Person> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Person employee = personRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}
	
	/**
	 * Add person
	 * @param employee
	 * @return
	 */
	@PostMapping
	public Person createEmployee(@Valid @RequestBody Person employee) {
		return personRepository.save(employee);
	}

	/**
	 * Edit persons
	 * @param employeeId
	 * @param employeeDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PatchMapping("/{id}")
	public ResponseEntity<Person> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Person employeeDetails) throws ResourceNotFoundException {
		Person employee = personRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Person updatedEmployee = personRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}


}
