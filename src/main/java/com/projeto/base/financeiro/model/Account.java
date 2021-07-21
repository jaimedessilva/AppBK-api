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
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

/**
 * Account.java
 * @author Desenvolvedor 2021
 **/

@Entity @Table(name = "account")
@EqualsAndHashCode
@AllArgsConstructor
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", nullable = true)
	@Getter
	private Long id;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "number")
	@Getter
	private int cNumber;
	

	@Column(nullable = true)
	@Getter
	private double cLimit;
	
	@Column(nullable = true)
	@Getter
	private Double cBalance;

	@JsonIgnore
	@Column(name ="status_account")
	@Getter
	private StatusAcc status;
	
	@Column(name = "date_create")
	@Getter
	private Date dt = new Date();

	@ManyToMany
	@JoinTable(name = "service_account")
	@Getter
	private List<ServicesAccount> services = new ArrayList<>();

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@Getter @Setter
	private User user;
	
	public Account(){
		this.user = user;
		this.cNumber = 10000 + new Date().getSeconds();
		this.cLimit = 150.00;
		this.cBalance = 100.00;
		this.status = StatusAcc.NOVA;
		this.dt = new Date();
		this.services = new ArrayList<>();
	}
	public Account(User user) {
		this.user = user;
		this.cNumber = 10000 + new Date().getSeconds();
		this.cLimit = 100.00;
		this.cBalance = 100.00;
		this.status = StatusAcc.NOVA;
		this.dt = new Date();
		this.services = new ArrayList<>();
	}
	//Saque
	public Double sacar(Double value){
		if (value > this.cBalance){
			System.out.println("!!!Saldo insuficiente!!!");
			return cBalance;
		}
		else {
			Double novoSaldo = this.cBalance -= value;
			System.out.println("Saque: R$: " + value);
			System.out.println("Seu novo saldo é R$: " + novoSaldo);
			this.cBalance = novoSaldo;
			return value;
		}
	}
	//Deposito
	public Double depositar(Double value){
		Double novoSaldo = this.cBalance + value;
		this.cBalance = novoSaldo;
		return novoSaldo;
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
