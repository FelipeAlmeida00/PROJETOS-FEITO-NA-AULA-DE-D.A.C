package controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

//@WebServlet(urlPatterns={"/Controller","/main"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getServletPath();
		//System.out.println(action);
		if(action.equals("/main")) //comparação de string em java é feita com .equals ao invés de ==
		{
			contatos(request,response);
		} else if(action.equals("/inserir")) { 
			novoContato(request,response); // esse método deve ser criado dentro do servlet
		}
		}
	
	
	
		//Listar contatos
		protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("clientes.jsp");
			// Criando um objeto que irá receber os dados JavaBeans
			//ArrayList<JavaBeans> lista = dao.listarContatos();
		} 
		
		/*dao.testeConexao();*/ //descomentar para testar a conexão
		
		//Novo contato
		protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//teste de recebimento dos dados do formulário
			
			System.out.println(request.getParameter("idcon"));
			System.out.println(request.getParameter("idade"));
			System.out.println(request.getParameter("endereço"));
			System.out.println(request.getParameter("escolaridade"));
			
			
			//setar as variáveis JavaBeans
			contato.setIdcon(request.getParameter("idcon"));
			contato.setIdade(request.getParameter("idade"));
			contato.setEndereço(request.getParameter("endereço"));
			contato.setEscolaridade(request.getParameter("escolaridade"));
			
			
			//invocar o método inserirContato passando o objeto contato
			dao.inserirContato(contato);
			
			//redirecionar para o documento agenda.jsp
			response.sendRedirect("main");
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
