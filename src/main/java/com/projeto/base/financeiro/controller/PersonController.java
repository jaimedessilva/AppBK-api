package com.projeto.base.financeiro.controller;

import com.projeto.base.financeiro.exception.ResourceNotFoundException;
import com.projeto.base.financeiro.model.Person;
import com.projeto.base.financeiro.service.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**PersonController.java
 * @author Desenvolvedor
 * 2021 
**/

@RestController
@RequestMapping("person")
@Api(value="Api REST Account")
@CrossOrigin( origins = "*")
public class PersonController {
	
	PersonService service;
	//UserController userController;

	@Autowired
	public PersonController(PersonService service) {
		this.service = service;
		//this.userController = userController;
	}

	//GET
	@GetMapping
	public ResponseEntity<List<Person>> getAll() {
		return ResponseEntity.ok(service.listAll());
	}

	//GET
	@GetMapping(path = "/name")
	public ResponseEntity<List<Person>> getAllNames() {
		return ResponseEntity.ok(service.listAll());
	}

	//GET ID
	@GetMapping(path = "/{id}")
	public ResponseEntity<Person> find(@PathVariable long id) throws ResourceNotFoundException {
		return ResponseEntity.ok(service.findOne(id));
	}

	//GET NAME
	@GetMapping(path = "/name/{name}")
	public ResponseEntity<List<Person>> getAllName(@PathVariable String name) {
		return ResponseEntity.ok(service.findName(name));
	}

	//POST
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Person> postPerson(@RequestBody Person p) {
		return ResponseEntity.ok(service.createPerson(p));
	}

	//DELETE
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
		service.deletePerson(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	//PUT
	@PutMapping(path = "/{id}")
	public ResponseEntity<Person> putPerson(@PathVariable long id, @RequestBody Person p) {
		service.updatePerson(p, id);
		return ResponseEntity.ok(p);
	}

}
