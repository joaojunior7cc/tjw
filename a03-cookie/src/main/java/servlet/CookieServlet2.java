package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet2
 */
public class CookieServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet2() {
        super();
    }

    protected void printCookies(Cookie[] cookies) {
    	for (int i=0; i< cookies.length; i++) {
    		System.out.println(cookies[i]+" -> Key: "+cookies[i].getName()+" value: "+cookies[i].getValue());
    	} 
    	System.out.println("\n");
    }
    
    protected Cookie criarCookie(String name,Integer value, int time) {   
    	Cookie c = new Cookie(name,Integer.toString(value));
    	c.setMaxAge(time);
    	return c;
    }
    
    protected int achouCookie(Cookie[] cookies ,String name) {
    	for (int i=0; i< cookies.length; i++) {
    		if( name.equals( cookies[i].getName() ) ) { return i; }
    	}
		return -1;    		
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{  
	    PrintWriter out = response.getWriter();  	
	    Cookie cookiesRequest[] = request.getCookies();
		String nomeUsuario = request.getParameter("nome");
    	String msg = "";
    	Integer qtd= null;			

	    System.out.println("\nrequest.getCookies(POST)");
	    printCookies(cookiesRequest);
		
	    if (cookiesRequest != null) {    	
	    	int a = achouCookie(cookiesRequest,nomeUsuario);

	    	if(a == -1) {//nao achou
	    		qtd=1;//criou agora
		    	Cookie c = criarCookie(nomeUsuario,qtd,60*10);//name,value,time
		    	response.addCookie(c);
	    		msg ="Welcome Abord: ";
	    	} else {//achou
		    	String tqtd = cookiesRequest[a].getValue();//qtd
		    	qtd  = Integer.parseInt(tqtd);//qtd: string to int
		    	tqtd = Integer.toString(++qtd);
		    	cookiesRequest[a].setValue(tqtd);//atualizar	  
		    	response.addCookie(cookiesRequest[a]);  			    
			    msg = "Welcome back: ";			     
		    }    		
	    }

	    out.print("<html>"); 	          
	    out.print(msg + nomeUsuario +"<br>");	
	    out.print("Visited page: "+qtd+"<br>");
	    out.print("<form method='get' action='index.jsp'>");  
	    out.print("<input type='submit' value='voltar'>");  
	    out.print("</form>");  	  
	    out.print("</html>");
	    out.close();
		  
	}catch(Exception e){
		System.out.println(e);

	    PrintWriter out = response.getWriter();  	    
	    out.print("<html>"); 	          
	    out.print("<h1>Ops2, Erro 404!</h1><br>"+e);	
	    out.print("<a href='index.jsp'>Home</a>");  
	} 
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request,response);
	
	}

}
