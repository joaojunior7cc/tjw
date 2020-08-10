package net.sytes.joaojunior.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sytes.joaojunior.model.Semana;
import net.sytes.joaojunior.bean.SemanaBean;;;

/**
 * Servlet implementation class SemanaServlet
 */
public class SemanaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemanaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				
		String dia =request.getParameter("dia");
		System.out.println(dia);
		
		Semana sem = new Semana();
		SemanaBean.populateBean(sem, request);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<h1> Dia da Semana (num):" + sem.getDia() + "</h1>");
		out.println("<h1> Dia da Semana: " + sem.getDiaDaSemana() + "</h1>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
