package net.sytes.joaojunior.code;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.sytes.joaojunior.model.Aluno;
import net.sytes.joaojunior.utils.JPAUtil;

public class JpaAluno {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		manager.getTransaction().begin();
		Aluno a = new Aluno();
		a.setNome("Fulano2 de tal");
		a.setRG("899999999999");
		a.setCPF("899.999.999-99");
		a.setCep("50000-000");
		a.setCidade("Cidade2");
		a.setEndereco("Rua2 das ruas");
		a.setBairro("Centro2");
		manager.persist(a);
		manager.getTransaction().commit();
		manager.close();

	}

}
