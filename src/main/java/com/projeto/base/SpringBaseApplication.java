package com.projeto.base;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.projeto.base.financeiro.model.Account;
import com.projeto.base.financeiro.model.ServicesAccount;
import com.projeto.base.financeiro.model.TypeService;
import com.projeto.base.financeiro.model.User;
import com.projeto.base.financeiro.repository.AccountRepository;
import com.projeto.base.financeiro.repository.PersonRepository;
import com.projeto.base.financeiro.repository.ServiceAccountDomain;
import com.projeto.base.financeiro.repository.UserRepository;

@SpringBootApplication
public class SpringBaseApplication {
	
	@Autowired
	PersonRepository personRepository;
	@Autowired
	public UserRepository userRepopsitory;
	@Autowired
	public AccountRepository accountRepository;
	@Autowired
	public ServiceAccountDomain servAcc;
	

	public static void main(String[] args) {

		SpringApplication.run(SpringBaseApplication.class, args);

	} 
	@Bean // Initial data Load
	public void LoadDatabase () {
		//Services
//		List<ServicesAccount> srvlist = Arrays.asList(
//			new ServicesAccount("Limite",TypeService.LIMITE_ADICIONAL, 1.0),
//			new ServicesAccount("Cartão Black", TypeService.CARTAO_CREDITO, 13.0),
//			new ServicesAccount("Ações na Bolsa", TypeService.CONTA_DE_ACOES, 3.0),
//			new ServicesAccount("Emprestimo", TypeService.EMPRESTIMO, 5.0),
//			new ServicesAccount("Seguros Diversos", TypeService.PROTECAO_ONLINE, 1.0));
//
//		servAcc.saveAll(srvlist);
//
//		User u1 = new User("Carlos Dias", "carlos@gmail.br", "123");
//		User u2 = new User("Roberto Campos", "campos@gmail.br", "@123");
//		User u3 = new User("Maria de Anjos", "deanjos@gmail.br", "#1123");
//		User u4 = new User("Estenio Garcia", "estenio@gmail.br", "1@23");
//		User u5 = new User("Soraya Monetenegro", "montenegro@gmail.br", "Txu@345");
//		User u6 = new User("Eros Ramazotte", "erosra@gmail.br", "123");
//		List<User> listUser = Arrays.asList(u1,u2,u3, u4,u5,u6);
//
//
//
//		List<Account> listAccount = Arrays.asList(
//				   					new Account(u1),
//				   					new Account(u2),
//		           					new Account(u3),
//				   					new Account(u4),
//				   					new Account(u5),
//				   					new Account(u6));
//
//		userRepopsitory.saveAll(listUser);
//		accountRepository.saveAll(listAccount);

	}

}









