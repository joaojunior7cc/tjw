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
import br.edu.ifce.model.TarefaModel;
import br.edu.ifce.services.TarefaServiceImplement;
import br.edu.ifce.utils.BeanUtilities;

/**
 * Servlet implementation class TarefaCtrl
 */
public class TarefaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TarefaServiceImplement tarefaService;
	String forward;      
	List<StatusModel> liStatus; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TarefaCtrl() {
        super();
        tarefaService = new TarefaServiceImplement();
        liStatus = new ArrayList<StatusModel>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ta = request.getParameter("tarefa");	
		
		System.out.println("############## ta = "+ta);	
		
		if (ta.equals(null) || ta.equals("TarefasPendentes")){
			
			forward = "view/listarTarefas.jsp";
			request.setAttribute("tarefas", tarefaService.getTarefasPendentes(1));
			request.setAttribute("titulo", "Tarefas Pendentes");
			
			System.out.println("###############???"+tarefaService.getTarefasPendentes(1));
			
			List<TarefaModel> tra = tarefaService.getTarefasPendentes(1);
			
			for (TarefaModel t : tra) {
				
				System.out.println(t.getDescricao());
				System.out.println(t.getData());
				System.out.println(t.getStatus());
			}				
		}
		else if(ta.equals("TodasAsTarefas")){
			
			forward = "view/listarTarefas.jsp";
			request.setAttribute("tarefas", tarefaService.getTarefasAll());
			request.setAttribute("titulo", "Todas as Tarefas");
			
			System.out.println("###############???"+tarefaService.getTarefasAll());
			
			List<TarefaModel> tra = tarefaService.getTarefasAll();
			
			for (TarefaModel t : tra) {
				
				System.out.println(t.getDescricao());
				System.out.println(t.getData());
				System.out.println(t.getStatus());
			}	
		}
		else if(ta.equals("Cadastrar")){
			
			forward = "view/listarTarefas.jsp";
			TarefaModel tam = new TarefaModel();
			BeanUtilities.populateBean(tam, request);
			tarefaService.salvarTarefa(tam);	
			request.setAttribute("tarefas", tarefaService.getTarefasAll());
			request.setAttribute("titulo", "Todas as Tarefas");

			System.out.println("####### "+tam.getDescricao());
			System.out.println("####### "+tam.getData());
			
		}
		else if(ta.equals("Editar")) {
			
			forward = "view/atualizarTarefa.jsp";
			Integer id = Integer.parseInt(request.getParameter("tarefaId"));
			
			TarefaModel te = tarefaService.getTarefaById(id);
			
			System.out.println("####### Alterar id "+id);

			request.setAttribute("id", id);
			request.setAttribute("descricao", te.getDescricao());
			request.setAttribute("data", te.getData());
			request.setAttribute("status_id", te.getStatus().getId());
			
		}
		else if(ta.equals("EditarStatus")) {
			
			forward = "view/listarTarefas.jsp";
			Integer id = Integer.parseInt(request.getParameter("tarefaId"));
			Integer status_id = Integer.parseInt(request.getParameter("status_id"));
			
			System.out.println("####### Alterar id "+status_id);
			
			tarefaService.alterarStatus(id, status_id);
			request.setAttribute("tarefas", tarefaService.getTarefasAll());
			request.setAttribute("titulo", "Todas as Tarefas");
		}
		else if(ta.equals("Atualizar")){
			
			forward = "view/listarTarefas.jsp";
			TarefaModel tam = new TarefaModel();
			BeanUtilities.populateBean(tam, request);
			Long lid = Long.valueOf(request.getParameter("status_id"));
			tam.getStatus().setId(lid);
			tarefaService.alterar(tam);
			
			request.setAttribute("tarefas", tarefaService.getTarefasAll());
			request.setAttribute("titulo", "Todas as Tarefas");
			System.out.println("####### "+tam.getDescricao());
			System.out.println("####### "+tam.getData());
			
		}
		else if(ta.equals("Excluir")) {
			
			forward = "view/listarTarefas.jsp";
			int id = Integer.parseInt(request.getParameter("tarefaId"));

			System.out.println("####### Excluir id= "+id);
			
			tarefaService.excluir(id);
			request.setAttribute("tarefas", tarefaService.getTarefasAll());
			request.setAttribute("titulo", "Todas as Tarefas");
		}
		else if(ta.equals("BuscarById")){
			
			forward = "view/listarTarefas.jsp";
			int id = Integer.parseInt(request.getParameter("tarefaId"));
			List<TarefaModel> tab =new ArrayList<TarefaModel>();
			tab.add(tarefaService.getTarefaById(id));
			request.setAttribute("tarefas", tab);
			request.setAttribute("titulo", "Busca por Id");
			
			System.out.println("####### Buscar id= "+id);			
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

}
