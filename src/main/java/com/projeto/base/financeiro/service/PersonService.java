package com.projeto.base.financeiro.service;

import java.util.List;

import com.projeto.base.financeiro.exception.ResourceNotFoundException;
import com.projeto.base.financeiro.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.projeto.base.financeiro.model.Person;
import com.projeto.base.financeiro.repository.PersonRepository;

/**PersonService.java
 * @author Desenvolvedor
 * 2021 
**/

@Service
public class PersonService {

	PersonRepository repository;
	UserRepository userRepository;
	
	@Autowired
	public PersonService(PersonRepository repository, UserRepository userRepository) {
		this.repository = repository;
		this.userRepository = userRepository;
	}
	/*
	 * List All Static
	 */
	public List<Person> listAll(){
		//return lsp;
		//repository.findAll();
		return (List<Person>) repository.findAllPerson();
	}
	/*
	 * Read
	 */
	public Person findOne(Long id) throws ResourceNotFoundException {
		Person person = repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Id: "+ id +" não encontrado"));
		return person;
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
	public Person createPerson(@RequestBody Person p) {
		return repository.saveAndFlush(p);
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
						value.setUser(p.getUser());
						Person pnew = repository.save(value);
						return ResponseEntity.ok().body(pnew);	
				}).orElse(ResponseEntity.notFound().build());
	}
	/*
	 * Delete
	 */
	public void deletePerson(Long id) throws ResourceNotFoundException {
	Person p = repository.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException("Usuario Id "+id+ " Não encontrado"));
			repository.delete(p);
	}
	
	
}
