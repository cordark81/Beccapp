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
		setBounds(200, 100, 725, 613);
	    
		ImagenFondo fondo = new ImagenFondo("/imagenes/FondoNeutro.png");
		setContentPane(fondo);
		fondo.setLayout(null);

		JButton sesion = new JButton("Cerrar sesion");
	
		sesion.setBounds(533, 25, 101, 17);
		fondo.add(sesion);
		sesion.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		
		sesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login cerrar = new Login();
				cerrar.setVisible(true);
			}
		});
		
		JLabel Becapp = new JLabel("BECAPP");
		Becapp.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		Becapp.setBounds(51, 11, 75, 40);
		fondo.add(Becapp);
		
		JPanel Inicio = new JPanel();
		Inicio.setBackground(new Color(175, 238, 238));
		Inicio.setBounds(0, 0, 724, 69);
		fondo.add(Inicio);

		JLabel listaBecas = new JLabel("Nuestras becas");
		listaBecas.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		listaBecas.setBounds(290, 92, 128, 26);
		fondo.add(listaBecas);
		
		JTextPane txtpnCalculaLaCuanta = new JTextPane();
		txtpnCalculaLaCuanta.setBackground(new Color(255, 255, 255));
		txtpnCalculaLaCuanta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnCalculaLaCuanta.setText("Calcula la cuant\u00EDa de tu beca. Introduce tus datos (ingresos y numero de familiares) y obten una aproximaci\u00F3n de la cuant\u00EDa fija que puedes percibir.");
		txtpnCalculaLaCuanta.setBounds(83, 421, 549, 46);
		fondo.add(txtpnCalculaLaCuanta);
		
		JButton Calcula = new JButton("Calcula");
		Calcula.setBounds(290, 489, 89, 40);
		fondo.add(Calcula);
		
		Calcula.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCalcula pg = new VentanaCalcula();

				pg.setVisible(true);
				dispose();
			}
			
		});
		
		scroll = new JScrollPane();
		scroll.setBounds(69, 138, 576, 237);
		fondo.add(scroll);
		
		construirTabla();
		
		
	}
		
	/**
	 * @author amart y edu
	 * Método que crea y da formato a la tabla que se muestra en el menú de navegación de usuario. 
	 * También añade un botón con funcionalidad de ver más información de la beca seleccionada,
	 */
	
	public void construirTabla() {
		String[] columnas = { "Nombre", "Descripcion", "Más" };
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
		buttonColumn.setText("Ver más");
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
	
	
	
	

