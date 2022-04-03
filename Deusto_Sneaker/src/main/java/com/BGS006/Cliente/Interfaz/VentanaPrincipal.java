package com.BGS006.Cliente.Interfaz;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.html.ImageView;

import com.BGS006.*;
import com.BGS006.Cliente.jdo.Usuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.BindException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelCentro;
	private JComboBox<String> comboTalla;
	private JFrame ventanaActual,ventanaAnterior;
	private ButtonGroup bg;
	//private JScrollPane scrollCentral;
	
	/**
	 * Create the frame.
	 * @throws DeustoException 
	 */
	public VentanaPrincipal(JFrame va,final Usuario u) throws BindException {
		
		ventanaAnterior = va;
		ventanaActual = this;
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1376, 685);
		setTitle("Home");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		contentPane.setBackground(new Color(240, 230, 140));
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelNorte.setBackground(new Color(255, 218, 185));
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		
		ImageIcon im = new ImageIcon("imagenes/logo.jpg");
		ImageIcon imagenConDimensiones = new ImageIcon(im.getImage().getScaledInstance(70,70,ImageView.CENTER));
		
		JLabel lblTitulo = new JLabel("DeustoSneaker Shop "+ u.getNombre() );
		lblTitulo.setBackground(new Color(222, 184, 135));
		lblTitulo.setFont(new Font("Lato", Font.BOLD, 28));
		lblTitulo.setForeground(new Color(244, 164, 96));
		panelNorte.add(lblTitulo, "cell 1 0,alignx center,aligny center");
		
		ArrayList<String> tiposArticulos = new ArrayList<>();
		tiposArticulos.add("Articulos");
		tiposArticulos.add("Zapatillas");
		tiposArticulos.add("Calcetines");
		
		
		JPanel panelSur = new JPanel();
		panelSur.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelSur.setBackground(new Color(255, 102, 51));
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(0, 3, 0, 0));

	
		
		JButton btnWearHome = new JButton("Home");
		btnWearHome.setFont(new Font("Lato", Font.PLAIN, 19));
		btnWearHome.setForeground(new Color(255, 255, 255));
		btnWearHome.setEnabled(false);
		btnWearHome.setBackground(new Color(218, 165, 32));
		panelSur.add(btnWearHome);
		

		
		JButton btnCesta = new JButton("Cesta");
		btnCesta.setFont(new Font("Lato", Font.PLAIN, 19));
		btnCesta.setBackground(new Color(218, 165, 32));
		panelSur.add(btnCesta);
		
		
		JButton btnPerfil = new JButton("Profile");
		btnPerfil.setFont(new Font("Lato", Font.PLAIN, 19));
		btnPerfil.setBackground(new Color(218, 165, 32));
		panelSur.add(btnPerfil);
		
		
		panelCentro = new JPanel();
		panelCentro.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCentro.setBackground(new Color(255, 228, 196));
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 3, 0, 0));
	
		//this.cargarPaneles();
		
		
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
		
		/*scrollCentral = new JScrollPane();
		scrollCentral.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollCentral.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollCentral);
		scrollCentral.setViewportView(panelCentro);*/
		
	}
	
	/*public static void main(String[] args) throws BindException, HeadlessException {
		SwingUtilities.invokeLater((Runnable) new VentanaPrincipal(new JFrame(), new com.BGS006.Cliente.jdo.Usuario()));
		
	}*/
}

