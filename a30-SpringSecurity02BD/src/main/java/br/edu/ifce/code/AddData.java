package br.edu.ifce.code;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




import br.edu.ifce.Beans.Usuario;



public class AddData {
	public static void main (String[] args){
		
		
		EntityManagerFactory conn = Persistence.createEntityManagerFactory("tjw_jpa01");
		EntityManager db = conn.createEntityManager();
		
	    Usuario u = new Usuario();
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
