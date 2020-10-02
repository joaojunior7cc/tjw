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

import net.sytes.joaojunior.model.Aluno;
import net.sytes.joaojunior.model.Endereco;
import net.sytes.joaojunior.model.ExtraCurricular;
import net.sytes.joaojunior.model.Sede;
import net.sytes.joaojunior.model.Telefone;
import net.sytes.joaojunior.utils.JPAUtil;
import net.sytes.joaojunior.utils.ReadLob;

public class ConsultasJPQL {
	public static void main(String args[]) throws IOException {
		EntityManager manager = JPAUtil.getEntityManager();
		populardb(manager);
		//consultaInicial(manager);
		consultaSimples(manager);
		consultaSimplesQ(manager);
	}
	
	public static void consultaInicial(EntityManager manager) {
		//String sql = "select * from tbl_aluno";
		String jpql = "select a from Aluno a";//Aluno (Entity)
		//Query tipada
		TypedQuery<Aluno> consulta = manager.createQuery(jpql,Aluno.class);
		List<Aluno> alunos = consulta.getResultList();
		System.out.println("##################################");
		for (Aluno aluno : alunos) {
			System.out.println(aluno.getNome());
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
	
	
	
	public static void populardb(EntityManager manager) throws IOException {
		manager.getTransaction().begin();
		byte[] foto = new ReadLob().getFoto("/home/joaojr/imagens/aluno.jpeg") ;
		
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
		
		manager.persist(atv1);
		manager.persist(atv2);
		manager.persist(s);				
		manager.persist(t1);
		manager.persist(t2);
		manager.persist(e);
		manager.persist(a);
		
		
		manager.getTransaction().commit();
		//manager.close();
	}
}
