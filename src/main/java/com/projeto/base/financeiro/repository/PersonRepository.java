package com.projeto.base.financeiro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.projeto.base.financeiro.model.Person;

/**PersonRepository.java
 * @author Desenvolvedor
 * 2021 
**/
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	@Query( value = "SELECT p FROM Person p WHERE 1=1 order by p.id")//JPQL
	List<Person> findAllPerson();
	@Query(value = "SELECT p FROM Person p WHERE upper(p.name) LIKE upper(concat('', ?1,'%'))")
	List<Person> findByLikeName(String name);

}
