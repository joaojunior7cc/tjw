package net.sytes.joaojunior.code;

import javax.persistence.EntityManager;

import net.sytes.joaojunior.model.Aluno;
import net.sytes.joaojunior.utils.JPAUtil;

public class JpaRemAluno {
	
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		//Buscar no bd
		Aluno a = manager.find(Aluno.class, 3L);//recupera os dados imediatamente
		//Aluno a = manager.getReference(Aluno.class, 2L);//posterga esta tarefa ate a primeira chamada de um metodo get no obj desejado.
		
		//Deletar no bd
		manager.getTransaction().begin();
		manager.remove(a);
		manager.getTransaction().commit();
		manager.close();

	}
}
