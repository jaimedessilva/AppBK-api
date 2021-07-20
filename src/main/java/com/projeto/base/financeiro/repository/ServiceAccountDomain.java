package com.projeto.base.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.base.financeiro.model.ServicesAccount;

/**ServiceDomain.java
 * @author Desenvolvedor
 * 2021 
**/
@Repository
public interface ServiceAccountDomain extends JpaRepository<ServicesAccount, Long>{}
