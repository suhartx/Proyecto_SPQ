package com.BGS006.Cliente.Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.html.ImageView;

import com.BGS006.Cliente.BBDD.BD;
import com.BGS006.Cliente.Funcionalidad.FunUsuario;
import com.BGS006.Cliente.jdo.Articulo;
import com.BGS006.Cliente.jdo.Usuario;


public class LoginDeusto_Sneaker {

	private JFrame frame;
	private JTextField usuariotf;
	private JTextField nombre;
	private JPasswordField password;
	private JTextField tarjeta;
	private JPasswordField passwordField;
	private JFileChooser fc;
	private File ficheroSeleccionado;
	private JLabel lblAvatarSeleccionado;

	public static Connection con;
	public static TreeMap<String, Usuario> tmUsuarios = new TreeMap<>();
	public static TreeMap<Integer,Articulo> tmArticulos = new TreeMap<>();

	/**
	 * Launch the application.
	 */
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		con = BD.initBD("baseDeDatos.db");
		BD.crearTablas(con);
		BD.cargarMapaArticulosDeInfoBBDD(con);
		BD.closeBD(con);
	/*	FunUsuario.getInstance().CrearUsuario();
		FunUsuario.getInstance().Holamundo();
		*/initialize();
		

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

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(0, 0, 323, 292);
		frame.getContentPane().add(tabbedPane);

		JPanel panelLogin = new JPanel();
		tabbedPane.addTab("Login", null, panelLogin, null);
		panelLogin.setLayout(null);

		usuariotf = new JTextField();
		usuariotf.setBounds(157, 27, 96, 20);
		// frame.getContentPane().add(usuariotf);
		usuariotf.setColumns(10);
		panelLogin.add(usuariotf);

		JButton btningresar = new JButton("ACCEDER");
		btningresar.setBounds(104, 114, 96, 23);
		// frame.getContentPane().add(Ingresar);
		panelLogin.add(btningresar);

		/**
		 * Eventos (Login)
		 */
		btningresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * UsuarioDB.LoginUsuario(usuariotf.getText(), passwordField.getText());
				 * if(UsuarioDB.correcto== true) { frame.dispose(); }
				 */

			}
		});


		JLabel lblNewLabel = new JLabel("NICKNAME");
		lblNewLabel.setBounds(51, 30, 72, 14);
		// frame.getContentPane().add(lblNewLabel);
		panelLogin.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CONTRASEYA");
		lblNewLabel_1.setBounds(51, 68, 96, 14);
		// frame.getContentPane().add(lblNewLabel_1);
		panelLogin.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(157, 65, 96, 20);
		panelLogin.add(passwordField);

		JPanel panelRegistro = new JPanel();
		tabbedPane.addTab("Registro", null, panelRegistro, null);
		panelRegistro.setLayout(null);

		JButton btnAvatar = new JButton("Escoger avatar");
		btnAvatar.setBounds(168, 168, 129, 23);
		// frame.getContentPane().add(Ingresar);
		panelRegistro.add(btnAvatar);

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(36, 37, 63, 14);
		panelRegistro.add(labelNombre);

		JLabel labelcontrasenya = new JLabel("Contraseya");
		labelcontrasenya.setBounds(36, 84, 83, 14);
		panelRegistro.add(labelcontrasenya);

		JLabel labelTarjeta = new JLabel("Tarjeta Credito");
		labelTarjeta.setBounds(36, 131, 96, 14);
		panelRegistro.add(labelTarjeta);

		nombre = new JTextField();
		nombre.setBounds(36, 53, 96, 20);
		panelRegistro.add(nombre);
		nombre.setColumns(10);

		password = new JPasswordField();
		password.setBounds(36, 100, 96, 20);
		panelRegistro.add(password);

		tarjeta = new JTextField();
		tarjeta.setBounds(36, 145, 96, 20);
		panelRegistro.add(tarjeta);
		tarjeta.setColumns(10);

		JLabel lblAvatar = new JLabel("");
		lblAvatar.setSize(96, 108);
		lblAvatar.setLocation(185, 49);
		lblAvatar.setForeground(new Color(0, 0, 153));
		lblAvatar.setFont(new Font("Lato", Font.BOLD, 21));
		panelRegistro.add(lblAvatar);



		/*
		 * Eventos(Registro)
		 */

		JButton botonRegistro = new JButton("REGISTRARSE");
		botonRegistro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String n,pa,ta,av;



				n = nombre.getText();
				pa = password.getText();
				ta = tarjeta.getText();
				av = ficheroSeleccionado.getAbsolutePath();
				System.out.println(av);

				if(!n.equals("admin") && (!n.equals("") && !pa.equals("") && !ta.equals(""))) {
					Connection con = null;
					Connection con2 = null;
					try {
						con = BD.initBD("baseDeDatos");
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					int valor = 0;
					try {
						valor = BD.estaRegistrado(con, n);
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if(valor == 0) {
						Usuario u = new Usuario(n, pa,ta,av);
						LoginDeusto_Sneaker.tmUsuarios.put(u.getNombre(), u);
						try {
							con2 = BD.initBD("baseDeDatos");
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							BD.intertarUsuarioBBDD(con2,u);
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							BD.closeBD(con2);
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Usuario registrado correctamente", "REGISTRO CORRECTO", JOptionPane.INFORMATION_MESSAGE);
						vaciarCampos();
					}else {
						JOptionPane.showMessageDialog(null, "Nick ya en uso, prueba con otro distinto", "��ERROR!!", JOptionPane.ERROR_MESSAGE);
						nombre.setText("");
					}
				}else {
					JOptionPane.showMessageDialog(null, "El nombre no es correcto, recuerda que tu nick: \n\t 1. No puede contener numeros, solo letras \n\t 2. No puedes crear cuenta con nick 'admin' \n\t 3. El campo contrase�a no puede estar vacio", "��ERROR!!", JOptionPane.ERROR_MESSAGE);
					nombre.setText("");
				}
			}
		});


		botonRegistro.setBounds(82, 220, 147, 33);
		panelRegistro.add(botonRegistro);

		btnAvatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc = new JFileChooser("avatares"); //Objeto que me va a permitir seleccionar un fichero
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("JPG & PNG", "jpg","png");
				fc.setFileFilter(fnef);

				int sel = fc.showOpenDialog(null); //Abre la ventana de selecci�n de fichero
				if(sel == JFileChooser.APPROVE_OPTION) { //Si ha seleccionado abrir
					ficheroSeleccionado = fc.getSelectedFile();
					System.out.println("Nombre del fichero seleccinado: "+ ficheroSeleccionado.getName());

					System.out.println("Ruta del fichero seleccionado: "+ ficheroSeleccionado.getAbsolutePath());
				}
				ImageIcon im = new ImageIcon(ficheroSeleccionado.getAbsolutePath());
				ImageIcon imagenConDimensiones = new ImageIcon(im.getImage().getScaledInstance(100,100,ImageView.CENTER));
				lblAvatarSeleccionado.setIcon(imagenConDimensiones);
				lblAvatarSeleccionado.setPreferredSize(new DimensionUIResource(100, 100));
			}
		});

	}

	public void vaciarCampos() {
		nombre.setText("");
		password.setText("");
		tarjeta.setText("");
		lblAvatarSeleccionado.setIcon(null);
	}

}