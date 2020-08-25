package net.sytes.joaojunior.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sytes.joaojunior.beans.Cliente;
import net.sytes.joaojunior.dao.ClienteDao;
import net.sytes.joaojunior.utils.BeanUtilities;

/**
 * Servlet implementation class Controller
 */
public class  ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDao clientedao;
	String forward;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteController() {
		super();
		clientedao = new ClienteDao();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String app = request.getParameter("app");

		if ((app==null)  || (app.equalsIgnoreCase("listarCliente"))) {
			forward = "views/listar.jsp";
			request.setAttribute("clientes", clientedao.getAllClientes());
		} else
			if (app.equalsIgnoreCase("cadastro")) {
				forward = "views/cadastro.jsp";
			} else
				if (app.equalsIgnoreCase("excluir")) {
					forward = "views/listar.jsp";
					int id = Integer.parseInt(request.getParameter("clienteId"));
					clientedao.deleteCliente(id);
					request.setAttribute("clientes", clientedao.getAllClientes());
				}else
					if (app.equalsIgnoreCase("update")) {
						forward = "views/cadastro.jsp";
						int id = Integer.parseInt(request.getParameter("clienteId"));
						request.setAttribute("cliente", clientedao.getClienteById(id));
					}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		forward = "views/listar.jsp";
		Cliente cliente = new Cliente();
		BeanUtilities.populateBean(cliente, request);		

		if (cliente.getId() == 0) {
			clientedao.addCliente(cliente);
		} else {
			clientedao.updateCliente(cliente);
		}

		request.setAttribute("clientes", clientedao.getAllClientes());
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}