package becapp.menus.usuarios;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import becapp.Beca;
import becapp.Conexion_BBDD;
import becapp.menus.metodos.ButtonColumn;
import becapp.menus.metodos.ImagenFondo;
import becapp.menus.metodos.MetodosMenus;
import infoBecas.Skills;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

public class MenuUsuario extends JFrame {
	
	private JTable table;
	private JScrollPane scroll;

	public MenuUsuario() {

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MetodosMenus mm = new MetodosMenus();
				mm.confirmarSalida();

			}
		});

		setTitle("BECAPP");
		setBounds(200, 100, 725, 534);
		setFont(new Font("Roboto", Font.PLAIN, 14));
	    
		ImagenFondo fondo = new ImagenFondo("/imagenes/FondoCalcula.jpg");
		setContentPane(fondo);
		SpringLayout sl_fondo = new SpringLayout();
		fondo.setLayout(sl_fondo);

		JButton sesion = new JButton("Cerrar sesion");
		sl_fondo.putConstraint(SpringLayout.NORTH, sesion, 39, SpringLayout.NORTH, fondo);
		sl_fondo.putConstraint(SpringLayout.WEST, sesion, 535, SpringLayout.WEST, fondo);
		sl_fondo.putConstraint(SpringLayout.SOUTH, sesion, 56, SpringLayout.NORTH, fondo);
		sl_fondo.putConstraint(SpringLayout.EAST, sesion, -73, SpringLayout.EAST, fondo);
		fondo.add(sesion);
		sesion.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		sesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login cerrar = new Login();
				cerrar.setVisible(true);
			}
		});
		

		JLabel listaBecas = new JLabel("Nuestras becas");
		sl_fondo.putConstraint(SpringLayout.NORTH, listaBecas, 69, SpringLayout.NORTH, fondo);
		sl_fondo.putConstraint(SpringLayout.WEST, listaBecas, 210, SpringLayout.WEST, fondo);
		sl_fondo.putConstraint(SpringLayout.SOUTH, listaBecas, -363, SpringLayout.SOUTH, fondo);
		sl_fondo.putConstraint(SpringLayout.EAST, listaBecas, -195, SpringLayout.EAST, fondo);
		
		fondo.add(listaBecas);
		listaBecas.setFont(new Font("Roboto", Font.PLAIN, 40));
		
		JTextPane txtpnCalculaLaCuanta = new JTextPane();
		sl_fondo.putConstraint(SpringLayout.WEST, txtpnCalculaLaCuanta, 106, SpringLayout.WEST, fondo);
		sl_fondo.putConstraint(SpringLayout.SOUTH, txtpnCalculaLaCuanta, -98, SpringLayout.SOUTH, fondo);
		sl_fondo.putConstraint(SpringLayout.EAST, txtpnCalculaLaCuanta, -272, SpringLayout.EAST, fondo);
		txtpnCalculaLaCuanta.setBackground(new Color(255, 255, 255));
		txtpnCalculaLaCuanta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnCalculaLaCuanta.setText("Calcula la cuant\u00EDa de tu beca. Introduce tus datos (ingresos y numero de familiares) y obten una aproximaci\u00F3n de la cuant\u00EDa fija que puedes percibir.");
		fondo.add(txtpnCalculaLaCuanta);
		txtpnCalculaLaCuanta.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JButton Calcula = new JButton("Calcula");
		sl_fondo.putConstraint(SpringLayout.WEST, Calcula, 36, SpringLayout.EAST, txtpnCalculaLaCuanta);
		sl_fondo.putConstraint(SpringLayout.SOUTH, Calcula, -114, SpringLayout.SOUTH, fondo);
		sl_fondo.putConstraint(SpringLayout.EAST, Calcula, -147, SpringLayout.EAST, fondo);
		fondo.add(Calcula);
		Calcula.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		Calcula.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCalcula pg = new VentanaCalcula();

				pg.setVisible(true);
				
			}
			
		});
		
		scroll = new JScrollPane();
		sl_fondo.putConstraint(SpringLayout.NORTH, Calcula, 38, SpringLayout.SOUTH, scroll);
		sl_fondo.putConstraint(SpringLayout.NORTH, txtpnCalculaLaCuanta, 31, SpringLayout.SOUTH, scroll);
		sl_fondo.putConstraint(SpringLayout.NORTH, scroll, 6, SpringLayout.SOUTH, listaBecas);
		sl_fondo.putConstraint(SpringLayout.WEST, scroll, 70, SpringLayout.WEST, fondo);
		sl_fondo.putConstraint(SpringLayout.SOUTH, scroll, -192, SpringLayout.SOUTH, fondo);
		sl_fondo.putConstraint(SpringLayout.EAST, scroll, -63, SpringLayout.EAST, fondo);
		fondo.add(scroll);
		
		construirTabla();
		
		
	}
		
	/**
	 * @author amart y edu
	 * M�todo que crea y da formato a la tabla que se muestra en el men� de navegaci�n de usuario. 
	 * Tambi�n a�ade un bot�n con funcionalidad de ver m�s informaci�n de la beca seleccionada,
	 */
	
	public void construirTabla() {
		String[] columnas = { "Nombre", "Descripcion", "M�s" };
		Object informacion[][]=obetenerMatriz();
		
		System.out.println(informacion.length);
		
		DefaultTableModel model = new DefaultTableModel(informacion, columnas) {
			boolean[] columnEditables = new boolean[] {
					false, false, true
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		table=new JTable(model);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		//table.setEnabled(false);
		//table.setModel(new modelo());
		
		scroll.setViewportView(table);

		ButtonColumn buttonColumn = new ButtonColumn(table, new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        Skills s = new Skills(modelRow+1);
		        s.setVisible(true);
		        
		        
		    }
		}, columnas.length-1);
		buttonColumn.setText("Ver m�s");
	}
	
	/*
	 * 
	 */
	private Object[][] obetenerMatriz() {
		
		Conexion_BBDD c = new Conexion_BBDD();
		ArrayList<Beca>miLista=c.recuperarBecas();
		
		Object info [][] = new Object[miLista.size()][3];
		
		for (int i = 0; i < miLista.size(); i++) {
			info[i] = new Object[3];
			info[i][0]=miLista.get(i).getNombre();
			info[i][1]=miLista.get(i).getDescripcion();
			info[i][2]=null;
			
		}
		
		return info;
	}
	}
	
	
	
	

