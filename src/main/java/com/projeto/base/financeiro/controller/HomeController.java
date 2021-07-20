package com.projeto.base.financeiro.controller;

import java.security.GeneralSecurityException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.base.financeiro.security.Crypto;

/**HomeController.java
 * @author Desenvolvedor
 * 2021 
**/

@RestController
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	public String msg () throws GeneralSecurityException {
		
		String msg = "Hello 123";
		String pass = Crypto.crypto(msg);
		
		return "<h1>API Person's v1.0 "+ pass +"</h1>";
	}
}
