package com.projeto.base;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.base.financeiro.model.Person;
import com.projeto.base.financeiro.model.ServicesAccount;
import com.projeto.base.financeiro.model.TypeService;
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
		//User
				//User u1 = new User(1L, "Carlos Dias", "carlos@gmail.br");
//				User u1 = new User("Jaime Dias","jaime@ggmail.com","123");
//				User u2 = new User("Joao Pedro", "pedro@gmail.br", "123");
//				User u3 = new User("Joase Aguiar", "aguiar123@gmail.br", "123");
//				User u4 = new User("Sandalves Dias", "sandalves@gmail.br", "123");
//				User u5 = new User("Roberval Guimaraes", "roberval@gmail.br", "123");
//				User u6 = new User("Moises Aguiar", "mo@gmail.br", "123");
//				
//				List<User> ls = Arrays.asList(u1,u2,u3,u4,u5,u6);
				//ls.forEach(value->System.out.println(value));

				//Account
//				Account ac1 = new Account(1L, u1);
//				Account ac2 = new Account(2L, u2);
//				Account ac3 = new Account(3L, u3);
//				Account ac4 = new Account(4L, u4);
//				Account ac5 = new Account(5L, u5);
//				Account ac6 = new Account(6L, u6);
//				
//				List<Account> accList = Arrays.asList(ac1,ac2,ac3,ac4,ac5,ac6);
				
				//accRepo.saveAll(accList);
				
				//accList.forEach(value->System.out.println(value));
				List<ServicesAccount> srvlist = Arrays.asList(
					new ServicesAccount("Limite", TypeService.LIMITE_ADICIONAL, 1.0),
					new ServicesAccount("Cartão Black", TypeService.CARTAO_CREDITO, 13.0),
					new ServicesAccount("Ações na Bolsa", TypeService.CONTA_DE_ACOES, 3.0),
					new ServicesAccount("Emprestimo", TypeService.EMPRESTIMO, 5.0),
					new ServicesAccount("Seguros Diversos", TypeService.PROTECAO_ONLINE, 1.0));
				
				srvlist.forEach(servicos-> System.out.println(servicos));
				
		
	}
	
	public static void main(String[] args) {
		
		MainBase base = new MainBase();
		Person p = new Person();
		p.setId(null);
		p.getId();
		
		
				
				
		//System.out.println(dt);
	}

}
