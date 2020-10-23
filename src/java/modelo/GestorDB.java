/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mnava
 */
public class GestorDB {

	private Connection con;
	private final String CON_STR = "jdbc:sqlserver://LAPTOP-0CRE86U4\\SQLEXPRESS:1433;databaseName=Gestoria";
	private final String USER = "sa";
	private final String PASS = "123456";

	private void abrirConexion() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			con = DriverManager.getConnection(CON_STR, USER, PASS);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void cerrarConexion() {
		try {

			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<Servicio> obtenerServicios() {
		ArrayList<Servicio> lista = new ArrayList<Servicio>();
		try {
			abrirConexion();
			String sql = "select * from Servicios";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				int tipoId = rs.getInt("tipo");
				String descripcion = rs.getString("descripcion");
				double costo = rs.getFloat("costo");

				//con el id de tipo de servicio
				//buscar el servicio correspondiente de la BD
				
				TipoServicio tipo = obtenerTipoServicio(tipoId); //buscar en la base de datos un tipo servicio con un ID como parametro

				lista.add(new Servicio(id, tipo, descripcion, costo));
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return lista;
	}

	public boolean insertarServicio(Servicio servicio) {
		boolean inserto = false;
		try {
			abrirConexion();
			String sql = "INSERT INTO Servicios (tipo, descripcion, costo) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, servicio.getTipo().getId());
			st.setString(2, servicio.getDescripcion());
			st.setDouble(3, servicio.getCosto());
			st.execute();
			inserto = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return inserto;
	}

	public TipoServicio obtenerTipoServicio(int tipoId) {
		TipoServicio resultado = null;

		try {
			abrirConexion();
			String sql = "SELECT * FROM TiposServicio WHERE id = ?;";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, tipoId); 
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String descripcion = rs.getString("descripcion");
				resultado = new TipoServicio(tipoId, descripcion);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return resultado;
	}

	public ArrayList<TipoServicio> obtenerTiposServicio() {
		ArrayList<TipoServicio> lista = new ArrayList<TipoServicio>();
		try {
			abrirConexion();
			String sql = "select * from TiposServicio";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String descripcion = rs.getString("descripcion");

				//con el id de tipo de servicio
				//buscar el servicio correspondiente de la BD
				
				lista.add(new TipoServicio(id, descripcion));
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return lista;
	}

	public boolean existeUsuario(String username, String password) {
		// comparar el username y password con la base de datos
		// Advertencia:Ojo que las contraseñas deberían estar encriptadas en la BD BCrypt
		if (username.equals("martin") && password.equals("123")) {
			return true;
		}
		return false;
	}

	public void eliminarServicio(int id) {
		//Abrir conexion
		//hacer la consulta con delete where id = id
		//cerramos conexion
		try {
			abrirConexion();
			String sql = "DELETE FROM Servicios WHERE id = ?;";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id); 
			st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
	}

	public Servicio obtenerServicioPorId(int id) {
		Servicio s = null;
		try {
			abrirConexion();
			String sql = "select * from Servicios WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id); 

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int tipoId = rs.getInt("tipo");
				String descripcion = rs.getString("descripcion");
				double costo = rs.getFloat("costo");

				TipoServicio tipoDeServicio = obtenerTipoServicio(tipoId);

				s = new Servicio(id, tipoDeServicio, descripcion, costo);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return s;
	}

	public boolean modificarServicio(Servicio servicio) {
		boolean inserto = false;
		try {
			abrirConexion();
			String sql = "UPDATE Servicios SET tipo=?, descripcion=?, costo=? WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, servicio.getTipo().getId());
			st.setString(2, servicio.getDescripcion());
			st.setDouble(3, servicio.getCosto());
			st.setInt(4, servicio.getId());
			st.executeUpdate();
			inserto = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return inserto;
	}
}
