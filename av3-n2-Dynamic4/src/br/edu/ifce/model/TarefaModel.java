package br.edu.ifce.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_tarefa")
public class TarefaModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne (optional = false)
	@JoinColumn(name="status_id",referencedColumnName="id",nullable=false)
	private StatusModel status = new StatusModel();
	private String descricao;
	private Date data;
	@Column(columnDefinition = "boolean default false")
	private boolean editar;	
	//@Column(columnDefinition = "varchar(10) default 'Editar'")
	@Column(name = "tituloBtnEditar")
	private String tituloBtnEditar = "Editar";
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public StatusModel getStatus() {
		return status;
	}
	public void setStatus(StatusModel status) {
		this.status = status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isEditar() {
		return editar;
	}
	public void setEditar(boolean editar) {
		this.editar = editar;
	}
	public String getTituloBtnEditar() {
		return tituloBtnEditar;
	}
	public void setTituloBtnEditar(String tituloBtnEditar) {
		this.tituloBtnEditar = tituloBtnEditar;
	}
	
	
}
