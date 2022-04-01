package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;


import modelo.DaoEmpleado;
import modelo.Empleado;

import java.awt.GridLayout;
import java.awt.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JTextPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Altas  {

	private JFrame frame;
	private JTextField textField_nombre;
	private JTextField textField_id;
	private JTextField textField_edad;
	private JTextField textField_cargo;
	private JTable table;
	public Empleado empleado;
	

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Altas window = new Altas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Altas() throws SQLException {
		
		empleado = new Empleado();
		initialize();
	}
		

	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Metodo de inicalizacion de la interfaz grafica. 
	 * 
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 47, 634, 78);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 178, 614, 248);

		DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
	
		table.setSurrendersFocusOnKeystroke(true);
		table.addMouseListener(new MouseAdapter() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				try {
					llenarCampos();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//System.out.println("selccionado fuera");
				}
	
			}
		});
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		scrollPane.setViewportView(table);
		
		//this.pintarTabla();
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(20, 14, 28, 14);
		lblId.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panel.add(lblId);
		
		textField_id = new JTextField();
		textField_id.setEditable(false);
		textField_id.setBounds(53, 11, 38, 20);
		panel.add(textField_id);
		textField_id.setColumns(4);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(129, 14, 40, 14);
		lblNombre.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panel.add(lblNombre);
		
		textField_nombre = new JTextField();
		textField_nombre.setEditable(false);
		textField_nombre.setBounds(179, 11, 207, 20);
		panel.add(textField_nombre);
		textField_nombre.setColumns(20);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(20, 42, 28, 14);
		lblEdad.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panel.add(lblEdad);
		
		textField_edad = new JTextField();
		textField_edad.setEditable(false);
		textField_edad.setBounds(53, 39, 38, 20);
		panel.add(textField_edad);
		textField_edad.setColumns(4);
		
		JLabel lblPais = new JLabel("Cargo:");
		lblPais.setBounds(139, 42, 31, 14);
		lblPais.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		panel.add(lblPais);
		
		textField_cargo = new JTextField();
		textField_cargo.setEditable(false);
		textField_cargo.setBounds(179, 39, 126, 20);
		panel.add(textField_cargo);
		textField_cargo.setColumns(15);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(406, 11, 107, 23);
		panel.add(btnNuevo);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(517, 11, 107, 23);
		panel.add(btnBorrar);
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			borrado();
			}
		});
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrar.setEnabled(true);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(517, 45, 107, 23);
		panel.add(btnModificar);
		
				// Boton guardar cliente
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.setBounds(406, 45, 107, 23);
				panel.add(btnGuardar);
				btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						
						guardado();
					
					}
				});
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarCampos();
				
				
			}
		});
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				habilitarCampos();
				nuevoCampos();
				textField_id.setText("0");
			}
		});
		frame.getContentPane().add(scrollPane);
				
				JLabel lblNewLabel = new JLabel("Mostrar:");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabel.setBounds(10, 136, 56, 23);
				frame.getContentPane().add(lblNewLabel);
				
				JComboBox comboBox = new JComboBox();
				comboBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {

						
					}
				});
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (comboBox.getSelectedIndex()==0) {
							System.out.println("hola a todos");
							empleado.setMostrar(comboBox.getSelectedIndex());
							
						}
						if (comboBox.getSelectedIndex()==1) {
							System.out.println("hola a 1");
							empleado.setMostrar(1);
						}
						if (comboBox.getSelectedIndex()==2) {
							System.out.println("hola a 2");
							empleado.setMostrar(2);
						}
						if (comboBox.getSelectedIndex()==3) {
							System.out.println("hola a 3");
							empleado.setMostrar(3);
						}
						try {
							pintarTabla();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					}
				});
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Programador Junior", "Programador Senior", "Analista"}));
				comboBox.setBounds(73, 137, 153, 22);
				frame.getContentPane().add(comboBox);
				
				JLabel lblNewLabel_1 = new JLabel("Gestion de Programadores");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNewLabel_1.setBounds(207, 11, 236, 23);
				frame.getContentPane().add(lblNewLabel_1);
				
				JTextPane textPane = new JTextPane();
				textPane.setEditable(false);
				textPane.setBounds(152, 437, 310, 55);
				frame.getContentPane().add(textPane);
				
				JButton btnNewButton = new JButton("Detalles:");
				btnNewButton.setBounds(38, 452, 104, 23);
				frame.getContentPane().add(btnNewButton);
	}
	
	/**
	 * Metodo que pinta la tabla con la lista de clientes almacenados en la BD.
	 * @throws SQLException
	 */
	private void pintarTabla() throws SQLException {
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "Edad", "Cargo"
			}
		));
		ArrayList<Empleado> lista = new ArrayList<Empleado>();

		lista = (ArrayList<Empleado>) DaoEmpleado.getInstance().obtenerLista(); 		

		
		for(Empleado c : lista) {
			
			Object[] fila = new Object[4];
			
			fila[0] = c.getId();
			fila[1] = c.getNombre();
			fila[2] = c.getEdad();
			fila[3] = c.getCargo();
			
			((DefaultTableModel) table.getModel()).addRow(fila); 

			
		}

	}
	
	private void pintarTabla1() throws SQLException {
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "Edad", "Cargo"
			}
		));
		ArrayList<Empleado> lista = new ArrayList<Empleado>();

		lista = (ArrayList<Empleado>) DaoEmpleado.getInstance().obtenerLista(); 		

		
		for(Empleado c : lista) {
			
			Object[] fila = new Object[4];
			
			fila[0] = c.getId();
			fila[1] = c.getNombre();
			fila[2] = c.getEdad();
			fila[3] = c.getCargo();
			
			((DefaultTableModel) table.getModel()).addRow(fila); 

			
		}

	}
	private void pintarTabla2() throws SQLException {
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "Edad", "Cargo"
			}
		));
		ArrayList<Empleado> lista = new ArrayList<Empleado>();

		lista = (ArrayList<Empleado>) DaoEmpleado.getInstance().obtenerLista(); 		

		
		for(Empleado c : lista) {
			
			Object[] fila = new Object[4];
			
			fila[0] = c.getId();
			fila[1] = c.getNombre();
			fila[2] = c.getEdad();
			fila[3] = c.getCargo();
			
			((DefaultTableModel) table.getModel()).addRow(fila); 

			
		}

	}
	private void pintarTabla3() throws SQLException {
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "Edad", "Cargo"
			}
		));
		ArrayList<Empleado> lista = new ArrayList<Empleado>();

		lista = (ArrayList<Empleado>) DaoEmpleado.getInstance().obtenerLista(); 		

		
		for(Empleado c : lista) {
			
			Object[] fila = new Object[4];
			
			fila[0] = c.getId();
			fila[1] = c.getNombre();
			fila[2] = c.getEdad();
			fila[3] = c.getCargo();
			
			((DefaultTableModel) table.getModel()).addRow(fila); 

			
		}

	}
	/**
	 * Metodo para limpiar los campos del formulario una vez termina la operación de insertar o actualizar
	 */
	private void deshabilitarCampos() {
		
		textField_nombre.setEditable(false);
		textField_edad.setEditable(false);
		textField_cargo.setEditable(false);
		
	}
	
	private void habilitarCampos() {
		
		textField_nombre.setEditable(true);
		textField_edad.setEditable(true);
		textField_cargo.setEditable(true);
		
	}
	private void nuevoCampos() {
		
		textField_nombre.setText(null);
		textField_edad.setText(null);
		textField_cargo.setText(null);
		
	}
	
	private void guardado() {
		System.out.println("Boton Pulsado");
		System.out.println(textField_id.getText());
	
		if(textField_edad.getText().length() == 0 || textField_nombre.getText().length() == 0) {
			
			JOptionPane.showMessageDialog(null, "No se puede insertar sin Id y Nombre");
			//System.out.println(comboTipovia.getSelectedIndex());

			
		}else{

			empleado.setId(Integer.parseInt(textField_id.getText()));
			empleado.setNombre(textField_nombre.getText());
			empleado.setEdad(Integer.parseInt(textField_edad.getText()));
			empleado.setCargo(textField_cargo.getText());
			//empleado.setTipoVia(comboTipovia.getSelectedIndex());
		
		try {
		
			if(empleado.getId() > 0 ) {
			
				empleado.update();						
			}else {
				empleado.insertar();
			}
			
			pintarTabla();
			nuevoCampos();
			deshabilitarCampos();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		}
	}
	
	/**
	 * Metodo que realizar la acción de borrado del botón de la interfaz
	 */
	public void borrado() {
		DefaultTableModel tm = (DefaultTableModel) table.getModel();
		String dato=String.valueOf(tm.getValueAt(table.getSelectedRow(),0));
		
		
		if(empleado.getId() > 0 ) {
		try {
			
			empleado.delete(Integer.parseInt(dato));
			pintarTabla();
			nuevoCampos();
			deshabilitarCampos();
			
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	}
	
	/**
	 * Metodo encargado de llenar los campos del formulario según la petición de un empleado en la tabla de la interfaz.
	 */
	
	public void llenarCampos() {
		deshabilitarCampos();
		DefaultTableModel tm = (DefaultTableModel) table.getModel();
		String dato=String.valueOf(tm.getValueAt(table.getSelectedRow(),0));
		//JOptionPane.showMessageDialog(null, dato);

		try {
			empleado = DaoEmpleado.getInstance().obtenerPorId(Integer.parseInt(dato));
			
			textField_id.setText(String.valueOf(empleado.getId()));
			textField_nombre.setText(empleado.getNombre());
			textField_edad.setText(String.valueOf(empleado.getEdad()));
			textField_cargo.setText(empleado.getCargo());
			//comboTipovia.setSelectedIndex(empleado.getTipoVia());

			
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
