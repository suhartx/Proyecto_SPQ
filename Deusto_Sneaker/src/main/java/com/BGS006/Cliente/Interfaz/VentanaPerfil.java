package com.BGS006.Cliente.Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.html.ImageView;

import com.BGS006.Cliente.BBDD.BD;
import com.BGS006.Cliente.jdo.Usuario;

import javax.swing.JList;
import java.awt.Dimension;

public class VentanaPerfil extends JFrame {

	private JPanel contentPane;
	public static Connection con;
	public static String nombreBD = "baseDeDatos.db";
	private JFrame ventanaActual, ventanaAnterior;
	private JScrollPane scrollListaVentas;
	String avatar;

	/**
	 * Create the frame.
	 * 
	 * @param ventanaActual2
	 * @throws DeustoException
	 */

	public VentanaPerfil(JFrame va, final Usuario u) throws BindException {

		// cargarTMventasUsuarioAJlist();
		System.out.println("Este es el logo " + u.getRutaAvatar());
		System.out.println(u.getContrasenya());
		ventanaAnterior = va;
		ventanaActual = this;
		setVisible(true);
		ventanaActual = this;
		setTitle("Profile: " + u.getNombre());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1650, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		contentPane.setBackground(new Color(240, 230, 140));

		JPanel panelSur = new JPanel();
		panelSur.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setBackground(new Color(255, 102, 51));
		panelSur.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnWearHome = new JButton("Home");
		btnWearHome.setFont(new Font("Lato", Font.PLAIN, 19));
		btnWearHome.setBackground(new Color(255, 165, 0));
		panelSur.add(btnWearHome);

		/*
		 * JButton btnFavoritos = new JButton("Favorites"); btnFavoritos.setFont(new
		 * Font("Lato", Font.PLAIN, 19)); btnFavoritos.setBackground(new Color(204, 102,
		 * 51)); panelSur.add(btnFavoritos);
		 */

		JButton btnCesta = new JButton("Cesta");
		btnCesta.setFont(new Font("Lato", Font.PLAIN, 19));
		btnCesta.setBackground(new Color(255, 165, 0));
		panelSur.add(btnCesta);

		JButton btnPerfil = new JButton("Profile");
		btnPerfil.setFont(new Font("Lato", Font.PLAIN, 19));
		btnPerfil.setForeground(new Color(255, 255, 255));
		btnPerfil.setEnabled(false);
		btnPerfil.setBackground(new Color(255, 165, 0));
		panelSur.add(btnPerfil);

		JPanel panelNorte = new JPanel();
		panelNorte.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setBackground(new Color(245, 222, 179));

		JButton btnEditar = new JButton("Cambiar contraseya");
		btnEditar.setForeground(new Color(205, 133, 63));
		btnEditar.setFont(new Font("Lato", Font.PLAIN, 19));
		btnEditar.setBackground(new Color(210, 180, 140));
		panelNorte.add(btnEditar, "cell 0 0,grow");

		JPanel panelCentral = new JPanel();
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setBackground(new Color(255, 153, 51));
		panelCentral.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panelCentroIzquierda = new JPanel();
		panelCentroIzquierda.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCentroIzquierda.setForeground(new Color(255, 255, 255));
		panelCentroIzquierda.setBackground(new Color(255, 228, 196));
		panelCentral.add(panelCentroIzquierda);
		// panelCentroIzquierda.setLayout(new MigLayout("", "[378.00px,grow][1px]",
		// "[93.00px][72.00][grow]"));

		JLabel lblMyProfile = new JLabel("MY PROFILE");
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setForeground(new Color(233, 150, 122));
		lblMyProfile.setFont(new Font("Lato", Font.BOLD, 42));
		lblMyProfile.setBackground(new Color(255, 69, 0));
		panelCentroIzquierda.add(lblMyProfile, "cell 0 0,alignx center,aligny bottom");

		JLabel lblAvatar = new JLabel();
		lblAvatar.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroIzquierda.add(lblAvatar, "cell 0 2,alignx center,aligny center");

		ImageIcon im = new ImageIcon(avatar);
		ImageIcon imagenConDimensiones = new ImageIcon(im.getImage().getScaledInstance(300, 300, ImageView.CENTER));
		lblAvatar.setIcon(imagenConDimensiones);
		lblAvatar.setPreferredSize(new Dimension(498, 500));
		lblAvatar.setIcon(imagenConDimensiones);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(255, 228, 196));
		panelCentral.add(panel);

		JLabel lblEnunciado = new JLabel("\tPedidos realizados:");
		lblEnunciado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnunciado.setForeground(new Color(210, 180, 140));
		lblEnunciado.setFont(new Font("Dialog", Font.BOLD, 42));
		panel.add(lblEnunciado, "cell 0 0,alignx center,aligny bottom");
		

		/*EVENTOS*/
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contra = JOptionPane.showInputDialog("Introduzca la nueva contraseña:");
				String ERcontraseya = "[0-9]{1,15}";
				boolean correctoContra = Pattern.matches(ERcontraseya, contra);
				if(correctoContra && !contra.equals(u.getContrasenya())) {
					try {
						con = BD.initBD("baseDeDatos");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						BD.cambiarContrasenya(con, u.getNombre(), contra);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						BD.closeBD(con);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente", "CAMBIO REALIZADO", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Loading...Error", "!!ERROR!!", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
	}	
	
}

