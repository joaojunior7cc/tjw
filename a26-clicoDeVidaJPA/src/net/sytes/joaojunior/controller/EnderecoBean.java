package net.sytes.joaojunior.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import net.sytes.joaojunior.dao.EnderecoDao;
import net.sytes.joaojunior.model.Endereco;

@ManagedBean
public class EnderecoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Endereco endereco;
	private EnderecoDao dao;
	
	@PostConstruct
	private void init() {//este metodo eh executado apos a injetcao de dependencia
		endereco = new Endereco();
		dao = new EnderecoDao(Endereco.class);
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public EnderecoDao getDao() {
		return dao;
	}
	public void setDao(EnderecoDao dao) {
		this.dao = dao;
	}

	public String salvar() {
		dao.salve(endereco);
		return "endereco";
	}
}
