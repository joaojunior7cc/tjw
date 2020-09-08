package net.sytes.joaojunior.code;

import java.io.IOException;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.sytes.joaojunior.model.Aluno;
import net.sytes.joaojunior.model.Endereco;
import net.sytes.joaojunior.utils.JPAUtil;
import net.sytes.joaojunior.utils.ReadLob;

public class JpaAluno {

	public static void main(String[] args) throws IOException {
		EntityManager manager = JPAUtil.getEntityManager();
		
		byte[] foto = new ReadLob().getFoto("/home/joaojr/Imagens/aluno.jpg");
		Calendar c = Calendar.getInstance();
		c.set(2020,01,01);
		
		manager.getTransaction().begin();
		Aluno a = new Aluno();
		a.setNome("Fulano2 de tal");
		a.setRG("899999999999");
		a.setCPF("899.999.999-99");
		/*
		 * a.setCep("50000-000"); a.setCidade("Cidade2");
		 * a.setEndereco("Rua2 das ruas"); a.setBairro("Centro2");
		 */
		Endereco e = new Endereco();
		e.setLogradouro("Rua do amores");
		e.setCep("60.000-000");
		e.setBairro("Timbo");
		e.setCidade("Maracanau");
		manager.persist(e);//precisa persistir
		
		a.setEndereco(e);
		a.setIra(9.82);		
		a.setFotografia(foto);
		a.setNascimento(c);
		manager.persist(a);
		manager.getTransaction().commit();
		manager.close();

	}

}
