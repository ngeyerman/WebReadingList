package controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Reader;

public class ReaderHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserReadingList");
	
	public void insertReader(Reader r) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Reader> showAllReaders(){
		EntityManager em = emfactory.createEntityManager();
		List<Reader> allReaders = em.createQuery("SELECT r FROM Reader r").getResultList();
		return allReaders;
	}
	
	public Reader searchForReaderByName(String readerName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Reader> typedQuery = em.createQuery("SELECT r FROM Reader r where r.readerName = :selectedName", Reader.class);
		typedQuery.setParameter("selectedName", readerName);
		typedQuery.setMaxResults(1);
		
		Reader found = typedQuery.getSingleResult();
		em.close();
		return found;
	}

}
