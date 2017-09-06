package com.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.entities.BaseEntity;

@Component
public class BaseRepository<E extends BaseEntity> {
	@PersistenceContext
	private EntityManager em;
	
	private Class<E> clazz;
	
	public BaseRepository(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	public E findById(int id) {
		return em.find(this.clazz, id);
	}
	
	public void deleteById(int id) {
		E obj = this.findById(id);
		em.remove(obj);
	}
	
	public E persist(E instance) {
		em.persist(instance);
		return instance;
	}
	
	public List<E> findAll() {
		TypedQuery<E> query = em.createQuery("SELECT x FROM " + this.clazz.getName() + " x", this.clazz);
		
		return query.getResultList();
	}
	public int countAll() {
		return this.findAll().size();
	}
}
