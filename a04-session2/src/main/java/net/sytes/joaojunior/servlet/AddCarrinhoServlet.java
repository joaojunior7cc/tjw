package net.sytes.joaojunior.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCarrinhoServlet
 */
public class AddCarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static ArrayList<String> carrinho;
	private static HttpSession sessao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarrinhoServlet() {
        super();
        this.carrinho = new ArrayList();  
    }

    
    private boolean addCarrinho(String produto) {
    	try {
    		carrinho.add(produto);
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao adicionar produto no carrinho: "+e);
			return false;
		}    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String produto = request.getParameter("sel-prod");
		sessao = request.getSession();		
		
		if (addCarrinho(produto)) {
			sessao.setAttribute("carrinho", carrinho);
			System.out.println("Class Sessao: "+sessao.getAttribute("carrinho"));
			System.out.println("Class Carrinho: "+getCarrinho());
			alertCarrinho(request, response);
			//response.sendRedirect("roupas.jsp");
			
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void alertCarrinho(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<script> alert('ADD : "+getCarrinho()+"') </script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<a href='http://localhost:8080/a04-session2/roupas.jsp'>Roupas</a>");	
		out.println("</body>");
		out.println("</html>");
	}
	

	public static void setSessao(HttpSession sessao) {
		AddCarrinhoServlet.sessao = sessao;
	}


	public static HttpSession getSessao() {
		return sessao;
	}

    public static void setCarrinho(ArrayList<String> carrinho) {
		AddCarrinhoServlet.carrinho = carrinho;
	}

    public static ArrayList<String> getCarrinho() {
		return carrinho;
	}

}
