package com.BGS006.Cliente.Interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class LoginDeusto_Sneaker {

	private JFrame frame;
	private JTextField usuariotf;
	private JTextField nombre;
	private JTextField correo;
	private JPasswordField password;
	private JTextField dir;
	private JTextField ape1;
	private JTextField tarjeta;
	private JTextField ape2;
	private JTextField nick;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDeusto_Sneaker window = new LoginDeusto_Sneaker();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginDeusto_Sneaker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 334, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("LoginDeusto Sneaker");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 323, 292);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panelLogin = new JPanel();
		tabbedPane.addTab("Login", null, panelLogin, null);
		panelLogin.setLayout(null);
		
		usuariotf = new JTextField();
		usuariotf.setBounds(121, 27, 96, 20);
		//frame.getContentPane().add(usuariotf);
		usuariotf.setColumns(10);
		panelLogin.add(usuariotf);
		
		JButton ingresar = new JButton("ACCEDER");
		ingresar.setBounds(70, 134, 96, 23);
		//frame.getContentPane().add(Ingresar);
		panelLogin.add(ingresar);
		
		ingresar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
	/* 			UsuarioDB.LoginUsuario(usuariotf.getText(), passwordField.getText());
				if(UsuarioDB.correcto== true) 
				{
					frame.dispose();
				} */
			
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("NICKNAME");
		lblNewLabel.setBounds(29, 30, 72, 14);
		//frame.getContentPane().add(lblNewLabel);
		panelLogin.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1.setBounds(29, 68, 96, 14);
		//frame.getContentPane().add(lblNewLabel_1);
		panelLogin.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(121, 58, 96, 20);
		panelLogin.add(passwordField);
		
		JPanel panelRegistro = new JPanel();
		tabbedPane.addTab("Registro", null, panelRegistro, null);
		panelRegistro.setLayout(null);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(10, 11, 63, 14);
		panelRegistro.add(labelNombre);
		
		JLabel labelCorreo = new JLabel("Correo:");
		labelCorreo.setBounds(163, 11, 49, 14);
		panelRegistro.add(labelCorreo);
		
		JLabel labelcontrasenya = new JLabel("Contraseña");
		labelcontrasenya.setBounds(10, 66, 83, 14);
		panelRegistro.add(labelcontrasenya);
		
		JLabel labelDir = new JLabel("Direccion:");
		labelDir.setBounds(163, 66, 63, 14);
		panelRegistro.add(labelDir);
		
		JLabel labelApe1 = new JLabel("Apellido 1:");
		labelApe1.setBounds(10, 113, 63, 14);
		panelRegistro.add(labelApe1);
		
		JLabel labelTarjeta = new JLabel("Tarjeta Credito");
		labelTarjeta.setBounds(163, 113, 96, 14);
		panelRegistro.add(labelTarjeta);
		
		JLabel labelApe2 = new JLabel("Apellido 2");
		labelApe2.setBounds(10, 169, 63, 14);
		panelRegistro.add(labelApe2);
		
		JLabel labelNickname = new JLabel("Nickname:");
		labelNickname.setBounds(163, 169, 63, 14);
		panelRegistro.add(labelNickname);
		
		nombre = new JTextField();
		nombre.setBounds(10, 36, 96, 20);
		panelRegistro.add(nombre);
		nombre.setColumns(10);
		
		correo = new JTextField();
		correo.setBounds(163, 36, 96, 20);
		panelRegistro.add(correo);
		correo.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(10, 82, 96, 20);
		panelRegistro.add(password);
		
		dir = new JTextField();
		dir.setBounds(163, 82, 96, 20);
		panelRegistro.add(dir);
		dir.setColumns(10);
		
		ape1 = new JTextField();
		ape1.setBounds(10, 138, 96, 20);
		panelRegistro.add(ape1);
		ape1.setColumns(10);
		
		tarjeta = new JTextField();
		tarjeta.setBounds(163, 138, 96, 20);
		panelRegistro.add(tarjeta);
		tarjeta.setColumns(10);
		
		ape2 = new JTextField();
		ape2.setBounds(10, 194, 96, 20);
		panelRegistro.add(ape2);
		ape2.setColumns(10);
		
		nick = new JTextField();
		nick.setBounds(163, 194, 96, 20);
		panelRegistro.add(nick);
		nick.setColumns(10);
		
		JButton botonRegistro = new JButton("REGISTRARSE");
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c, n, ni, pa, a1, a2, d;
				int ta;
				boolean ad;
				
				c = correo.getText();
				n = nombre.getText();
				ni = nick.getText();
				pa = password.getText();
				a1 = ape1.getText();
				a2 = ape2.getText();
				d = dir.getText();
				ta = Integer.parseInt(tarjeta.getText());
				ad = false;
				
/* 				Usuario u = new Usuario(n, ni, pa, a1, a2, c, d, ta, ad);
				UsuarioDB.insertarUsuarios(u); */
				
			}
		});
		botonRegistro.setBounds(64, 230, 148, 23);
		panelRegistro.add(botonRegistro);
		
		
		
		
	}
}