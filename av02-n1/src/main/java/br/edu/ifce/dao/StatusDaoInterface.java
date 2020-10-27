package br.edu.ifce.dao;

import java.util.List;
import br.edu.ifce.model.StatusModel;

public interface StatusDaoInterface{
	StatusModel salvar(StatusModel status);
	
	public StatusModel getStatusById(Integer id);
	
	public void alterar(StatusModel stm);

	void excluir(Integer id);
	
	List<StatusModel>getStatusAll();
}
