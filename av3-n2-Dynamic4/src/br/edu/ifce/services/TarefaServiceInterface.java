package br.edu.ifce.services;

import java.util.List;

import br.edu.ifce.model.TarefaModel;

public interface TarefaServiceInterface {
	/*
	 * TarefaModel salvarTarefa(TarefaModel tarefa);
	 * 
	 * public TarefaModel getTarefaById(Integer id);
	 * 
	 * public void alterar(TarefaModel tam);
	 * 
	 * void alterarStatus(Integer id, Integer id_status);
	 * 
	 * void excluir(Integer id);
	 * 
	 * List<TarefaModel>getTarefasPendentes(Integer id_status);
	 * 
	 * List<TarefaModel>getTarefasAll();
	 */

	public TarefaModel getById(Long id);
	
	public List<TarefaModel>findAll();
	
	public List<TarefaModel> findTarefasByStatusId(Long id);
	
	public void save(TarefaModel tm);
	
	public void update(TarefaModel tm);

	void delete(TarefaModel tm);
	
}
