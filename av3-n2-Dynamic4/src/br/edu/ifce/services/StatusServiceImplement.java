package br.edu.ifce.services;

import java.util.List;
import br.edu.ifce.dao.StatusDao;
import br.edu.ifce.model.StatusModel;

public class StatusServiceImplement implements StatusServiceInterface{

	private static StatusDao status;
	
	public StatusServiceImplement(){
		status = new StatusDao();
	}
	
	@Override
	public StatusModel getById(Long id) {
		return status.getById(id);
	}
	
	@Override
	public List<StatusModel> findAll() {
		return status.findAll();
	}

	@Override
	public void save(StatusModel stm) {
		status.save(stm);
	}

	@Override
	public void update(StatusModel stm) {
		status.update(stm);
	}

	@Override
	public void delete(StatusModel stm) {
		status.delete(stm);
	}


}
