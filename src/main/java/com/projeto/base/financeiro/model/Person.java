package com.projeto.base.financeiro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**Person.java
 * @author Desenvolvedor
 * 2021 
**/
@Entity
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)//Mapeamento Herança
public class Person {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;
    @Getter @Setter
	private String name;
    @Getter @Setter
	private String email;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Getter @Setter
	private String telefone;
    @Getter @Setter
	private String cpf;
	
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
