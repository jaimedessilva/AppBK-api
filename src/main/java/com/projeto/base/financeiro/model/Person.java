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

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name ="contact_id")
	private List<Contact> contacts = new ArrayList<Contact>();

	
	public Person(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public Person() {
	
	}
	@Override
	public String toString() {
		return "Person: id: " + id 
				+ "\n name: " + name 
				+ "\n email: " + email 
				+ "\n telefone: " + telefone 
				+ "\n cpf: " + cpf;
	}	
}
