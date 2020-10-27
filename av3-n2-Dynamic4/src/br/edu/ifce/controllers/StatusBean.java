package br.edu.ifce.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.edu.ifce.dao.StatusDao;
import br.edu.ifce.model.StatusModel;

@ManagedBean
@ViewScoped
public class StatusBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StatusModel status;
	private StatusDao dao;
	private List<StatusModel> listaStatus;
	private StatusModel statusPendente;

	@PostConstruct
	private void init() {
		status = new StatusModel();
		dao = new StatusDao();
		listaStatus = this.findAll();
		statusPendente = new StatusModel();
	}

	
	//############### Metodos
	
	public boolean getAchouStatus(List<StatusModel> listaStatus, String st) {
		for (StatusModel s : listaStatus) { 
			if (s.getStatus().equalsIgnoreCase(st)) { return true;	} 
		}
		return false;
	}
	
	public void cadastrarStatusDefault(ComponentSystemEvent event) {
				
		if (!getAchouStatus(this.listaStatus, "Pendente")) { 
			this.statusPendente.setStatus("Pendente"); 
			dao.save(statusPendente); 
			System.out.println("######## cadastrarStatusDefault PENDENTE ID "+statusPendente.getId() );
		}
		
		if (!getAchouStatus(this.listaStatus, "Concluido")) {
			StatusModel concluido = new StatusModel();
			concluido.setStatus("Concluido"); 
			dao.save(concluido); 
			System.out.println("######## cadastrarStatusDefault CONCLUIDO");
		} 
	}

	
	//Metodos BD

	public String save() {
		dao.save(status);
		this.listaStatus = findAll();
		status = new StatusModel();
		return "Salve Status";
	}

	public String update(StatusModel status) {
		dao.update(status);
		this.listaStatus = findAll();
		status = new StatusModel();
		return "Update Status";
	}

	public String delete(StatusModel status) {
		dao.delete(status);
		this.listaStatus = findAll();
		status = new StatusModel();
		return "Delete Status";
	}

	public List<StatusModel> findAll() {
		return dao.findAll();
	}

	public StatusModel getById(Long id) {
		status = dao.getById(id);
		return status;
	}

	
	// Getters and Setters

	public StatusModel getStatus() {
		return status;
	}

	public void setStatus(StatusModel status) {
		this.status = status;
	}

	public StatusDao getDao() {
		return dao;
	}

	public void setDao(StatusDao dao) {
		this.dao = dao;
	}

	public List<StatusModel> getListaStatus() {
		return listaStatus;
	}

	public void setListaStatus(List<StatusModel> listaStatus) {
		this.listaStatus = listaStatus;
	}

	public StatusModel getStatusPendente() {
		return statusPendente;
	}

	public void setStatusPendente(StatusModel statusPendente) {
		this.statusPendente = statusPendente;
	}

}
