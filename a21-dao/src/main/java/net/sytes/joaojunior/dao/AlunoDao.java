package net.sytes.joaojunior.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import net.sytes.joaojunior.model.Aluno;
import net.sytes.joaojunior.utils.JPAUtil;

public class AlunoDao {
	
	EntityManager manager = JPAUtil.getEntityManager();
	
	public Aluno getById(Long id) {		
		return manager.find(Aluno.class, id);
	}

	public List<Aluno> findAll() {
		String JPQL = "select a from Aluno a";
		TypedQuery<Aluno> atq = manager.createQuery(JPQL,Aluno.class);	
		return atq.getResultList();
	}
	public void salve(Aluno a,EntityManager manager2) {
		//manager.getTransaction().begin();
		manager2.persist(a);
		//manager.getTransaction().commit();
	}
	public void update(Aluno a) {
		manager.getTransaction().begin();
		manager.merge(a);
		manager.getTransaction().commit();

	}
	public void delete(Long id) {
		manager.getTransaction().begin();
		manager.remove(getById(id));
		manager.getTransaction().commit();
	}
}
