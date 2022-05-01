package com.BGS006.cliente.interfaz;


import java.awt.*;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import javax.swing.text.html.ImageView;

import com.BGS006.cliente.bbdd.BD;
import com.BGS006.cliente.jdo.Articulo;
import com.BGS006.cliente.jdo.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.BindException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.border.BevelBorder;




public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelCentro;
	private JPanel panelWest;
	private JComboBox<String> comboTalla;
	private JComboBox<String> comboPrenda;
	private JFrame ventanaActual,ventanaAnterior;
	private ButtonGroup bg;
	private JScrollPane scrollCentral;
	//private JList<Articulo> listaArticulos;
	//private DefaultListModel<Articulo> modeloListaArticulos;
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(JFrame va, final Usuario u) throws BindException {
		ventanaAnterior = va;
		ventanaActual = this;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 1564, 693);
		setTitle("Home");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		contentPane.setBackground(new Color(255, 165, 0));

		JPanel panelWest = new JPanel();
		panelWest.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelWest.setBackground(new Color(255, 228, 181));
		contentPane.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new FlowLayout());

		/*ComboBox Articulos*/
		comboPrenda = new JComboBox<String>();
		comboPrenda.setToolTipText("");
		panelWest.add(comboPrenda, "cell 1 5,growx,aligny center");

		ArrayList<String> tiposArticulos = new ArrayList<>();
		tiposArticulos.add("Articulos");
		tiposArticulos.add("Zapatillas");
		tiposArticulos.add("Calcetines");
		tiposArticulos.add("Limpiador");

		for(String articulo : tiposArticulos) {
			comboPrenda.addItem(articulo);
		}


		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(255, 165, 0));
		btnBuscar.setBackground(new Color(255, 222, 173));
		btnBuscar.setFont(new Font("Lato", Font.PLAIN, 15));
		panelWest.add(btnBuscar, "cell 0 18 2 1,alignx center,aligny center");


		JPanel panelNorte = new JPanel();
		panelNorte.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelNorte.setBackground(new Color(255, 228, 181));
		contentPane.add(panelNorte, BorderLayout.NORTH);

		
		ImageIcon im = new ImageIcon("imagenes/logo.jpg");
		ImageIcon imagenConDimensiones = new ImageIcon(im.getImage().getScaledInstance(70,70,ImageView.CENTER));
		
		JLabel lblTitulo = new JLabel("DeustoSneaker Shop" );
		lblTitulo.setBackground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Lato", Font.BOLD, 30));
		lblTitulo.setForeground(new Color(255, 165, 0));
		panelNorte.add(lblTitulo, "cell 1 0,alignx center,aligny center");

		
		
	
		JPanel panelSur = new JPanel();
		panelSur.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelSur.setBackground(new Color(255, 102, 51));
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(0, 3, 0, 0));

	
		
		JButton btnWearHome = new JButton("Home");
		btnWearHome.setFont(new Font("Lato", Font.PLAIN, 19));
		btnWearHome.setForeground(new Color(255, 165, 0));
		btnWearHome.setEnabled(false);
		btnWearHome.setBackground(new Color(255, 222, 173));
		panelSur.add(btnWearHome);
		

		
		JButton btnCesta = new JButton("Cesta");
		btnCesta.setForeground(new Color(255, 165, 0));
		btnCesta.setFont(new Font("Lato", Font.PLAIN, 19));
		btnCesta.setBackground(new Color(255, 222, 173));
		panelSur.add(btnCesta);
		
		
		JButton btnPerfil = new JButton("Profile");
		btnPerfil.setForeground(new Color(255, 165, 0));
		btnPerfil.setFont(new Font("Lato", Font.PLAIN, 19));
		btnPerfil.setBackground(new Color(255, 222, 173));
		panelSur.add(btnPerfil);
		
		
		panelCentro = new JPanel();
		panelCentro.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCentro.setBackground(new Color(255, 228, 196));
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 3, 0, 0));	
		
		/*modeloListaArticulos = new DefaultListModel<Articulo>();
		listaArticulos = new JList<Articulo>(modeloListaArticulos);
		panelCentro.add(listaArticulos);
		
		anyadirArticulosALista();*/

		this.cargarPaneles();

		scrollCentral = new JScrollPane();
		scrollCentral.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollCentral.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollCentral);
		scrollCentral.setViewportView(panelCentro);


		btnPerfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaActual.dispose();
				try {
					new VentanaPerfil(ventanaActual,u);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//new VentanaPerfil(ventanaActual);
			}
		});
		
		btnCesta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ventanaActual.dispose();
				//new VentanaCesta(ventanaActual,u);
				//new VentanaPerfil(ventanaActual);
			}
		});

		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboPrenda.getSelectedIndex() ==0){
					panelCentro.removeAll();
					try {
						cargarPaneles();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(comboPrenda.getSelectedIndex()==1) {
					panelCentro.removeAll();
					try {
						cargarPanelesConZapatillas();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(comboPrenda.getSelectedIndex()==2){
					panelCentro.removeAll();
					try {
						cargarPanelesConCalcetines();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(comboPrenda.getSelectedIndex()==3) {
					panelCentro.removeAll();
					try {
						cargarPanelesConLimpiadores();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}

	/**
	 * Metodo que permite cargar los paneles de los distinos articulos en el panelCentro
	 */
	public void cargarPaneles() {
		Connection con = BD.initBD("baseDeDatos.db");
		TreeMap<Integer , Articulo> tm = BD.cargarMapaArticulosDeInfoBBDD(con);
		for(Articulo a: tm.values()) {
			panelArticuloHome pi = new panelArticuloHome(a);
			panelCentro.add(pi);
			panelCentro.updateUI();
		}
		BD.closeBD(con);
	}

	/*
	 * Metodos para el sistema de busqueda de articulos
	 */
	public void cargarPanelesConZapatillas()  {
		Connection con = BD.initBD("baseDeDatos.db");
		TreeMap<Integer , Articulo> tm = BD.cargarZapatillasDeInfoDeBBDD(con);
		for(Articulo a: tm.values()) {
			panelArticuloHome pi = new panelArticuloHome(a);
			panelCentro.add(pi);
			panelCentro.updateUI();
		}
		BD.closeBD(con);
	}
	/*
	 * Metodos para el sistema de busqueda de articulos
	 */
	public void cargarPanelesConCalcetines() {
		Connection con = BD.initBD("baseDeDatos.db");
		TreeMap<Integer , Articulo> tm = BD.cargarCalcetinesDeInfoDeBBDD(con);
		for(Articulo a: tm.values()) {
			panelArticuloHome pi = new panelArticuloHome(a);
			panelCentro.add(pi);
			panelCentro.updateUI();
		}
		BD.closeBD(con);
	}

	/*
	 * Metodos para el sistema de busqueda de articulos
	 */
	public void cargarPanelesConLimpiadores() {
		Connection con = BD.initBD("baseDeDatos.db");
		TreeMap<Integer , Articulo> tm = BD.cargarLimpiadoresDeInfoDeBBDD(con);
		for(Articulo a: tm.values()) {
			panelArticuloHome pi = new panelArticuloHome(a);
			panelCentro.add(pi);
			panelCentro.updateUI();
		}
		BD.closeBD(con);
	}


}


