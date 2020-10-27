package br.edu.ifce.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import br.edu.ifce.dao.StatusDao;
import br.edu.ifce.dao.TarefaDao;
import br.edu.ifce.model.StatusModel;
import br.edu.ifce.model.TarefaModel;

//@ManagedBean(name = "tarefaBean", eager = true)
@ManagedBean
@ViewScoped
public class TarefaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TarefaModel tarefa;
	private TarefaDao dao;
	private List<TarefaModel> listaTarefa ;
	private List<TarefaModel> listaTarefaPendentes ;
	private Long idStatusSelect;
	private Long idStatusPendente;
	
	@PostConstruct
	private void init() {
		tarefa = new TarefaModel();
		dao = new TarefaDao();
		listaTarefa = this.findAll();
		idStatusPendente = this.getIdAchouStatus("Pendente");
		listaTarefaPendentes = this.findTarefasByStatusId(idStatusPendente);
	}

	//Metodos
	
	public void setListaBySelect(ValueChangeEvent event) {
		Long id = Long.parseLong(event.getNewValue().toString().trim());
		System.out.println("@@@@@@@@@@@@ Id"+id);
		
		if (id==-1L) {
			listaTarefa = this.findAll();
		}else {
			listaTarefa = this.findTarefasByStatusId(id);
		}
	}
	
	public Long getIdAchouStatus(String st) {
		List<StatusModel> listaStatus = new StatusDao().findAll();
		for (StatusModel sm : listaStatus) { 
			if (sm.getStatus().equalsIgnoreCase(st)) { return sm.getId(); } 
		}
		return -1L;//nao achou
	}
	
	public TarefaModel atualizar(TarefaModel tarefa) {
		tarefa.setEditar(!tarefa.isEditar());
		
		if(tarefa.getTituloBtnEditar().equals("Editar")) {
			tarefa.setTituloBtnEditar("Salvar");
		}else if(tarefa.getTituloBtnEditar().equals("Salvar")) {
			tarefa.setTituloBtnEditar("Editar");
			update(tarefa);
		}
		return tarefa;
	}	
			
	//A anotacao @ViewScoped faz a atualizao toda vez que a pag eh chamada
	/*
	 * public void atualizarTarefas(ComponentSystemEvent event) { this.listaTarefa
	 * =findAll(); for (TarefaModel tm : listaTarefa) {
	 * System.out.println("### atualizarTarefas "+tm.getDescricao()+" "+tm.getStatus
	 * ().getId()+" "+tm.getStatus().getStatus()); } }
	 */
	
	
	//Metodos BD
	
	public StatusModel  getStatusByIdDao(Long id) {		
		return new StatusDao().getById(id); 
	}	
	
	public String save() {
		System.out.println("### save "+tarefa.getStatus().getId()+" "+tarefa.getDescricao()+tarefa.getData());
		tarefa.getStatus().setId(idStatusPendente);
		tarefa.getStatus().setStatus("Pendente");
		dao.save(tarefa);
		tarefa = new TarefaModel();
		this.listaTarefa =findAll();
		this.listaTarefaPendentes=findTarefasByStatusId(idStatusPendente);
		return "Salve Tarefa";
	}
	
	public String update(TarefaModel tarefa) {
		tarefa.setStatus(getStatusByIdDao(getIdStatusSelect()));
		System.out.println("$$$ update getStatusByIdDao "+tarefa.getDescricao()+" "+getIdStatusSelect()+" "+tarefa.getStatus().getStatus());
		dao.update(tarefa);
		
		this.tarefa = new TarefaModel();
		this.listaTarefa =findAll();
		this.listaTarefaPendentes=findTarefasByStatusId(idStatusPendente);
		return "Update Tarefa";
	}
	
	public String delete(TarefaModel tarefa) {
		dao.delete(tarefa);
		this.tarefa = new TarefaModel();
		this.listaTarefa =findAll();
		this.listaTarefaPendentes=findTarefasByStatusId(idStatusPendente);
		return "Delete Tarefa";
	}
	
	public List<TarefaModel> findAll(){		
		return dao.findAll();
	}
	
	public List<TarefaModel> findTarefasByStatusId(Long id){		
		return dao.findTarefasByStatusId(id);
	}
	
	public TarefaModel getById(Long id){		
		return dao.getById(id);
	}

	
	
	// 	Getters and Setters
	
	public TarefaModel getTarefa() {
		return tarefa;
	}

	public void setTarefa(TarefaModel tarefa) {
		this.tarefa = tarefa;
	}

	public TarefaDao getDao() {
		return dao;
	}

	public void setDao(TarefaDao dao) {
		this.dao = dao;
	}

	public List<TarefaModel> getListaTarefa() {
		return listaTarefa;
	}

	public void setListaTarefa(List<TarefaModel> listaTarefa) {
		this.listaTarefa = listaTarefa;
	}

	public List<TarefaModel> getListaTarefaPendentes() {
		return listaTarefaPendentes;
	}

	public void setListaTarefaPendentes(List<TarefaModel> listaTarefaPendentes) {
		this.listaTarefaPendentes = listaTarefaPendentes;
	}

	public Long getIdStatusSelect() {
		return idStatusSelect;
	}

	public void setIdStatusSelect(Long idStatus) {
		this.idStatusSelect = idStatus;
	}

	public Long getIdStatusPendente() {
		return idStatusPendente;
	}

	public void setIdStatusPendente(Long idStatusPendente) {
		this.idStatusPendente = idStatusPendente;
	}

}
