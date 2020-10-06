package net.sytes.joaojunior.code;

import java.io.IOException;
import java.util.Calendar;
import javax.persistence.EntityManager;

import net.sytes.joaojunior.dao.AlunoDao;
import net.sytes.joaojunior.model.Aluno;
import net.sytes.joaojunior.model.Endereco;
import net.sytes.joaojunior.model.ExtraCurricular;
import net.sytes.joaojunior.model.Sede;
import net.sytes.joaojunior.model.Telefone;
import net.sytes.joaojunior.utils.JPAUtil;
import net.sytes.joaojunior.utils.ReadLob;


public class DaoSalve {
	public static void main (String args[]) throws IOException {
		EntityManager manager = JPAUtil.getEntityManager();
		
		manager.getTransaction().begin();
		
		byte[] foto = new ReadLob().getFoto("/home/joaojr/Imagens/aluno.jpg") ;
		
		Calendar c = Calendar.getInstance();
		c.set(2020, 01, 01);
		
		Aluno a = new Aluno();
		a.setNome("Ciclano de Tal");
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
		
		manager.persist(atv1);
		manager.persist(atv2);
		manager.persist(s);				
		manager.persist(t1);
		manager.persist(t2);
		manager.persist(e);
		//manager.persist(a);		
		AlunoDao as = new AlunoDao();
		as.salve(a,manager);
		manager.getTransaction().commit();
		manager.close();
		
		
		
	}
}
