package net.sytes.joaojunior.code;

import javax.persistence.EntityManager;

import net.sytes.joaojunior.model.Endereco;
import net.sytes.joaojunior.utils.JPAUtil;

public class ConsultasJPQL {
	public static void main(String args[]) {
		EntityManager manager = JPAUtil.getEntityManager();
		Endereco endereco = manager.find(Endereco.class, 6L);
		System.out.println("######################################");
		System.out.println(endereco.getCidade());
		System.out.println(endereco.getBairro());
	}

}
