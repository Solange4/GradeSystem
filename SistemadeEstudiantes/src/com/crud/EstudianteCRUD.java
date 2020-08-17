package com.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.conexion.Estudiante;
import com.conexion.Conexion;

public class EstudianteCRUD {
	private Conexion con;
	private Connection connection;
	
	public EstudianteCRUD(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	// insertar artículo
	public boolean insertar(Estudiante estudiante) throws SQLException {
		String sql = "INSERT INTO student (course, branch, rollNo, name, fatherName, gender) VALUES (?, ?, ?,?,?,?)";
		System.out.println(estudiante.getRollNo());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, estudiante.getCourse());
		statement.setString(2, estudiante.getBranch());
		statement.setString(3, estudiante.getRollNo());
		statement.setString(4, estudiante.getName());
		statement.setString(5, estudiante.getFatherName());
		statement.setString(6, estudiante.getGender());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Estudiante> listarEstudiantes() throws SQLException {

		List<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
		String sql = "SELECT * FROM student";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			String course = resulSet.getString("course");
			String branch = resulSet.getString("branch");
			String rollNo = resulSet.getString("rollNo");
			String name = resulSet.getString("name");
			String fatherName = resulSet.getString("fatherName");
			String gender = resulSet.getString("gender");
			Estudiante estudiante = new Estudiante(course, branch, rollNo,name,fatherName,gender);
			listaEstudiantes.add(estudiante);
		}
		con.desconectar();
		return listaEstudiantes;
	}
	
	// obtener por id
		public Estudiante obtenerPorId(String rollNo) throws SQLException {
			Estudiante estudiante = null;

			String sql = "SELECT * FROM student WHERE rollNo= ? ";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, rollNo);

			ResultSet res = statement.executeQuery();
			if (res.next()) {
				estudiante = new Estudiante(res.getString("course"), res.getString("branch"), res.getString("rollNo"),
						res.getString("name"), res.getString("fatherName"), res.getString("gender"));
			}
			res.close();
			con.desconectar();

			return estudiante;
		}

		// actualizar
		public boolean actualizar(Estudiante estudiante) throws SQLException {
			boolean rowActualizar = false;
			String sql = "UPDATE student SET course=?,branch=?,name=?,fatherName=?, gender=? WHERE rollNo=?";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, estudiante.getCourse());
			statement.setString(2, estudiante.getBranch());
			statement.setString(3, estudiante.getName());
			statement.setString(4, estudiante.getFatherName());
			System.out.println(estudiante.getGender());
			statement.setString(5, estudiante.getGender());
			statement.setString(6, estudiante.getRollNo());

			rowActualizar = statement.executeUpdate() > 0;
			statement.close();
			con.desconectar();
			return rowActualizar;
		}
		
		//eliminar
		public boolean eliminar(Estudiante estudiante) throws SQLException {
			boolean rowEliminar = false;
			String sql = "DELETE FROM student WHERE rollNo=?";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, estudiante.getRollNo());

			rowEliminar = statement.executeUpdate() > 0;
			statement.close();
			con.desconectar();

			return rowEliminar;
		}
	}
