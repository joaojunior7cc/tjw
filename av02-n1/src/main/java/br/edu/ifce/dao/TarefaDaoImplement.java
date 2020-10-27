package br.edu.ifce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifce.model.StatusModel;
import br.edu.ifce.model.TarefaModel;
import br.edu.ifce.utils.JPAUtil;

public class TarefaDaoImplement implements TarefaDaoInterface{
		
	@Override
	public TarefaModel salvarTarefa(TarefaModel tarefa) {
		EntityManager manager = JPAUtil.getEntityManager();
		StatusModel s = manager.find(StatusModel.class, 1L);
		
		try {
			manager.getTransaction().begin();
			tarefa.setStatus(s);
			manager.persist(tarefa);
			manager.getTransaction().commit();
			manager.close();
		}
		catch (NullPointerException e) {
			System.out.println("Erro ### "+e);
		}
		catch (IllegalStateException e) {
			System.out.println("Erro ### "+e);
		}
		
		return tarefa;
	}
	
	@Override
	public void alterar(TarefaModel tam) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		try {			
			manager.getTransaction().begin();			
			manager.merge(tam);
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
	public void alterarStatus(Integer id, Integer id_status) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		TarefaModel taEditado = manager.find(TarefaModel.class, Long.valueOf(id));
		StatusModel s = manager.find(StatusModel.class, Long.valueOf(id_status));
		taEditado.setStatus(s);
		
		try {			
			manager.getTransaction().begin();			
			manager.persist(taEditado);
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
		TarefaModel ta = manager.find(TarefaModel.class,Long.valueOf(id));
		manager.getTransaction().begin();
		manager.remove(ta);
		manager.getTransaction().commit();
		manager.close();
	}
	
	@Override
	public TarefaModel getTarefaById(Integer id) {
		System.out.println("#### getTarefaById "+id);
		EntityManager manager = JPAUtil.getEntityManager();
		TarefaModel ta = manager.find(TarefaModel.class, Long.valueOf(id) );
		System.out.println(ta.getDescricao());
		return ta;
	}
	
	@Override
	public List<TarefaModel> getTarefasPendentes(Integer id_status) {
		EntityManager manager = JPAUtil.getEntityManager();
		Query query = manager.createQuery("from TarefaModel where status_id="+id_status);
		
		return query.getResultList();
	}

	@Override
	public List<TarefaModel> getTarefasAll() {
		EntityManager manager = JPAUtil.getEntityManager();
		Query query = manager.createQuery("from TarefaModel");
		
		return query.getResultList();
	}

}
