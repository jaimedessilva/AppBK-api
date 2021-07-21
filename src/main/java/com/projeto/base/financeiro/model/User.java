package com.projeto.base.financeiro.model;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.base.financeiro.security.Crypto;

import lombok.*;


/**
 * User.java
 * @author Desenvolvedor
 * 2021 
**/

@Entity @Table(name = "user_account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(name = "username")
	private String username;
    private String password;

    @JsonIgnore
	@OneToOne(cascade = CascadeType.MERGE, mappedBy = "user", fetch = FetchType.LAZY)
	private Account account;

	public User(String name, String username, String password) {
		this.username = username;
		this.name = name;
		try {
			this.password = Crypto.crypto(password);
		} 
		catch (NoSuchAlgorithmException e) {e.printStackTrace();
		}
	}
	//Password
	public void setPassword(String password) {
		if (password != null) {
			try {
				this.password = Crypto.crypto(password);
				
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}else {
			try {
				password = Crypto.crypto("123");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public String toString() {
		return "User id: " + id
				+ "\n name: " + name
				+ "\n username: " + username 
				+ "\n password: " + password 
				+ "\n account: " + account;
	}
}
