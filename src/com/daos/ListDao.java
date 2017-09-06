package com.daos;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.entities.List;

@Component
public class ListDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void persist(List list) {
		List retrievedList = this.retrieve(list.getID());
		if (retrievedList != null) {
			em.merge(list);
		} else {
			list.setLastChangedOn(new Timestamp(Calendar.getInstance().getTime().getTime()));
			em.persist(list);
		}

	}

	@Transactional
	public List retrieve(int id) {
		return em.find(List.class, id);
	}

	@Transactional
	public void update(List list) {
		em.merge(list);
	}

	@Transactional
	public int getListCount() {
		TypedQuery<List> query = em.createQuery("SELECT l FROM List l", List.class);

		return query.getResultList().size();
	}

	@Transactional
	public java.util.List<com.entities.List> getLists() {
		TypedQuery<com.entities.List> query = em.createQuery("SELECT l FROM List l", com.entities.List.class);

		return query.getResultList();
	}

}
