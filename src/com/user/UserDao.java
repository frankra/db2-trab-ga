package com.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class UserDao {
	
	@PersistenceContext private EntityManager em;
	
	
	@Transactional 
	public void persist(User user){
		em.persist(user);
	}
	
	public int getUserCount(){
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u ORDER BY u.login", User.class);
		
		return query.getResultList().size();
	}

}
