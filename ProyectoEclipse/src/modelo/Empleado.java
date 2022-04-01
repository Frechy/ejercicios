package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
		private int id;
	    private String nombre;
	    private int edad;
	    private String cargo;
	    private int mostrar;

	    
	    /**
	     * Constructor Cliente Vacio
	     */
	    public Empleado() {
	    }

	    
	  

		
		public Empleado(int mostrar) {
			this.mostrar = mostrar;
		}





		public Empleado(String nombre, int edad, String cargo) {
			this.nombre = nombre;
			this.edad = edad;
			this.cargo = cargo;
		}





		public Empleado(int id, String nombre, int edad, String cargo) {
			this.id = id;
			this.nombre = nombre;
			this.edad = edad;
			this.cargo = cargo;
		}





		public int getId() {
			return id;
		}





		public void setId(int id) {
			this.id = id;
		}





		public String getNombre() {
			return nombre;
		}





		public void setNombre(String nombre) {
			this.nombre = nombre;
		}





		public int getEdad() {
			return edad;
		}





		public void setEdad(int edad) {
			this.edad = edad;
		}





		public String getCargo() {
			return cargo;
		}





		public void setCargo(String cargo) {
			this.cargo = cargo;
		}





		public int getMostrar() {
			
			return mostrar;
			
		}





		public void setMostrar(int mostrar) {
			this.mostrar = mostrar;
		}



		/**
		 * Metodo de inserción de cliente. Envia los datos del objeto al metodo de la clase DAO de insertar.
		 * @throws SQLException
		 */
		
		public void insertar() throws SQLException {
	    	
	    	
			DaoEmpleado.getInstance().insert(this);
	    	
	    }
	    

		/**
		 * Metodo de actualización de cliente. Envia los datos del objeto al metodo de la clase DAO de actualizar.
		 * @throws SQLException
		 */
	    public void update() throws SQLException {
	    	
	    	
	    	DaoEmpleado.getInstance().update(this);
	    	
	    }
	    

		/**
		 * Metodo de Borrado de cliente. Envia el id del objeto actual al metodo de la clase DAO de borrado.
		 * @throws SQLException
		 */
	    public void delete(int id) throws SQLException {
	    	
	    	
	    	DaoEmpleado.getInstance().delete(id);
	    	
	    }
	    
	    
	    /**
	     * Metodo para obtener la lista de clientes obtenidos de la base de datos mediante el metodo obtener de la clase DAO
	     * @return
	     * @throws SQLException
	     */
	    
	    public List<Empleado> obtenerLista() throws SQLException{
	    	
	    	
	    	List<Empleado> lista = DaoEmpleado.getInstance().obtenerLista();
	    	
	    	return lista;
	    }
	    

}
