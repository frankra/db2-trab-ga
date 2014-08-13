package com.user;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

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
		user.setLastChangedOn(new Timestamp(Calendar.getInstance().getTime().getTime()));
		em.persist(user);
	}
	
	@Transactional
	public User retrieve(int id){
		return em.find(User.class, id);
	}
	
	public int getUserCount(){
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		
		return query.getResultList().size();
	}
	
	public List<User> getAllUsers(){
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		
		return query.getResultList();
		
	};

}
