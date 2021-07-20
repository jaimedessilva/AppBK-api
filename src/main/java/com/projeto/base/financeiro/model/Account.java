package com.projeto.base.financeiro.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Account.java
 * @author Desenvolvedor 2021
 **/
@Entity @Table(name = "account")
@Data
@NoArgsConstructor
//@IdClass(Account.class)
@EqualsAndHashCode
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", nullable = true)
	private Long id;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@SequenceGenerator(name ="conta", initialValue = 1000)
	@Column(name = "number")
	private int cNumber;
	
	//@Transient 
	@Column(nullable = true)
	private double cLimit;
	
	@Column(nullable = true)
	private Double cBalance;
	
	@Column(name ="status_account")
	private StatusAcc status;
	
	@Column(name = "date_create")
	private Date dt = new Date();
	
	@ManyToMany
	@JoinTable(name = "service_account") 
	private List<ServicesAccount> services = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	
	public Account(User user) {
		this.user = user;
		this.cNumber = 10000 + new Date().getSeconds();
		this.cLimit = 100.00;
		this.cBalance = 1.00;
		this.status = StatusAcc.NOVA;
		this.dt = new Date();
		this.services = new ArrayList<>();	
	}

	@Override
	public String toString() {
		return "Account Information: "
				+ "\n id: " + id 
				+ "\n cNumber: " + cNumber 
				+ "\n cLimit: " + cLimit 
				+ "\n cBalance: " + cBalance
				+ "\n status: " + status 
				+ "\n dt: " + dt 
				+ "\n services: " + services 
				+ "\n user: " + user;
	}
		 
}
