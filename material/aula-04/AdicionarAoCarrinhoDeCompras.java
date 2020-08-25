package br.edu.ifce.tjw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifce.beans.Carro;
import br.edu.ifce.utils.BeanUtilities;

/**
 * Servlet implementation class Servlet
 */
public class AdicionarAoCarrinhoDeCompras extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarAoCarrinhoDeCompras() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String atributo = request.getParameter("nome");
		/*
		 * PrintWriter out = response.getWriter();
		 * 
		 * Carro c = new Carro(); BeanUtilities.populateBean(c, request);
		 * out.println("<html>");
		 * 
		 * out.println("<h1>" + c.getAno() + "</h1>"); out.println("<h1>" + c.getMarca()
		 * + "</h1>"); out.println("<h1>" + c.getModelo() + "</h1>");
		 * 
		 * out.println("</html>");
		 */
		
		ArrayList<String> carrinho = new ArrayList();
		carrinho.add("Camiseta");
		carrinho.add("sapato");
		carrinho.add("cueca");
		
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("carrinho", carrinho);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
