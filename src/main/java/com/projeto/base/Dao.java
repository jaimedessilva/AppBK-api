package com.projeto.base;

import java.util.List;

import com.projeto.base.financeiro.model.User;
import com.projeto.base.financeiro.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

/**Dao.java
 * @author Desenvolvedor
 * 2021 
**/
public class Dao {
	@Autowired
	UserRepository userRepository;
	
//	@PersistenceContext
//	EntityManagerFactory emf = Persistence.
//		      createEntityManagerFactory( "user" );
//		      EntityManager em = emf.
//		      createEntityManager();
	
	public List<User> getAll(){
//		Query query = em.createQuery("SELECT u FROM User u");
//		return query.getResultList();
		return userRepository.findAll();
		
	}
	public static void main(String[] args) {
		Dao dao = new Dao();
		List<User> ls = dao.getAll();
		System.out.println(ls);
	}

}
