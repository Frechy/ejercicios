package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DBConnection {

	
private static final String JDBC_URL = "jdbc:mysql://localhost:3306/programadores";
	
	private static Connection instance = null;
	
	private DBConnection() { }
	
	/**
	 * Medoto que permite la llamada estatica por los metodos del resto de clases, utilizando el patron Singleton
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "1234");
			instance = DriverManager.getConnection(JDBC_URL, props);
		}
		
		return instance;
	}

	
}
