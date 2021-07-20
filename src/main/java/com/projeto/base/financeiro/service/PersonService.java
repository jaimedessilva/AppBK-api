package com.projeto.base.financeiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projeto.base.financeiro.model.Person;
import com.projeto.base.financeiro.repository.PersonRepository;

/**PersonService.java
 * @author Desenvolvedor
 * 2021 
**/

@Service
public class PersonService {

	PersonRepository repository;
	
	@Autowired
	public PersonService(PersonRepository repository) {
		this.repository = repository;
	}
	
//	List<Person> lsp = Arrays.asList(
//			new Person(1L,"Carlos Sampaio", "nome@gmail.com"),
//			new Person(2L,"Claudio dos Santos", "claudio@gmail.com"),
//			new Person(3L,"Soraya Monetnegro", "soraya@email.com"));
	
	/*
	 * List All Static
	 */
	public List<Person> listAll(){
		//return lsp;
		//repository.findAll();
		return (List<Person>) repository.findAll(); 
	}
	/*
	 * Read
	 */
	public Person findOne(Long id) {
	  return 
		listAll().stream()
		.filter(p -> p.getId().equals(id))
		.findFirst()
		.orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Person Not Found"));
	}
	/*
	 * Find By Like Name
	 */
	public List<Person> findName(String name) {
		return repository.findByLikeName(name);
	}
	/*
	 * Create
	 */
	public Person createPerson(Person p) {
		return repository.save(p);
	}
	/*
	 * Update
	 */
	public ResponseEntity<Person> updatePerson(Person p, Long id) {
		return repository.findById(id)
				.map(value -> {
						value.setName(p.getName());
						value.setEmail(p.getEmail());
						value.setTelefone(p.getTelefone());
						value.setCpf(p.getCpf());
						Person pnew = repository.save(value);
						return ResponseEntity.ok().body(pnew);	
				}).orElse(ResponseEntity.notFound().build());
	}
	/*
	 * Delete
	 */
	public void deletePerson(Long id) {
		Person p = findOne(id);
		repository.delete(p);
	}
	
	
}
