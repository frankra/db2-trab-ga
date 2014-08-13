package com.list.item;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ItemDao {
	
	@PersistenceContext private EntityManager em;	
	
	@Transactional 
	public void persist(Item item){
		item.setLastChangedOn(new Timestamp(Calendar.getInstance().getTime().getTime()));
		em.persist(item);
	}
	
	@Transactional
	public Item retrieve(int id){
		return em.find(Item.class, id);
	}
	
	public int getItemCount(){
		TypedQuery<Item> query = em.createQuery("SELECT i FROM Item", Item.class);
		
		return query.getResultList().size();
	}

}
