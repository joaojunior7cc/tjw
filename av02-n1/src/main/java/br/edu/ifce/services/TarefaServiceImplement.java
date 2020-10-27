package br.edu.ifce.services;

import java.util.List;

import br.edu.ifce.dao.TarefaDaoImplement;
import br.edu.ifce.model.TarefaModel;

public class TarefaServiceImplement implements TarefaServiceInterface{

	private TarefaDaoImplement tarefaDaoImplement;
	
	public TarefaServiceImplement(){
		tarefaDaoImplement = new TarefaDaoImplement();
	}
	
	@Override
	public TarefaModel salvarTarefa(TarefaModel tarefaModel) {
		return tarefaDaoImplement.salvarTarefa(tarefaModel);
	}

	
	@Override
	public void alterar(TarefaModel tam) {
		tarefaDaoImplement.alterar(tam);
	}
	
	@Override
	public void alterarStatus(Integer id, Integer id_status) {
		tarefaDaoImplement.alterarStatus(id, id_status);
	}

	@Override
	public void excluir(Integer id) {
		tarefaDaoImplement.excluir(id);
	}

	@Override
	public List<TarefaModel> getTarefasPendentes(Integer id_status) {
		return tarefaDaoImplement.getTarefasPendentes(id_status);
	}

	@Override
	public List<TarefaModel> getTarefasAll() {
		return tarefaDaoImplement.getTarefasAll();
	}

	@Override
	public TarefaModel getTarefaById(java.lang.Integer id) {
		return tarefaDaoImplement.getTarefaById(id);
	}

}
