package net.sytes.joaojunior.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.sytes.joaojunior.dao.AlunoDao;
import net.sytes.joaojunior.dao.SedeDao;
import net.sytes.joaojunior.model.Aluno;
import net.sytes.joaojunior.model.Sede;
import net.sytes.joaojunior.model.Telefone;

@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Aluno aluno;
	private AlunoDao dao;
	private Collection<Telefone> lphone;
	private Long idsede;
	
	@PostConstruct
	private void init() {
		aluno = new Aluno();
		dao = new AlunoDao();
		lphone = aluno.getTelefone();
		idsede = 1L;
	
	}
    
	public void addfone(String numero) {
		Telefone t = new Telefone();
		t.setTelefone(numero);
		t.setTipo("-- não informado --");
		this.lphone.add(t);
		
		for (Telefone telefone : lphone) {
			System.out.println(telefone.getTelefone());
		}
	}
		
	
	public String salvar() {
		System.out.println("####### sede id "+this.idsede);
		
		Sede sede = new SedeDao().getById(this.idsede);
		aluno.setSede(sede);
		dao.salvar(aluno);
		return "cadastroaluno";
		
	}
	
	
	

	public Long getIdsede() {
		return idsede;
	}

	public void setIdsede(Long idsede) {
		this.idsede = idsede;
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


	public void setLphone(Collection<Telefone> lphone) {
		this.lphone = lphone;
	}

		
	

}
