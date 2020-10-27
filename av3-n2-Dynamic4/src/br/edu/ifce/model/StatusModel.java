package br.edu.ifce.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_status")
public class StatusModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	private String status;
	@OneToMany(mappedBy="status",cascade = CascadeType.ALL)
	private Collection<TarefaModel> tarefas = new ArrayList<TarefaModel>();	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Collection<TarefaModel> getTarefas() {
		return tarefas;
	}
	public void setTarefas(Collection<TarefaModel> tarefas) {
		this.tarefas = tarefas;
	}
	
	
	
}
