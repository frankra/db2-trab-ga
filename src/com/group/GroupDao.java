package com.group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.user.User;

@Component
public class GroupDao {
	
	@PersistenceContext private EntityManager em;
	
	
	@Transactional 
	public void persist(Group group){
		em.persist(group);
	}
	
	@Transactional
	public Group retrieve(int id){
		return em.find(Group.class, id);
	}
	
	public int getGroupCount(){
		TypedQuery<Group> query = em.createQuery("SELECT g FROM Group g ORDER BY g.name", Group.class);
		
		return query.getResultList().size();
	}

}
