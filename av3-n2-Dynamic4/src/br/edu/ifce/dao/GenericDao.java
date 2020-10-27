package br.edu.ifce.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.edu.ifce.utils.JPAUtil;

public abstract class GenericDao<T> {
	
	protected final EntityManager manager = JPAUtil.getEntityManager();
	private final Class<T> clazz;
	
	public GenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public T getById(Long id) {		
		return manager.find(clazz, id);
	}

	public List<T> findAll() {
		String JPQL = "select a from " +clazz.getSimpleName().trim()+" a";
		//System.out.println("######### GenericDao findAll"+JPQL);
		TypedQuery<T> atq = manager.createQuery(JPQL,clazz);	
		
		return atq.getResultList();
	}
	
	public void save(T clazz) {
		manager.getTransaction().begin();
		manager.persist(clazz);
		manager.getTransaction().commit();
		//manager.close();
	}
	
	public void update(T clazz) {
		manager.getTransaction().begin();
		manager.merge(clazz);
		//manager.persist(clazz);
		manager.getTransaction().commit();
		//manager.close();
	}
	
	public void delete(T clazz) {
		manager.getTransaction().begin();
		manager.remove(clazz);		
		manager.getTransaction().commit();
		//manager.close();
	}
}
