package br.edu.ifce.tjw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session
 */
public class VerificarCarrinhoDeCompras extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificarCarrinhoDeCompras() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		
		HttpSession sessao = request.getSession();
		
		
		  if ( sessao == null ) { p.println("Seu carrinho de compras está vazio");
		 
		 }  else {
			 ArrayList<String> carrinho = (ArrayList<String>) sessao.getAttribute("carrinho");
			 
			 if (carrinho != null) {
				 for(int i = 0; i < carrinho.size(); i++){
				 p.println(carrinho.get(i));
			} 
		   }
		} 	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
