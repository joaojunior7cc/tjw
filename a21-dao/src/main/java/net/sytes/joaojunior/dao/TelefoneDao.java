package net.sytes.joaojunior.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import net.sytes.joaojunior.model.Telefone;
import net.sytes.joaojunior.utils.JPAUtil;

public class TelefoneDao {
	
	EntityManager manager = JPAUtil.getEntityManager();
	
	public Telefone getById(Long id) {		
		return manager.find(Telefone.class, id);
	}

	public List<Telefone> findAll() {
		String JPQL = "select t from Telefone t";
		TypedQuery<Telefone> atq = manager.createQuery(JPQL,Telefone.class);	
		return atq.getResultList();
	}
	public void salve(Telefone t,EntityManager manager) {
		manager.persist(t);
	}
	public void update(Telefone t) {
		manager.getTransaction().begin();
		manager.merge(t);
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
