package com.projeto.base.financeiro.controller;

import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.base.financeiro.model.ServicesAccount;
import com.projeto.base.financeiro.repository.ServiceAccountDomain;

/**ServicesAccount.java
 * @author Desenvolvedor
 * 2021 
**/

@RestController
@RequestMapping("/services")
@Api(value = "Api REST Account")
@CrossOrigin(origins = "*")
public class ServicesAccountController {

	private ServiceAccountDomain repository;


	@Autowired
	public ServicesAccountController(ServiceAccountDomain repository) {

		this.repository = repository;
	}

	@GetMapping
	public ResponseEntity<List<ServicesAccount>> getAll() {

		return ResponseEntity.ok(repository.findAll());
	}
}
