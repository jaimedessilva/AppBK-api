package com.projeto.base.financeiro.model;

import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


/**Person.java
 * @author Desenvolvedor
 * 2021 
**/
@Entity
@Data
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)//Mapeamento Herança
public class Person {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String telefone;
	private String cpf;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name ="contact_id")
	private List<Contact> contacts = new ArrayList<Contact>();

	public Person (){
		this.user = new User();
	}

	@Override
	public String toString() {
		return "Person: id: " + id 
				+ "\n name: " + name 
				+ "\n email: " + email 
				+ "\n telefone: " + telefone 
				+ "\n cpf: " + cpf
				+"\n User:" + user;
	}	
}
