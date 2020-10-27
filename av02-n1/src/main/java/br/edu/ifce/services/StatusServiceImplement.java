package br.edu.ifce.services;

import java.util.List;
import br.edu.ifce.dao.StatusDaoImplement;
import br.edu.ifce.model.StatusModel;

public class StatusServiceImplement implements StatusServiceInterface{

	private StatusDaoImplement statusDaoImplement;
	
	public StatusServiceImplement(){
		statusDaoImplement = new StatusDaoImplement();
	}
	
	@Override
	public StatusModel salvar(StatusModel statusModel) {
		return statusDaoImplement.salvar(statusModel);
	}

	
	@Override
	public void alterar(StatusModel stm) {
		statusDaoImplement.alterar(stm);
	}
	

	@Override
	public void excluir(Integer id) {
		statusDaoImplement.excluir(id);
	}


	@Override
	public List<StatusModel> getStatusAll() {
		return statusDaoImplement.getStatusAll();
	}

	@Override
	public StatusModel getStatusById(Integer id) {
		return statusDaoImplement.getStatusById(id);
	}

}
