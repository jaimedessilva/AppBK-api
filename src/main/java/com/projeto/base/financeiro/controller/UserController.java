package com.projeto.base.financeiro.controller;

import java.util.List;

import io.swagger.annotations.Api;
import net.bytebuddy.implementation.bytecode.Throw;
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
				.orElse(new User("404","Not Foud User",null));
				//.orElseThrow(()-> new NotFoundException("User not Found: " + 1));		
		return ResponseEntity.ok(user); 
	}
	@PostMapping
	public User createUser (@RequestBody User user){

		return userRepository.save(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user)throws NotFoundException {
    return (ResponseEntity<User>) userRepository.findById(id)
			.map(obj ->{
				obj.setId(user.getId());
				obj.setName(user.getName());
				obj.setUsername(user.getUsername());
				obj.setAccount(user.getAccount());
				User uNew = userRepository.save(obj);
				return ResponseEntity.ok().body(uNew);
			}).orElse(ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<User> delete(@PathVariable long id){
		User user = userRepository.findById(id)
				.orElse(new User("404", "Não Existe",null));
		userRepository.delete(user);
		return ResponseEntity.noContent().build();
	}

}
