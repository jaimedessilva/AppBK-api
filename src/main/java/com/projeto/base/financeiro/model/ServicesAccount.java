package com.projeto.base.financeiro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

/**Service.java
 * @author Desenvolvedor
 * 2021 
**/

  @Entity @Table(name = "services_domain")
  @NoArgsConstructor
  @Data
  public class ServicesAccount {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Long id; 
  private String Description; 
  private TypeService typeService; 
  private Double taxa;

  
  public ServicesAccount(String description, TypeService typeService, Double taxa) {
	super();
	Description = description;
	this.typeService = typeService;
	this.taxa = taxa;
		}
 }
 