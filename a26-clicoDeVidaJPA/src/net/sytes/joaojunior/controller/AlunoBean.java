package net.sytes.joaojunior.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import net.sytes.joaojunior.dao.AlunoDao;
import net.sytes.joaojunior.model.Aluno;

@ManagedBean
public class AlunoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Aluno aluno;
	private AlunoDao dao;
	
	@PostConstruct
	private void init() {//este metodo eh executado apos a injetcao de dependencia
		aluno = new Aluno();
		dao = new AlunoDao();
	}
 
	

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public AlunoDao getDao() {
		return dao;
	}

	public void setDao(AlunoDao dao) {
		this.dao = dao;
	}

	public String salvar() {
		dao.salve(aluno);
		return "aluno";
	}
}
