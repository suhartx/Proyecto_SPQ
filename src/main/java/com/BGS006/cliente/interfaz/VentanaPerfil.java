package com.BGS006.cliente.interfaz;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.BindException;
import java.sql.Connection;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.ImageView;

import com.BGS006.cliente.bbdd.BD;
import com.BGS006.cliente.jdo.Usuario;

import java.awt.Dimension;

public class VentanaPerfil extends JFrame {

	private JPanel contentPane;
	public static Connection con;
	public static String nombreBD = "baseDeDatos";
	private JFrame ventanaActual, ventanaAnterior;
	private JScrollPane scrollListaVentas;

	/**
	 * Create the frame.
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
		setBounds(50, 50, 1064, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		contentPane.setBackground(new Color(255, 165, 0));

		JPanel panelSur = new JPanel();
		panelSur.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setBackground(new Color(255, 102, 51));
		panelSur.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnPrincipal = new JButton("Home");
		btnPrincipal.setForeground(new Color(255, 165, 0));
		btnPrincipal.setFont(new Font("Lato", Font.PLAIN, 19));
		btnPrincipal.setBackground(new Color(255, 222, 173));
		panelSur.add(btnPrincipal);
		
		JButton btnCesta = new JButton("Cesta");
		btnCesta.setForeground(new Color(255, 165, 0));
		btnCesta.setFont(new Font("Lato", Font.PLAIN, 19));
		btnCesta.setBackground(new Color(255, 222, 173));
		panelSur.add(btnCesta);
		
		JButton btnPerfil = new JButton("Profile");
		btnPerfil.setFont(new Font("Lato", Font.PLAIN, 19));
		btnPerfil.setForeground(new Color(255, 165, 0));
		btnPerfil.setEnabled(false);
		btnPerfil.setBackground(new Color(255, 222, 173));
		panelSur.add(btnPerfil);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setBackground(new Color(255, 222, 173));
		
		
		
		
		JButton btnEditar = new JButton("Cambiar contraseya");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contra = JOptionPane.showInputDialog("Introduzca la nueva contrase�a:");
				String ERcontraseya = "[0-9]{1,15}";
				boolean correctoContra = Pattern.matches(ERcontraseya, contra);
				if(correctoContra && !contra.equals(u.getContrasenya())) {
					try {
						con = BD.initBD(nombreBD);
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
					JOptionPane.showMessageDialog(null, "Contrase�a cambiada correctamente", "CAMBIO REALIZADO", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Loading...Error", "!!ERROR!!", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		
		
		btnPrincipal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaActual.dispose();
				try {
					new VentanaPrincipal(ventanaActual,u);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//new VentanaPerfil(ventanaActual);
			}
		});
		btnCesta.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ventanaActual.dispose();
				//new VentanaCesta(ventanaActual,u);
				//new VentanaPerfil(ventanaActual);
			}
		});
		
		
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Lato", Font.PLAIN, 19));
		btnEditar.setBackground(new Color(255, 153, 0));
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
		
		JLabel lblMyProfile = new JLabel("MY PROFILE");
		lblMyProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyProfile.setForeground(new Color(255, 165, 0));
		lblMyProfile.setFont(new Font("Lato", Font.BOLD, 42));
		lblMyProfile.setBackground(Color.WHITE);
		panelCentroIzquierda.add(lblMyProfile, "cell 0 0,alignx center,aligny bottom");
		//panelCentroIzquierda.setLayout(new MigLayout("", "[378.00px,grow][1px]", "[93.00px][72.00][grow]"));
		
		JLabel lblAvatar = new JLabel();
		panelCentroIzquierda.add(lblAvatar, "cell 0 2,alignx center,aligny center");

		BD.initBD("baseDeDatos");
		String avatar = BD.conseguirAvatar(con, u.getNombre());
		System.out.println("Este es el avatar "+ avatar);
		BD.closeBD(con);
		
		ImageIcon im = new ImageIcon(avatar);
		ImageIcon imagenConDimensiones = new ImageIcon(im.getImage().getScaledInstance(300,300,ImageView.CENTER));
		lblAvatar.setIcon(imagenConDimensiones);
		lblAvatar.setPreferredSize(new Dimension(300, 300));
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(255, 228, 196));
		panelCentral.add(panel);
		
		
		JLabel lblEnunciado = new JLabel("\tPedidos realizados:");
		lblEnunciado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnunciado.setForeground(new Color(255, 165, 0));
		lblEnunciado.setFont(new Font("Dialog", Font.BOLD, 42));
		panel.add(lblEnunciado, "cell 0 0,alignx center,aligny bottom");
		}
	}
	
	
