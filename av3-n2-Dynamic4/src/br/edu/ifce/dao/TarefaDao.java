package br.edu.ifce.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import br.edu.ifce.model.TarefaModel;


public class TarefaDao extends GenericDao<TarefaModel>{
		
	public TarefaDao() {
		super(TarefaModel.class);
	}
	
	public List<TarefaModel> findTarefasByStatusId(Long id) {
		String JPQL = "select a from TarefaModel a where a.status.id="+id;
		//System.out.println("######### TarefaDao findTarefasPendente "+JPQL);
		TypedQuery<TarefaModel> atq = manager.createQuery(JPQL,TarefaModel.class);	
		
		return atq.getResultList();
	}

}
