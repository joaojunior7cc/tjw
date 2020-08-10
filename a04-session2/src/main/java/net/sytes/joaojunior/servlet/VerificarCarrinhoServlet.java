package net.sytes.joaojunior.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VerificarCarrinhoServlet
 */
public class VerificarCarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static HttpSession sessao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificarCarrinhoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		sessao = request.getSession();	
		
		if(sessao.getAttribute("carrinho") != null) {
			verCarrinho(request,response);
		}else {
			alertCarrinho(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void verCarrinho(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		PrintWriter out = response.getWriter();
		System.out.println("Class Sessao: "+sessao.getAttribute("carrinho"));
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h4>Carrinho</h4>");
		out.println("<p>"+sessao.getAttribute("carrinho")+"</p>");
		out.println("<a href='http://localhost:8080/a04-session2/roupas.jsp'>Roupas</a>");	
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void alertCarrinho(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<script> alert('VERIFICAR : CARRINHO VAZIO!') </script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<a href='http://localhost:8080/a04-session2/roupas.jsp'>Roupas</a>");	
		out.println("</body>");
		out.println("</html>");
	}
}
