package com.projeto.base.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.base.financeiro.model.User;

/**UserRepository.java
 * @author Desenvolvedor
 * 2021 
**/

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
