package com.projeto.base.financeiro.controller;

import java.security.GeneralSecurityException;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.base.financeiro.security.Crypto;

/**HomeController.java
 * @author Desenvolvedor
 * 2021 
**/

@Controller
@CrossOrigin(origins = "*")
@Api(value="Api REST Account")
public class HomeController {

	@RequestMapping("/")
	public String home () {
		return "redirect:/index.html";
	}
}
