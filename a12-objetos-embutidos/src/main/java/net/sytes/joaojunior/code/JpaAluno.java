package net.sytes.joaojunior.code;

import java.io.IOException;
import java.util.Calendar;
import javax.persistence.EntityManager;

import net.sytes.joaojunior.model.Aluno;
import net.sytes.joaojunior.model.Endereco;
import net.sytes.joaojunior.utils.JPAUtil;
import net.sytes.joaojunior.utils.ReadLob;


public class JpaAluno {
	public static void main (String args[]) throws IOException {
		EntityManager manager = JPAUtil.getEntityManager();
		
		manager.getTransaction().begin();
		byte[] foto = new ReadLob().getFoto("/home/corneli/aluno.jpeg") ;
		
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
				
		a.setEndereco(e);
		a.setIra(9.82);
		a.setFotografia(foto);
		a.setNascimento(c);
		

		manager.persist(e);
		manager.persist(a);
		manager.getTransaction().commit();
		manager.close();
	}
}
