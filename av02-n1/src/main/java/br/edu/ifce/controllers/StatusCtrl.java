package br.edu.ifce.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifce.model.StatusModel;
import br.edu.ifce.services.StatusServiceImplement;
import br.edu.ifce.utils.BeanUtilities;

/**
 * Servlet implementation class StatusCtrl
 */
public class StatusCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StatusServiceImplement statusService;
	String forward;      
	List<StatusModel> liStatus; 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StatusCtrl() {
		super();
		statusService = new StatusServiceImplement();
		liStatus = new ArrayList<StatusModel>();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String st = request.getParameter("opStatus");
		
		System.out.println("############## st = "+st);

		if (st.equals(null) || st.equals("TodosOsStatus")){

			forward = "view/listarStatus.jsp";
			request.setAttribute("listaStatus", statusService.getStatusAll());
			request.setAttribute("titulo_st", "Todos os Status");

		}else if(st.equals("CadastrarStatusDefault")){

			forward = "view/listarStatus.jsp";			
			liStatus =cadastrarStatus();							

			request.setAttribute("listaStatus", statusService.getStatusAll());
			request.setAttribute("titulo_st", "Todas as Status");


		}else if(st.equals("ExcluirStatus")) {

			forward = "view/listarStatus.jsp";
			Integer id = Integer.parseInt(request.getParameter("statusId"));

			System.out.println("####### Excluir id= "+id);

			statusService.excluir(id);
			request.setAttribute("listaStatus", statusService.getStatusAll());
			request.setAttribute("titulo_st", "Todas as Status");
		}
		else {
			System.out.println("erro...");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected List<StatusModel> cadastrarStatus() {
		System.out.println("###### cadastrarStatus(entrou)");
		StatusServiceImplement statusServ = new StatusServiceImplement();
		StatusModel sm1 = new StatusModel();
		liStatus = new ArrayList<StatusModel>();

		sm1.setId(1L);
		sm1.setStatus("Pendente");
		statusServ.salvar(sm1);	
		liStatus.add(sm1);

		StatusModel sm2 = new StatusModel();
		sm2.setId(2L);
		sm2.setStatus("Concluído");
		statusServ.salvar(sm2);	
		liStatus.add(sm2);
		
		return liStatus;
	}
}
