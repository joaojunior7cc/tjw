package net.sytes.joaojunior.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "tbl_aluno")//novo nome da tabela
public class Aluno {
	@Id//PK
	@GeneratedValue//Auto incremento
	private Long id;
	
	//Length: limita o tam da string
	//nulable: Determina se o campo pode possuir valores null ou nao
	//unique: Determina se a coluna pode ter calores repetidos ou nao
	//precision: Qtd de digitos de um numero decimal a seram armazenados
	//scale: qtd de casas decimais de um numero decimal
	@Column (name = "nome_aluno")
	private String nome;
	@Column (name = "rg")
	private String RG;
	@Column (name = "cpf")
	private String CPF;

	//@Embedded
	@OneToOne//cria um automaticamente uma coluna (endereco_id) na tbl_aluno
	@JoinColumn (name = "end_id")//renomear endereco_id
	private Endereco endereco;
	
	@Column  (name="ira_aluno", length = 30, nullable = false,scale = 2,precision = 2)
	private Double ira;
	@Lob//Large objects
	private byte [] fotografia;
	
	//java.util.DAte e java.util.Calendar
	//TemporalType.Date: (dia mes ano)
	//TemporalType.TIME: (hora,minuto, segundo)
	//TemporalType.TIMESTAMP(padrao): (hora,minuto, segundo)
	@Temporal(TemporalType.DATE)
	private Calendar nascimento;
	
	
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
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
