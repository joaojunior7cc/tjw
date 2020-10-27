package br.edu.ifce.services;

import java.util.List;
import br.edu.ifce.model.StatusModel;

public interface StatusServiceInterface {
	
	public StatusModel getById(Long id);
	
	public List<StatusModel>findAll();
	
	public void save(StatusModel stm);
	
	public void update(StatusModel stm);

	public void delete(StatusModel stm);
	
}
