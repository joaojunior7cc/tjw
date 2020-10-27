package br.edu.ifce.utils;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("TJW-TRAB");
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
