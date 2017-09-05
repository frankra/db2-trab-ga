package com.daos;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Group;
import com.entities.User;

@Component
public class GroupDao {
  
  @PersistenceContext private EntityManager em;
  
  
  @Transactional 
  public void persist(Group group){
    Group retrievedGroup = this.retrieve(group.getID());
    if(retrievedGroup != null){
      em.merge(group);
    }else{
      group.setLastChangedOn(new Timestamp(Calendar.getInstance().getTime().getTime()));
      em.persist(group);
    }
    
  }
  
  @Transactional
  public Group retrieve(int id){
    return em.find(Group.class, id);
  }
  
  @Transactional
  public void update(Group group){
    em.merge(group);
  }
  
  @Transactional
  public void delete(Group group){
    em.remove(group);
  }
  
  @Transactional
  public int getGroupCount(){
    TypedQuery<Group> query = em.createQuery("SELECT g FROM Group g ORDER BY g.name", Group.class);
    
    return query.getResultList().size();
  }
  
  @Transactional
  public List<Group> getAllGroups(){
    TypedQuery<Group> query = em.createQuery("SELECT g FROM Group g ORDER BY g.name", Group.class);
    
    return query.getResultList();
  }


}
