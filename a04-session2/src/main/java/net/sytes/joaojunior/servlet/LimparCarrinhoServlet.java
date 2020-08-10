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
 * Servlet implementation class LimparCarrinhoServlet
 */
public class LimparCarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static HttpSession sessao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LimparCarrinhoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());		

		sessao = request.getSession();	
		if(sessao.getAttribute("carrinho") != null) {			
			limparCarrinho(request,response);
		}else {
			alertCarrinho(response,"O carrinho JA ESTA VAZIO!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void limparCarrinho(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		System.out.println("Sessao: "+sessao);
		
		sessao.removeAttribute("carrinho");
		HttpSession sessao = request.getSession();
		System.out.println("Sessao: "+sessao.getAttribute("carrinho"));
		alertCarrinho(response,"O CARRINHO FOI ESVAZIADO!");	
		
		//Removendo dos atributos de AddCarrinho
		AddCarrinhoServlet.setCarrinho(new ArrayList());
	}
	
	protected void alertCarrinho( HttpServletResponse response,String msg) throws ServletException,IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<script> alert('LIMPAR : "+msg+"') </script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<a href='http://localhost:8080/a04-session2/roupas.jsp'>Roupas</a>");	
		out.println("</body>");
		out.println("</html>");
	}

}
