package br.edu.ifce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.edu.ifce.model.StatusModel;
import br.edu.ifce.utils.JPAUtil;

public class StatusDaoImplement implements StatusDaoInterface{
		
	@Override
	public StatusModel salvar(StatusModel status) {
		EntityManager manager = JPAUtil.getEntityManager();
		System.out.println("##### "+status.getId());
		System.out.println("##### "+status.getStatus());
		try {
			manager.getTransaction().begin();
			manager.persist(status);
			manager.getTransaction().commit();
			//manager.close();
		}
		catch (NullPointerException e) {
			System.out.println("Erro ### "+e);
		}
		catch (IllegalStateException e) {
			System.out.println("Erro ### "+e);
		}
		
		return status;
	}
	
	@Override
	public void alterar(StatusModel stm) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		try {			
			manager.getTransaction().begin();			
			manager.merge(stm);
			manager.getTransaction().commit();
			manager.close();
		}
		catch (NullPointerException e) {
			System.out.println("Erro ### "+e);
		}
		catch (IllegalStateException e) {
			System.out.println("Erro ### "+e);
		}
		
	}
	
	
	@Override
	public void excluir(Integer id) {
		System.out.println("#### excluir "+id);
		EntityManager manager = JPAUtil.getEntityManager();
		StatusModel sta = manager.find(StatusModel.class,Long.valueOf(id));
		manager.getTransaction().begin();
		manager.remove(sta);
		manager.getTransaction().commit();
		manager.close();
	}
	
	@Override
	public StatusModel getStatusById(Integer id) {
		System.out.println("#### getStatusById "+id);
		EntityManager manager = JPAUtil.getEntityManager();
		StatusModel st = manager.find(StatusModel.class, Long.valueOf(id) );
		System.out.println(st.getStatus());
		return st;
	}
	
	
	@Override
	public List<StatusModel> getStatusAll() {
		EntityManager manager = JPAUtil.getEntityManager();
		Query query = manager.createQuery("from StatusModel");
		
		return query.getResultList();
	}

}
