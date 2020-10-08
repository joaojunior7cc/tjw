package net.sytes.joaojunior.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import net.sytes.joaojunior.dao.TelefoneDao;
import net.sytes.joaojunior.model.Telefone;

@ManagedBean
public class TelefoneBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Telefone telefone;
	private TelefoneDao dao;
	
	@PostConstruct
	private void init() {//este metodo eh executado apos a injetcao de dependencia
		telefone = new Telefone();
		dao = new TelefoneDao(Telefone.class);
	}
	
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public TelefoneDao getDao() {
		return dao;
	}
	public void setDao(TelefoneDao dao) {
		this.dao = dao;
	}

	public String salvar() {
		dao.salve(telefone);
		return "telefone";
	}
}
