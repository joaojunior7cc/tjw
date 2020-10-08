package net.sytes.joaojunior.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import net.sytes.joaojunior.dao.SedeDao;
import net.sytes.joaojunior.model.Sede;

@ManagedBean
public class SedeBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sede sede;
	private SedeDao dao;
	
	@PostConstruct
	private void init() {//este metodo eh executado apos a injetcao de dependencia
		sede = new Sede();
		dao = new SedeDao(Sede.class);
	}
	
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}
	public SedeDao getDao() {
		return dao;
	}
	public void setDao(SedeDao dao) {
		this.dao = dao;
	}

	public String salvar() {
		dao.salve(sede);
		return "sede";
	}
}
