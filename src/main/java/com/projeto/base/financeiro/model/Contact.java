package com.projeto.base.financeiro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**Contact.java
 * @author Desenvolvedor
 * 2021 
**/

@Entity
@Table(name = "tb_contact")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private TypeContact typeContact;

	@ManyToOne
	private User user;

	@Override
	public String toString() {
		return "Contact: "
				+ "\n Description: " + description
				+ "\n Type:" + typeContact;
	}
}
