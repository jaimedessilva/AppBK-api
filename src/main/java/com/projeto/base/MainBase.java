package com.projeto.base;

import java.util.Arrays;
import java.util.List;

import com.projeto.base.financeiro.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.base.financeiro.repository.AccountRepository;
import com.projeto.base.financeiro.repository.UserRepository;

/**
 * MainBase.java
 * @author Desenvolvedor 2021
 **/
public class MainBase {

	@Autowired
	public UserRepository repo;
	
	@Autowired
	public AccountRepository accRepo;
	
	public void initialInsert() {














//				Account ac2 = new Account(u2);
//				Account ac3 = new Account(u3);
//				Account ac4 = new Account(u4);
//				Account ac5 = new Account(u5);
//				Account ac6 = new Account(u6);
////
//				List<Account> accList = Arrays.asList(ac1,ac2,ac3,ac4,ac5,ac6);
	



				
				//accRepo.saveAll(accList);
				
				//accList.forEach(value->System.out.println(value));
//				List<ServicesAccount> srvlist = Arrays.asList(
//					new ServicesAccount("Limite", TypeService.LIMITE_ADICIONAL, 1.0),
//					new ServicesAccount("Cartão Black", TypeService.CARTAO_CREDITO, 13.0),
//					new ServicesAccount("Ações na Bolsa", TypeService.CONTA_DE_ACOES, 3.0),
//					new ServicesAccount("Emprestimo", TypeService.EMPRESTIMO, 5.0),
//					new ServicesAccount("Seguros Diversos", TypeService.PROTECAO_ONLINE, 1.0));
//
//				srvlist.forEach(servicos-> System.out.println(servicos));
				
		
	}
	
	public static void main(String[] args) {
		//User
		//User u1 = new User(1L, "Carlos Dias", "carlos@gmail.br");
		User u1 = new User("joaquin", "joaquin@email", "1234");
		User u2 = new User("Joao Pedro", "pedro@gmail.br", "123");
		User u3 = new User("Joase Aguiar", "aguiar123@gmail.br", "123");
		User u4 = new User("Sandalves Dias", "sandalves@gmail.br", "123");
		User u5 = new User("Roberval Guimaraes", "roberval@gmail.br", "123");
//
//		Account ac2 = new Account(u1);
//
//		System.out.println(ac2);
		Account account = new Account();
		Double saque = account.sacar(33.0);
		System.out.println(saque);

		Double novo = account.sacar(21.0);

		Double saque1 = account.sacar(40.0);

		Double saque2 = account.sacar(10.0);

		Double depositar = account.depositar(100.0);

		System.out.println(" Agora o seu Saldo é: " +account.getCBalance());




	}}