package br.edu.ifce.services;

import java.util.List;

import br.edu.ifce.dao.TarefaDao;
import br.edu.ifce.model.TarefaModel;

public class TarefaServiceImplement implements TarefaServiceInterface{

	private TarefaDao tarefaDao;

	public TarefaServiceImplement(){
		tarefaDao = new TarefaDao();
	}

	@Override
	public void save(TarefaModel tm) {
		tarefaDao.save(tm);
	}


	@Override
	public void update(TarefaModel tm) {
		tarefaDao.update(tm);
	}

	@Override
	public void delete(TarefaModel tm){
		tarefaDao.delete(tm);
	}


	@Override public List<TarefaModel> findTarefasByStatusId(Long id) {
		return tarefaDao.findTarefasByStatusId(id); 
	}


	@Override
	public List<TarefaModel> findAll() {
		return tarefaDao.findAll();
	}

	@Override
	public TarefaModel getById(Long id) {
		return tarefaDao.getById(id);
	}

}
