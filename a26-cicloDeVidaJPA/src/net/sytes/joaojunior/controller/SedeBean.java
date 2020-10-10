package net.sytes.joaojunior.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import net.sytes.joaojunior.dao.SedeDao;
import net.sytes.joaojunior.model.Sede;

@ManagedBean
public class SedeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sede sede = new Sede();
	private SedeDao dao = new SedeDao();
	private List<Sede> sedes = this.listar();
	
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
		
	public List<Sede> getSedes() {
		return sedes;
	}

	public void setSedes(List<Sede> sedes) {
		this.sedes = sedes;
	}

	public String salvar() {
		dao.salvar(sede);
		return "sede";
	}
	
	public List<Sede> listar() {
		return dao.findAll();
		
	}
	
}
