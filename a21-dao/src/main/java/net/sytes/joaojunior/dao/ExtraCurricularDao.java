package net.sytes.joaojunior.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import net.sytes.joaojunior.model.ExtraCurricular;
import net.sytes.joaojunior.utils.JPAUtil;

public class ExtraCurricularDao {
	
	EntityManager manager = JPAUtil.getEntityManager();
	
	public ExtraCurricular getById(Long id) {		
		return manager.find(ExtraCurricular.class, id);
	}

	public List<ExtraCurricular> findAll() {
		String JPQL = "select ex from ExtraCurricular ex";
		TypedQuery<ExtraCurricular> atq = manager.createQuery(JPQL,ExtraCurricular.class);	
		return atq.getResultList();
	}
	public void salve(ExtraCurricular ex,EntityManager manager) {
		manager.persist(ex);
	}
	public void update(ExtraCurricular ex) {
		manager.getTransaction().begin();
		manager.merge(ex);
		manager.getTransaction().commit();

	}
	public void delete(Long id) {
		manager.getTransaction().begin();
		manager.remove(getById(id));
		manager.getTransaction().commit();
	}
}
