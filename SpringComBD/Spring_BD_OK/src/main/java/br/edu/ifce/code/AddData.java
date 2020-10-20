package br.edu.ifce.code;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




import br.edu.ifce.Beans.usuario;



public class AddData {
	public static void main (String[] args){
		
		
		EntityManagerFactory conn = Persistence.createEntityManagerFactory("tjw_jpa01");
		EntityManager db = conn.createEntityManager();
		
	    usuario u = new usuario();
	    u.setLogin("admin");
	    u.setSenha("123456");
	    
	    u.getPermissao().add("ROLE_ADMIN");
	    u.getPermissao().add("ROLE_MANAGER");
	    u.getPermissao().add("ROLE_USER");
	    
	    
	    u.setActive(true);
	    
	    db.persist(u);
		db.getTransaction().begin();
		db.getTransaction().commit();
	}

}
