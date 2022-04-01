package controller;

import java.sql.SQLException;

import vista.Altas;

public class inicio {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		  System.out.println("Probando ejecucion");
	        
		  Altas window = new Altas();
		  window.getFrame().setVisible(true);
	}

}
