package net.sytes.joaojunior.code;
import java.io.IOException;
/*JPQL - Java Persistence Query Language
 * Eh uma linguagem de consulta (Mysql), porem eh orientada a objeto
 * */
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import net.sytes.joaojunior.dao.AlunoDao;
import net.sytes.joaojunior.dao.EnderecoDao;
import net.sytes.joaojunior.dao.GenericDao;
import net.sytes.joaojunior.dao.ExtraCurricularDao;
import net.sytes.joaojunior.dao.SedeDao;
import net.sytes.joaojunior.dao.TelefoneDao;
import net.sytes.joaojunior.model.Aluno;
import net.sytes.joaojunior.model.Endereco;
import net.sytes.joaojunior.model.ExtraCurricular;
import net.sytes.joaojunior.model.ResumoAluno;
import net.sytes.joaojunior.model.Sede;
import net.sytes.joaojunior.model.Telefone;
import net.sytes.joaojunior.utils.JPAUtil;
import net.sytes.joaojunior.utils.ReadLob;

public class DAOGenericTestes {
	public static void main(String args[]) throws IOException {
		populardb();
		//consultaInicial(manager);
		//consultaSimples(manager);
		//consultaSimplesQ(manager);
		//contarElementos(manager);
		//mediaIra(manager);
		//maisVelho(manager);
		//partesObj(manager);
		//selectNew(manager);
		//namedConsulta(manager);
		
		Aluno a1 = new AlunoDao().getById(14L);
		System.out.println("########"+a1.getNome());
		System.out.println("########"+a1.getId());		
		a1.setNome("Tux dos Anzois Pereira");
		
		new AlunoDao().update(a1);
		Aluno a2 = new AlunoDao().getById(14L);
		System.out.println("########"+a2.getNome());
		System.out.println("########"+a2.getId());

		new AlunoDao().delete(6L);//ok
		
		  AlunoDao ad = new AlunoDao(); 
		  List<Aluno> alunos = ad.findAll(); for (Aluno
		  aluno : alunos) { System.out.println("########"+aluno.getNome());
		  System.out.println("########"+aluno.getId());
		  System.out.println("------------"); }
		 
		
		salvarAluno();
		
	}
	
	public static void salvarAluno() throws IOException {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		
		byte[] foto = new ReadLob().getFoto("/home/joaojr/Imagens/aluno.jpg") ;
		
		Calendar c = Calendar.getInstance();
		c.set(2020, 01, 01);
		
		Aluno a = new Aluno();
		a.setNome("Ciclano de Ta2");
		a.setRG("8888888888");
		a.setCPF("888.888.888-88");
			
		Endereco e = new Endereco();
		e.setCep("6000-000");
		e.setCidade("Maracanau");
		e.setLogradouro("Rua dos amores");
		e.setBairro("Timbo");
		
		Telefone t1 = new Telefone();
		t1.setTelefone("99999-9999");
		t1.setTipo("Celular");
		
		Telefone t2 = new Telefone();
		t2.setTelefone("3333-3333");
		t2.setTipo("Fixo");
		
		a.getTelefone().add(t1);
		a.getTelefone().add(t2);
		
		// Aqui ocorre a definição que "e" está relacionado a "a"
		a.setEndereco(e);		
		a.setIra(9.82);
		a.setFotografia(foto);
		a.setNascimento(c);
		
		
		Sede s = new Sede();
		s.setNome("IFCE Maracanau");
		s.setDiretor("Julio Cesar");
		//Sede s = manager.find(Sede.class, 1L);
		a.setSede(s);
		
		ExtraCurricular atv1 = new ExtraCurricular();
		atv1.setNome("Judo");
		atv1.setValor("50,00");
		
		ExtraCurricular atv2 = new ExtraCurricular();
		atv2.setNome("Reforço Escolar");
		atv2.setValor("100,00");
		
		a.getAtividadesExtras().add(atv1);
		a.getAtividadesExtras().add(atv2);
		
		//manager.persist(atv1);
		new ExtraCurricularDao(null).salve(atv1, manager);
		//manager.persist(atv2);
		new ExtraCurricularDao(null).salve(atv2, manager);
		//manager.persist(s);	
		new SedeDao(null).salve(s, manager);
		//manager.persist(t1);
		new TelefoneDao(null).salve(t1, manager);
		//manager.persist(t2);
		new TelefoneDao(null).salve(t2, manager);
		//manager.persist(e);
		new EnderecoDao(null).salve(e, manager);
		//manager.persist(a);		
		new AlunoDao().salve(a,manager);
		
		manager.getTransaction().commit();
		manager.close();
	}
	
	public static void consultaInicial(EntityManager manager) {
		//String sql = "select * from tbl_aluno";
		String jpql = "select a from Aluno a order by a.ira DESC";//Aluno (Entity)
		//Query tipada
		TypedQuery<Aluno> consulta = manager.createQuery(jpql,Aluno.class);
		List<Aluno> alunos = consulta.getResultList();
		System.out.println("##################################");
		for (Aluno aluno : alunos) {
			System.out.println(aluno.getNome()+" "+aluno.getIra());
		}
	}
	
	
	public static void consultaSimples(EntityManager manager) {
		//String sql = "select * from tbl_aluno where id='7'";
		String jpql = "select a from Aluno a where a.id=7";//Aluno (Entity)
		//Query tipada
		TypedQuery<Aluno> consulta = manager.createQuery(jpql,Aluno.class);
		Aluno aluno = consulta.getSingleResult();
		
		System.out.println("##################################");
		System.out.println(aluno.getNome());
		
	}
	
	public static void consultaSimplesQ(EntityManager manager) {
		//String sql = "select * from tbl_aluno where id='7'";
		String jpql = "select a from Aluno a where a.id=7";//Aluno (Entity)
		//Query tipada
		Query consulta = manager.createQuery(jpql);
		Aluno aluno = (Aluno) consulta.getSingleResult();
		
		System.out.println("##################################");
		System.out.println(aluno.getNome());
		
	}
	
	
	
	public static void populardb() throws IOException {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		//##########################################################
		byte[] foto = new ReadLob().getFoto("/home/joaojr/Imagens/aluno.jpg") ;
		
		Calendar c = Calendar.getInstance();
		c.set(2020, 01, 01);
		
		Aluno a = new Aluno();
		a.setNome("Fulano de Tal");
		a.setRG("9999999999");
		a.setCPF("999.999.999-99");
			
		Endereco e = new Endereco();
		e.setCep("6000-000");
		e.setCidade("Maracanau");
		e.setLogradouro("Rua dos amores");
		e.setBairro("Timbo");
		
		Telefone t1 = new Telefone();
		t1.setTelefone("99999-9999");
		t1.setTipo("Celular");
		
		Telefone t2 = new Telefone();
		t2.setTelefone("3333-3333");
		t2.setTipo("Fixo");
		
		a.getTelefone().add(t1);
		a.getTelefone().add(t2);
		
		// Aqui ocorre a definição que "e" está relacionado a "a"
		a.setEndereco(e);
		a.setIra(9.82);
		a.setFotografia(foto);
		a.setNascimento(c);
		
		Sede s = new Sede();
		s.setDiretor("Júlio César");
		s.setNome("IFCE - Campus Maracanaú");
		a.setSede(s);
		
		ExtraCurricular atv1 = new ExtraCurricular();
		atv1.setNome("Judô");
		atv1.setValor("50,00");
		
		ExtraCurricular atv2 = new ExtraCurricular();
		atv2.setNome("Reforço Escolar");
		atv2.setValor("100,00");
		
		a.getAtividadesExtras().add(atv1);
		a.getAtividadesExtras().add(atv2);		
		
		manager.persist(atv1);
		manager.persist(atv2);

		manager.persist(s);				
		manager.persist(t1);
		manager.persist(t2);
		//manager.persist(e);
		manager.persist(a);
		
		
		byte[] foto1 = new ReadLob().getFoto("/home/joaojr/Imagens/aluno.jpg") ;
		
		Calendar c1 = Calendar.getInstance();
		c.set(1970, 01, 01);
		
		Aluno a1 = new Aluno();
		a1.setNome("Tux");
		a1.setRG("9999999999");
		a1.setCPF("999.999.999-99");
			
		Endereco e1 = new Endereco();
		e1.setCep("6000-000");
		e1.setCidade("Pacatuba");
		e1.setLogradouro("Rua das Araucárias");
		e1.setBairro("Vila das Flores");
		
		Telefone t3 = new Telefone();
		t3.setTelefone("99999-9999");
		t3.setTipo("Celular");
		
		Telefone t4 = new Telefone();
		t4.setTelefone("3333-3333");
		t4.setTipo("Fixo");
		
		a1.getTelefone().add(t3);
		a1.getTelefone().add(t4);
		a1.setSede(s);
		
		// Aqui ocorre a definição que "e" está relacionado a "a"
		a1.setEndereco(e1);
		a1.setIra(9.0);
		a1.setFotografia(foto1);
		a1.setNascimento(c1);

		a1.getAtividadesExtras().add(atv1);
		
			
		manager.persist(t3);
		manager.persist(t4);
		//manager.persist(e);
		manager.persist(a1);
		
		byte[] foto2 = new ReadLob().getFoto("/home/joaojr/Imagens/aluno.jpg") ;
		
		Calendar c2 = Calendar.getInstance();
		c.set(1950, 01, 01);
		
		Aluno a2 = new Aluno();
		a2.setNome("Lion Man");
		a2.setRG("9999999999");
		a2.setCPF("999.999.999-99");
			
		Endereco e2 = new Endereco();
		e2.setCep("6000-000");
		e2.setCidade("Fortaleza");
		e2.setLogradouro("Godofredo Maciel");
		e2.setBairro("Maraponga");
		
		Telefone t5 = new Telefone();
		t5.setTelefone("99999-9999");
		t5.setTipo("Celular");
		
		Telefone t6 = new Telefone();
		t6.setTelefone("3333-3333");
		t6.setTipo("Fixo");
		
		a2.getTelefone().add(t5);
		a2.getTelefone().add(t6);
		a2.setSede(s);
		
		// Aqui ocorre a definição que "e" está relacionado a "a"
		a2.setEndereco(e2);
		a2.setIra(9.0);
		a2.setFotografia(foto2);
		a2.setNascimento(c2);

		a2.getAtividadesExtras().add(atv2);
		
			
		manager.persist(t5);
		manager.persist(t6);
		//manager.persist(e);
		manager.persist(a2);
		
		manager.getTransaction().commit();	
		manager.close();
	}

	public static void contarElementos(EntityManager manager) {
		/* AVG: Media de valores numericos
		 * MAX: Maximo entre valores comparaveis (numero, data, string)
		 * MIN: Minimo entre valores comparaveis (numero, data, string)
		 * SUN: Soma dos valores
		 * */
		//String sql = "select count(*) from tbl_aluno ";
		String jpql = "select count(a) from Aluno a";//Aluno (Entity)
		TypedQuery<Long> consulta = manager.createQuery(jpql,Long.class);
		Long resultado = consulta.getSingleResult();
		System.out.println("QTD de alunos: "+resultado);
	}
	
	public static void mediaIra(EntityManager manager) {
		//String sql = "select avg(ira) from tbl_aluno ";
		String jpql = "select avg(a.ira) from Aluno a";//Aluno (Entity)
		TypedQuery<Double> consulta = manager.createQuery(jpql,Double.class);
		Double resultado = consulta.getSingleResult();
		System.out.println("Media dos IRAs (alunos): "+resultado);
	}
	
	public static void maisVelho(EntityManager manager) {
		//String sql = "select min(nascimento) from tbl_aluno ";
		String jpql = "select min(a.nascimento) from Aluno a";//Aluno (Entity)
		TypedQuery<Calendar> consulta = manager.createQuery(jpql,Calendar.class);
		Calendar dtNasc = consulta.getSingleResult();
		
		String jpql2 = "select a from Aluno a where a.nascimento = :data";
		TypedQuery<Aluno> consulta2 = manager.createQuery(jpql2,Aluno.class);
		consulta2.setParameter("data", dtNasc);
		List<Aluno> alunos = consulta2.getResultList();
		System.out.println("############################################");
		for (Aluno aluno : alunos) {
			System.out.println("Mais Velho: "+aluno.getId()+" "+aluno.getNome());
		}
	}
	
	public static void partesObj(EntityManager manager) {
		//String sql = "select nome,cpf from tbl_aluno ";
		String jpql = "select a.nome,a.CPF from Aluno a";//Aluno (Entity)
		Query consulta = manager.createQuery(jpql);//sem tipo
		List<Object[]> resultado = consulta.getResultList();
		for (Object[] linha: resultado) {
			System.out.println(linha[0] + " " + linha[1]);
		}		
	}
	
	public static void selectNew (EntityManager manager) {
		//Intancia o construct e passa os parametros
		String jpql = "select new net.sytes.joaojunior.model.ResumoAluno" +
			       "(a.nome, a.CPF) from Aluno a";
		Query consulta = manager.createQuery(jpql);
		List<ResumoAluno> resultado = consulta.getResultList();
		
		for(ResumoAluno r : resultado) {
			  System.out.println(r.getNome());
			}
	}
	
	public static void namedConsulta (EntityManager manager) {
		
		Query consulta = manager.createNamedQuery("Aluno.listarTodos");
		List<Aluno> alunos = consulta.getResultList();
		for(Aluno a : alunos) {
			  System.out.println(a.getNome() + ' ' + a.getIra() );
			}
	}
}
