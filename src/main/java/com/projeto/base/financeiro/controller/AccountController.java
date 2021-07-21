package com.projeto.base.financeiro.controller;

import com.projeto.base.financeiro.model.Account;
import com.projeto.base.financeiro.model.User;
import com.projeto.base.financeiro.repository.AccountRepository;
import com.projeto.base.financeiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AccountController.java
 *
 * @author Desenvolvedor
 * 2021
 **/

@RestController
@RequestMapping("/account")
public class AccountController {

    private UserRepository userRepository;
    private AccountRepository accRepository;
	private User user;
	private Account acc;


	@Autowired
    public AccountController(AccountRepository accRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.accRepository = accRepository;
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
	    return ResponseEntity.ok(accRepository.findAll());
    }

    @PostMapping
    public Account postAccount(@RequestBody Account acc) {
        return accRepository.saveAndFlush(acc);
    }
}
