package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<h1> Corneli </h1>");
//		out.println("</html>");
		String nomeUsusario = request.getParameter("usuario");
		String senhaUsusario = request.getParameter("senha");
		
		System.out.println("SESSION: "+nomeUsusario);
		if (nomeUsusario.equals("admin") &&  senhaUsusario.equals("123")) {			
			request.getSession().setAttribute("usuario",nomeUsusario);
			System.out.println("SESSION: "+request.getSession().getAttribute("usuario"));
			
			response.sendRedirect("email.jsp");//redirecionar o cliente para uma página
		} else {	
			//encaminhar uma requisição para ser atendida por outro recurso (forward).
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);//chama o goGet acima...
	}

}
