package com.list;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ListDao {
	
	@PersistenceContext private EntityManager em;
	
	
	@Transactional 
	public void persist(List list){
		em.persist(list);
	}
	
	@Transactional
	public List retrieve(int id){
		return em.find(List.class, id);
	}
	
	public int getListCount(){
		TypedQuery<List> query = em.createQuery("SELECT l FROM List", List.class);
		
		return query.getResultList().size();
	}

}
