package net.sytes.joaojunior.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "tbl_aluno")
public class Aluno {
	@Id
	@GeneratedValue
	private Long id;
	
	//length: Limita a quantidade de caracteres de uma string
	//nullable: Determina se o campo pode possuir valores null ou não
	//unique: Determina se uma coluna pode ter valores repetidos ou não
	//precision: Determina a quantidade de dígitos de um número decimal a serem armazenadas
	//scale: Determina a quantidade de casas decimais de um número decimal
	
	@Column (name = "nome_aluno")
	private String nome;
	
	@Column (name = "rg")
	private String RG;
	
	@Column (name = "cpf")
	private String CPF;
	
	@OneToOne
	@JoinColumn(name="end_id")
	private Endereco endereco;
	
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@Column(name = "ira_aluno", length = 30, nullable = false, scale = 2 , precision = 2 )
	private Double ira;
	
	//Large Objects
	@Lob
	private byte [] fotografia ;
	
	//java.util.Date e java.util.Calendar
	// TemporalType.DATE: Armazena apenas a data (dia, mês e ano).
	// TemporalType.TIME: Armazena apenas o horário (hora, minuto e segundo).
	// TemporalType.TIMESTAMP (Padrão): Armazena a data e o horário.
	@Temporal(TemporalType.DATE)
	private Calendar nascimento;
	
	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	public byte[] getFotografia() {
		return fotografia;
	}
	public void setFotografia(byte[] fotografia) {
		this.fotografia = fotografia;
	}
	public Double getIra() {
		return ira;
	}
	public void setIra(Double ira) {
		this.ira = ira;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}

	
}
