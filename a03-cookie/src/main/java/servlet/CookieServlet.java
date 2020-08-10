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
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Cookie cookiesRequest[] = null;
	private static Map<String,Integer> listaCookies = new HashMap<String, Integer>();
	
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
        super();        
    }
    
    protected void printCookies(Cookie[] cookies) {
    	for (int i=0; i< cookies.length; i++) {
    		System.out.println("Key: "+cookies[i].getName()+" Valor:"+cookies[i].getValue());
    	} 
    	System.out.println("\n");
    }
    
    protected Cookie criarCookie(String name,String value, int time) {   
    	Cookie c = new Cookie(name,value);
    	c.setMaxAge(time);
    	return c;
    }
    
    protected Cookie achouCookie(Cookie[] cookies ,String name) {
    	for (int i=0; i< cookies.length; i++) {
//    		System.out.println(name+"=="+cookies[i].getValue());
    		if(name.equals(cookies[i].getName())) {
    			return cookies[i];
    		}
    	}
		return null;    		
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{  
		    PrintWriter out = response.getWriter();  	
		    cookiesRequest = request.getCookies();
		    System.out.println("\nrequest.getCookies(POST)");
		    printCookies(cookiesRequest);
			String nomeUsusario = request.getParameter("nome");
			
		    if (cookiesRequest != null) {
		    	Cookie ck = achouCookie(cookiesRequest,nomeUsusario);
		    	if(ck == null) {
		    		System.out.println("IF: Nao Achou");
		    		
			    	Cookie c = criarCookie(nomeUsusario,"1",60*5);//name,value,time
				    response.addCookie(c);

				    System.out.println("\nadd(c: "+response.getHeader("Set-Cookie")+")");
				    
				    listaCookies.put(nomeUsusario,Integer.parseInt(c.getValue()));//usuario,count
				    System.out.println(listaCookies.get(nomeUsusario));
				    
				    out.print("<html>"); 	          
				    out.print("Welcome Abord: "+c.getName()+"<br>");	
				    out.print("Visited page: "+listaCookies.get(nomeUsusario)+"<br>");
				    out.print("<form method='get' action='index.jsp'>");  
				    out.print("<input type='submit' value='voltar'>");  
				    out.print("</form>");  	  
				    out.print("</html>");
		    	} else {
			    	System.out.println("Else: Achou");
//			    	incrementar qtd
			    	System.out.println("Atualizar: "+ ck.getValue());
				    System.out.println("Atualizar: "+listaCookies.get(nomeUsusario));
//			    	int qtd = Integer.parseInt(ck.getValue());//qtd: string to int
				    int qtd = listaCookies.get(ck.getName());
			    	qtd++;
			    	listaCookies.put(ck.getName(),qtd);
			    	ck.setValue(Integer.toString(qtd));
			    	
				    System.out.println("Atualizado: OK "+listaCookies.get(nomeUsusario));
				    System.out.println("Atualizado: OK "+ck.getValue());
				    
				    out.print("<html>"); 	          
				    out.print("Welcome back: "+nomeUsusario+"<br>");
				    out.print("Visited page: "+listaCookies.get(nomeUsusario)+"<br>");
				    out.print("<form method='get' action='index.jsp'>");  
				    out.print("<input type='submit' value='voltar'>");  
				    out.print("</form>");	  
				    out.print("</html>");  
			    }
		    }
		
		    out.close();
			  
		}catch(Exception e){
			System.out.println(e);

		    PrintWriter out = response.getWriter();  
		    
		    out.print("<html>"); 	          
		    out.print("<h1>Ops, Erro 404!</h1><br>"+e);	
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
