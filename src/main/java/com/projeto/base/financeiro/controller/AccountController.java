package com.projeto.base.financeiro.controller;

import com.projeto.base.financeiro.model.Account;
import com.projeto.base.financeiro.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * AccountController.java
 * @author Desenvolvedor
 * 2021
 **/

@RestController
@RequestMapping("/account")
public class AccountController {

	private AccountRepository accRepository;

	@Autowired
	public AccountController(AccountRepository accRepository) {

		this.accRepository = accRepository;
	}

	@GetMapping
	public ResponseEntity<List<Account>> getAll() {
		return ResponseEntity.ok(accRepository.findAll());
	}
}
