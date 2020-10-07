package net.sytes.joaojunior.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import net.sytes.joaojunior.model.Endereco;
import net.sytes.joaojunior.utils.JPAUtil;

public abstract class GenericDao<T> {
	
	private final EntityManager manager = JPAUtil.getEntityManager();
	private final Class<T> clazz;
	
	public GenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}
	public T getById(Long id) {		
		return manager.find(clazz, id);
	}

	public List<T> findAll() {
		String JPQL = "select a from " +clazz.getSimpleName().trim()+" a";
		System.out.println("#########"+JPQL);
		TypedQuery<T> atq = manager.createQuery(JPQL,clazz);	
		return atq.getResultList();
	}
	
	public void salve(T clazz,EntityManager manager) {
		manager.persist(clazz);
	}
	
	public void update(T clazz) {
		manager.getTransaction().begin();
		manager.merge(clazz);
		manager.getTransaction().commit();
		manager.close();

	}
	public void excluir(T clazz) {
		manager.getTransaction().begin();
		manager.remove(clazz);		
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
