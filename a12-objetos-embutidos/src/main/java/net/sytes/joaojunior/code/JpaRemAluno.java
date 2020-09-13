package net.sytes.joaojunior.code;

import javax.persistence.EntityManager;

import br.edu.ifce.model.Aluno;
import br.edu.ifce.utils.JPAUtil;

public class JpaRemAluno {
	public static void main (String args[]) {
		EntityManager manager = JPAUtil.getEntityManager();
		Aluno a = manager.find(Aluno.class, 3L);
		/*
		 * O método find() recupera os dados desejados imediatamente.
		 * Já o método getReference() posterga essa tarefa até a primeira
		 * chamada de um método get no objeto desejado.
		 * 
		 */
		manager.remove(a);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
	
		manager.close();
	}

}
