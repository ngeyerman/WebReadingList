package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;

public class ListDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserReadingList");
	
	public void insertNewListDetails(ListDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListDetails> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<ListDetails>allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
		return allDetails;
	}
	
	public ListDetails searchForListByID(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListDetails found = em.find(ListDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void deleteItem(ListDetails listToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDetails> typedQuery = em.createQuery("SELECT d from ListDetails d where d.id = :selectedid", ListDetails.class);
		//sub parameter with date from the toDelete item
		typedQuery.setParameter("selectedid", listToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		ListDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateList(ListDetails toEdit) {
		EntityManager em= emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	

}
