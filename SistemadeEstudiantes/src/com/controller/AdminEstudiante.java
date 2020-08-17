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

import com.conexion.Estudiante;
import com.crud.EstudianteCRUD;


@WebServlet("/adminEstudiante")
public class AdminEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EstudianteCRUD estudianteCRUD;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			estudianteCRUD = new EstudianteCRUD(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminEstudiante() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
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
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{

		RequestDispatcher dispatcher= request.getRequestDispatcher("addNewStudent.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Estudiante estudiante = new Estudiante(request.getParameter("course"), request.getParameter("branch"), request.getParameter("rollNo"), request.getParameter("name"),request.getParameter("fatherName"),request.getParameter("gender"));
		estudianteCRUD.insertar(estudiante);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("addNewStudent.jsp");
		dispatcher.forward(request, response);
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("addNewStudent.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrarStudent.jsp");
		List<Estudiante> listaEstudiantes= estudianteCRUD.listarEstudiantes();
		request.setAttribute("lista", listaEstudiantes);
		dispatcher.forward(request, response);
	}		
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Estudiante estudiante = estudianteCRUD.obtenerPorId(request.getParameter("rollNo"));
		request.setAttribute("estudiante", estudiante);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editarStudent.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Estudiante estudiante = new Estudiante(request.getParameter("course"), request.getParameter("branch"), request.getParameter("rollNo"), request.getParameter("name"),request.getParameter("fatherName"),request.getParameter("gender") );
		estudianteCRUD.actualizar(estudiante);
		index(request, response);
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Estudiante estudiante = estudianteCRUD.obtenerPorId(request.getParameter("rollNo"));
		estudianteCRUD.eliminar(estudiante);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addNewStudent.jsp");
		dispatcher.forward(request, response);
		
	}
	
}