package net.sytes.joaojunior.code;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.sytes.joaojunior.model.Aluno;

public class JpaAluno {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TJW");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		Aluno a = new Aluno();
		a.setNome("Fulano de tal");
		a.setRG("999999999999");
		a.setCPF("999.999.999-99");
		a.setCep("60000-000");
		a.setCidade("Cidade");
		a.setEndereco("Rua das ruas");
		a.setBairro("Centro");
		manager.persist(a);
		manager.getTransaction().commit();
		manager.close();
		factory.close();

	}

}
