package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conexion.Nota;
import com.crud.NotaCRUD;


@WebServlet("/adminNota")
public class AdminNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NotaCRUD notaCRUD;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			notaCRUD = new NotaCRUD(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminNota() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servletx2..");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				System.out.println("entro");
				registrar(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;	
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;

			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servletx2..");
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{

		RequestDispatcher dispatcher= request.getRequestDispatcher("addNewStudent.jsp");
		dispatcher.forward(request, response);
	}

	
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Nota nota = new Nota(request.getParameter("rollNo"), Integer.parseInt(request.getParameter("s1")),Integer.parseInt(request.getParameter("s2")),Integer.parseInt(request.getParameter("s3")),
				Integer.parseInt(request.getParameter("s4")),Integer.parseInt(request.getParameter("s5")),Integer.parseInt(request.getParameter("s6")));
		notaCRUD.insertar(nota);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("addNota.jsp");
		dispatcher.forward(request, response);
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("addNota.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrarNota.jsp");
		List<Nota> listaNotas= notaCRUD.listarNotas();
		request.setAttribute("lista", listaNotas);
		dispatcher.forward(request, response);
	}		
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Nota nota = notaCRUD.obtenerPorId(request.getParameter("rollNo"));
		request.setAttribute("nota", nota);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editarNota.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Nota nota = new Nota(request.getParameter("rollNo"), Integer.parseInt(request.getParameter("s1")),Integer.parseInt(request.getParameter("s2")),Integer.parseInt(request.getParameter("s3")),
				Integer.parseInt(request.getParameter("s4")),Integer.parseInt(request.getParameter("s5")),Integer.parseInt(request.getParameter("s6")));
		notaCRUD.actualizar(nota);
		index(request, response);
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Nota nota = notaCRUD.obtenerPorId(request.getParameter("rollNo"));
		notaCRUD.eliminar(nota);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addNota.jsp");
		dispatcher.forward(request, response);
		
	}
}
