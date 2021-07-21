package com.projeto.base.financeiro.controller;

import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.base.financeiro.model.User;
import com.projeto.base.financeiro.repository.UserRepository;
import javassist.NotFoundException;

/**UserController.java
 * @author Desenvolvedor
 * 2021 
**/

@RestController
@RequestMapping("/users")
@Api(value="Api REST Account")
@CrossOrigin( origins = "*")
public class UserController {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository repo) {
		this.userRepository = repo;
	}
	@GetMapping

	public List<User> getAll(){

		return userRepository.findAll();
	}
	@GetMapping("/size")
	public int getSize() {

		return userRepository.findAll().size() + 1;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable long id) throws NotFoundException{
		User user = userRepository.findById(id)
				.orElse(new User("404","Nout Foud User",null));
				//.orElseThrow(()-> new NotFoundException("User not Found: " + 1));		
		return ResponseEntity.ok(user); 
	}
	@PostMapping
	public User createUser (@RequestBody User user){

		return userRepository.save(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user)throws NotFoundException {
    User value = userRepository.findById(id)
    		.orElseThrow(()-> new NotFoundException("User ID: "+ id + "Not Found"));

    			value.setId(user.getId());
			    value.setName(user.getName());
			    value.setUsername(user.getUsername());
			    value.setPassword(user.getPassword());
			    value.setAccount(user.getAccount());

			    User userNew = userRepository.save(value);

    return ResponseEntity.ok(userNew);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<User> delete(@PathVariable long id){
		User user = userRepository.findById(id)
				.orElse(new User("404", "Não Existe",null));
		userRepository.delete(user);
		return ResponseEntity.noContent().build();
	}

}
