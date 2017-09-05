package com.daos;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Item;
import com.entities.User;

@Component
public class ItemDao {
  
  @PersistenceContext private EntityManager em;  
  
  @Transactional 
  public void persist(Item item){
    Item retrievedItem = this.retrieve(item.getID());
    if(retrievedItem != null){
      em.merge(item);
    }else{
      item.setLastChangedOn(new Timestamp(Calendar.getInstance().getTime().getTime()));
      em.persist(item);
    }
  }
  
  @Transactional
  public Item retrieve(int id){
    return em.find(Item.class, id);
  }
  
  
  @Transactional
  public void update(Item item){
    em.merge(item);
  }
  
  @Transactional
  public Item delete(int id){
    Item retrievedItem = this.retrieve(id);
    if(retrievedItem != null){
      em.remove(retrievedItem);
    }
    
    return retrievedItem;
    
  }
  
  
  public int getItemCount(){
    TypedQuery<Item> query = em.createQuery("SELECT i FROM Item", Item.class);
    
    return query.getResultList().size();
  }

}
