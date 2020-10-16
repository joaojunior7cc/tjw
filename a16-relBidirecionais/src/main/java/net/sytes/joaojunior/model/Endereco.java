package net.sytes.joaojunior.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_endereco")
public class Endereco {
	@Id
	@GeneratedValue
	private Long id;
	
	private String logradouro;
	
	private String bairro;
	
	private String cidade;
	
	private String cep;
	/* Aula rel Bidirecional
		Se so colocar esta anotacao ira criar a segunda FK (Nao eh o que eu quero)
		Para ter um unica FK bidirecional tem que colocar os parametros 
		O mappedByc diz quem eh o dono da relBidirecional
		No caso eh endereco la no Aluno
	*/
	@OneToOne(mappedBy = "endereco",cascade = CascadeType.ALL)//dono do relBidirecional
	private Aluno aluno;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
