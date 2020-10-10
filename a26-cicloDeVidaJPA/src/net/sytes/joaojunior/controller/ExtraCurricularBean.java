package net.sytes.joaojunior.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import net.sytes.joaojunior.dao.ExtraCurricularDao;
import net.sytes.joaojunior.model.ExtraCurricular;

@ManagedBean
public class ExtraCurricularBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ExtraCurricular extraCurricular;
	private ExtraCurricularDao dao;
	
	@PostConstruct
	private void init() {//este metodo eh executado apos a injetcao de dependencia
		extraCurricular = new ExtraCurricular();
		dao = new ExtraCurricularDao(ExtraCurricular.class);
	}
	
	public ExtraCurricular getExtraCurricular() {
		return extraCurricular;
	}
	public void setExtraCurricular(ExtraCurricular extraCurricular) {
		this.extraCurricular = extraCurricular;
	}
	public ExtraCurricularDao getDao() {
		return dao;
	}
	public void setDao(ExtraCurricularDao dao) {
		this.dao = dao;
	}

	public String salvar() {
		dao.salvar(extraCurricular);
		return "extraCurricular";
	}
}
