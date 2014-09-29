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
	public User persist(User user){
		User retrievedUser = this.retrieve(user.getID());
		if(retrievedUser != null){
			em.merge(user);
		}else{
			user.setLastChangedOn(new Timestamp(Calendar.getInstance().getTime().getTime()));
			em.persist(user);
		}
		
		return user;
	}
	
	@Transactional
	public User retrieve(int id){
		return em.find(User.class, id);
	}
	
	@Transactional
	public User delete(int id){
		User retrievedUser = this.retrieve(id);
		if(retrievedUser != null){
			em.remove(retrievedUser);
		}
		
		return retrievedUser;
		
	}
	
	
	@Transactional
	public int getUserCount(){
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		
		return query.getResultList().size();
	}
	@Transactional
	public List<User> getAllUsers(){
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		
		return query.getResultList();
		
	};

}
