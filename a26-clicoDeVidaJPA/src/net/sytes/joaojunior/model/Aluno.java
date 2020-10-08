package net.sytes.joaojunior.model;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
	@NamedQuery(name = "Aluno.listarTodos", query = "select a from Aluno a"),
}) 
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="end_id",unique = true)
	private Endereco endereco;
	
	@ManyToOne (optional = false)// aluno nao pode ser false
	private Sede sede;
	
	@ManyToMany
	private Collection<ExtraCurricular> atividadesExtras = new ArrayList<ExtraCurricular>();
	
	@OneToMany
	private Collection<Telefone> telefone = new ArrayList<Telefone>();
	
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
	
	//Associa uma entidade a um elemento do tipo basico(string)
	//Sera gerada uma table adicional aluno_ocorrencia
	@ElementCollection
	private List<String> ocorrencias;
	
	public Collection<ExtraCurricular> getAtividadesExtras() {
		return atividadesExtras;
	}
	public void setAtividadesExtras(Collection<ExtraCurricular> atividadesExtras) {
		this.atividadesExtras = atividadesExtras;
	}
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}
	public Collection<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(Collection<Telefone> telefone) {
		this.telefone = telefone;
	}
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
	public List<String> getOcorrencias() {
		return ocorrencias;
	}
	public void setOcorrencias(List<String> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	
	
}
