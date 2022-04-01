package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DaoEmpleado {

	
	private Connection con = null;

	private static DaoEmpleado instance = null;

	private DaoEmpleado() throws SQLException {
		con = DBConnection.getConnection();
	}

	public static DaoEmpleado getInstance() throws SQLException {
		if (instance == null)
			instance = new DaoEmpleado();

		return instance;
	}
	
	
	/**
	 * 
	 * Metodo que inserta mediante el conector JDBC los datos de un cliente en la Base de datos
	 * 
	 * @param t
	 * @throws SQLException
	 */
	public void insert(Empleado t) throws SQLException {

		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO empleados (idEmpleado, nombre, edad, cargo) VALUES (?, ?, ?, ?)");
		ps.setInt(1, t.getId());
		ps.setString(2, t.getNombre());
		ps.setInt(3, t.getEdad());
		ps.setString(4,t.getCargo());
				
		ps.executeUpdate();
		ps.close();

	}
	
	
	
	/**
	 *  Metodo que acutaliza los datos de un cliente mediante el id almacenado del mismo.
	 * @param t
	 * @throws SQLException
	 */
	public void update(Empleado t) throws SQLException {

		if (t.getId() != 0) {
			
			PreparedStatement ps = con.prepareStatement(
					"UPDATE empleados SET nombre = ?, edad = ?, cargo = ? WHERE idEmpleado = ?");
			//Los interrogantes tiene que estar en el mismo orden que proporcionamos abajo los getters		
			ps.setString(1, t.getNombre());
			ps.setInt(2, t.getEdad());
			ps.setString(3,t.getCargo());
			ps.setInt(4, t.getId());
			
			ps.executeUpdate();	
			ps.close();
			
			}

	} 
	
	
	
	/**
	 * Metodo que retorna la lista de clientes almacenados en la base de datos. 
	 * @return
	 * @throws SQLException
	 */
	public List<Empleado> obtenerLista() throws SQLException {
		
		Empleado e1= new Empleado();
		String bscar="";
		System.out.println(e1.getMostrar());
		
		int combo= 0;
		
		switch (e1.getMostrar()) {
		  case 0:
			  bscar="";
		    break;
		  case 1:
			  bscar="Programador Junior";
		    break;
		  case 2:
			  bscar="Programador Senior";
		    break;
		  case 3:
			  bscar="Analista";
			    break;
		  default:
		    System.out.println("default");
		    break;
		}
		
		System.out.println(e1.getMostrar());
		System.out.println(bscar);
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM empleados WHERE cargo LIKE '%"+bscar+"%'");
		ResultSet rs = ps.executeQuery();

		List<Empleado> result = null;

		while (rs.next()) {
			if (result == null)
				result = new ArrayList<>();

			result.add(new Empleado(rs.getInt("idEmpleado"),  rs.getString("nombre"),rs.getInt("edad"), rs.getString("cargo")));
		}

		rs.close();
		ps.close();

		return result;
	}
	
	/*
	 * Metodo que obtiene los datos de un cliente por medio de la identificación del ID
	 */
	public Empleado obtenerPorId(int id) throws SQLException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM empleados WHERE idEmpleado = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		Empleado result = null;

		if (rs.next()) {
			result = new Empleado(rs.getInt("idEmpleado"),  rs.getString("nombre"),rs.getInt("edad"), rs.getString("cargo"));
		}
		rs.close();
		ps.close();

		return result;	

	
	
	}
	
	/**
	 * Metodo para borrar un cliente de la base de datos proporciandole el id del mismo.
	 * @param id
	 * @throws SQLException
	 */
public void delete(int id) throws SQLException {
		
	if (id <= 0)
		return;
	
	PreparedStatement ps = con.prepareStatement("DELETE FROM empleados WHERE idEmpleado = ?");
	ps.setInt(1, id);

	ps.executeUpdate();

	ps.close();
	}
	
	
	
}
