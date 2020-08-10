package net.sytes.joaojunior.teste;
import java.net.MalformedURLException;

import org.apache.commons.mail.EmailException;

import net.sytes.joaojunior.bean.Mail;
import net.sytes.joaojunior.mail.CommonsMail;

public class personal {
  public static void main(String args[]) throws MalformedURLException, EmailException{
	  CommonsMail mail = new CommonsMail();
	  Mail m = new Mail();
	  mail.enviaEmailSimples(m);
  }
}
