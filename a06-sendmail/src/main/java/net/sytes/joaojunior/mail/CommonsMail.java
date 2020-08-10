package net.sytes.joaojunior.mail;
import java.net.MalformedURLException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import net.sytes.joaojunior.bean.Mail;

//pom.xml add: https://mvnrepository.com/artifact/org.apache.commons/commons-email/1.5
public class CommonsMail {  
	
	public void enviaEmailSimples(Mail mail) throws EmailException { 

		SimpleEmail email = new SimpleEmail();  
		try {
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			//email.setSmtpPort(587);
			//email.setAuthenticator(new DefaultAuthenticator("tjw20201@gmail.com", "@@10202wjt")); 
			email.setAuthenticator(new DefaultAuthenticator("nodemcuesp12e@gmail.com", "esp826612e")); 
			//email.setSSL(true);  
			//email.setTLS(false);
			email.setSSLOnConnect(true);
			email.setFrom("nodemcuesp12e@gmail.com","TJW");
			//email.setFrom("tjw20201@gmail.com","TJW");
			email.setSubject(mail.getAssunto());
			email.setMsg(mail.getMensagem());
			email.addTo(mail.getDestinatario());
			email.send();
			System.out.println("Email enviado!!!");
		} catch (EmailException e) {
			System.out.println("Erro: "+e.getMessage());
			System.out.println("Erro: "+e.getCause());

		}
	}

	public static void main(String[] args) throws EmailException, MalformedURLException {  
		System.out.println("#####CommonsMail-MAIN");
		new CommonsMail();  
	}		

}
