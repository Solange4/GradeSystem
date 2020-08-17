package com.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.conexion.Nota;
import com.conexion.Conexion;

public class NotaCRUD {
	private Conexion con;
	private Connection connection;
	
	public NotaCRUD(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	// insertar artículo
	public boolean insertar(Nota nota) throws SQLException {
		String sql = "INSERT INTO result (rollNo, s1, s2, s3 , s4, s5 ,s6) VALUES (?,?,?, ?, ?,?,?)";
		System.out.println(nota.getRollNo());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, nota.getRollNo());
		statement.setInt(2, nota.getS1());
		statement.setInt(3, nota.getS2());
		statement.setInt(4, nota.getS3());
		statement.setInt(5, nota.getS4());
		statement.setInt(6, nota.getS5());
		statement.setInt(7, nota.getS6());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Nota> listarNotas() throws SQLException {

		List<Nota> listaNotas = new ArrayList<Nota>();
		String sql = "SELECT * FROM result";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			String rollNo = resulSet.getString("rollNo");
			int s1 = resulSet.getInt("s1");
			int s2 = resulSet.getInt("s2");
			int s3 = resulSet.getInt("s3");
			int s4 = resulSet.getInt("s4");
			int s5 = resulSet.getInt("s5");
			int s6 = resulSet.getInt("s6");
						
			Nota nota = new Nota(rollNo,s1, s2,s3,s4, s5,s6);
			listaNotas.add(nota);
		}
		con.desconectar();
		return listaNotas;
	}
	
	// obtener por id
		public Nota obtenerPorId(String rollNo) throws SQLException {
			Nota nota = null;

			String sql = "SELECT * FROM result WHERE rollNo= ? ";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, rollNo);

			ResultSet res = statement.executeQuery();
			if (res.next()) {
				nota = new Nota(res.getString("rollNo"), res.getInt("s1"), res.getInt("s2"),
						res.getInt("s3"), res.getInt("s4"), res.getInt("s5"), res.getInt("s6"));
			}
			res.close();
			con.desconectar();

			return nota;
		}

		// actualizar
		public boolean actualizar(Nota nota) throws SQLException {
			boolean rowActualizar = false;
			String sql = "UPDATE result SET s1=?,s2=?,s3=?,s4=?, s5=?,s6=? WHERE rollNo=?";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, nota.getS1());
			statement.setInt(2, nota.getS2());
			statement.setInt(3, nota.getS3());
			statement.setInt(4, nota.getS4());
			statement.setInt(5, nota.getS5());
			System.out.println(nota.getS6());
			statement.setInt(6, nota.getS6());
			statement.setString(7, nota.getRollNo());

			rowActualizar = statement.executeUpdate() > 0;
			statement.close();
			con.desconectar();
			return rowActualizar;
		}
		
		//eliminar
		public boolean eliminar(Nota nota) throws SQLException {
			boolean rowEliminar = false;
			String sql = "DELETE FROM result WHERE rollNo=?";
			con.conectar();
			connection = con.getJdbcConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nota.getRollNo());

			rowEliminar = statement.executeUpdate() > 0;
			statement.close();
			con.desconectar();

			return rowEliminar;
		}
	}

