package net.sytes.joaojunior.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import net.sytes.joaojunior.model.Sede;
import net.sytes.joaojunior.utils.JPAUtil;

public class SedeDao {
	
	EntityManager manager = JPAUtil.getEntityManager();
	
	public Sede getById(Long id) {		
		return manager.find(Sede.class, id);
	}

	public List<Sede> findAll() {
		String JPQL = "select s from Sede s";
		TypedQuery<Sede> atq = manager.createQuery(JPQL,Sede.class);	
		return atq.getResultList();
	}
	public void salve(Sede s,EntityManager manager) {
		manager.persist(s);
	}
	public void update(Sede s) {
		manager.getTransaction().begin();
		manager.merge(s);
		manager.getTransaction().commit();
		manager.close();
	}
	public void delete(Long id) {
		manager.getTransaction().begin();
		manager.remove(getById(id));		
		manager.getTransaction().commit();
		manager.close();
	}
}
