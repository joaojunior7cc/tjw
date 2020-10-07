package net.sytes.joaojunior.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import net.sytes.joaojunior.model.Endereco;
import net.sytes.joaojunior.utils.JPAUtil;

public class EnderecoDao {
	
	EntityManager manager = JPAUtil.getEntityManager();
	
	public Endereco getById(Long id) {		
		return manager.find(Endereco.class, id);
	}

	public List<Endereco> findAll() {
		String JPQL = "select e from Endereco e";
		TypedQuery<Endereco> atq = manager.createQuery(JPQL,Endereco.class);	
		return atq.getResultList();
	}
	
	public void salve(Endereco e,EntityManager manager) {
		manager.persist(e);
	}
	
	public void update(Endereco e) {
		manager.getTransaction().begin();
		manager.merge(e);
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
