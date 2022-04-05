package com.BGS006.cliente.interfaz;

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

import com.BGS006.cliente.bbdd.BD;
import com.BGS006.cliente.jdo.Articulo;
import com.BGS006.cliente.jdo.Usuario;


public class LoginDeustoSneaker {

	private JFrame frame;
	private JTextField nombretxt;
	private JTextField nombre;
	private JPasswordField password;
	private JTextField tarjeta;
	private JPasswordField contraseyatxt;
	private JFileChooser fc;
	private File ficheroSeleccionado;
	private JLabel lblAvatar;

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
					
					LoginDeustoSneaker window = new LoginDeustoSneaker();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static TreeMap<Integer, Articulo> getTmArticulos() {
		return tmArticulos;
	}

	public static void setTmArticulos(TreeMap<Integer, Articulo> tmArticulos) {
		LoginDeustoSneaker.tmArticulos = tmArticulos;
	}

	public LoginDeustoSneaker() {
		//Zapatillas z = new Zapatillas("Jordan 1 Retro", 499.99, 527, "imagenes/airJordan1Retro.jpg", 12, 40, "Naranja/Blanco", "Hombre");
		con = BD.initBD("baseDeDatos");
		BD.crearTablas(con);
		//BD.insertarZapatillaBBDD(con, z);
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
		frame.getContentPane().setBackground(new Color(255, 165, 0));
		frame.setBounds(100, 100, 334, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("LoginDeusto Sneaker");

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBackground(new Color(255, 165, 0));
		tabbedPane.setBounds(0, 0, 323, 292);
		frame.getContentPane().add(tabbedPane);

		JPanel panelLogin = new JPanel();
				panelLogin.setBackground(new Color(255, 228, 196));
				tabbedPane.addTab("Login", null, panelLogin, null);
				panelLogin.setLayout(null);
				
						nombretxt = new JTextField();
						nombretxt.setForeground(new Color(255, 140, 0));
						nombretxt.setBackground(new Color(255, 228, 181));
						nombretxt.setBounds(68, 52, 172, 22);
						// frame.getContentPane().add(usuariotf);
						nombretxt.setColumns(10);
						panelLogin.add(nombretxt);
						
								JButton btningresar = new JButton("ENTRAR");
								btningresar.setBackground(new Color(255, 222, 173));
								btningresar.setForeground(new Color(255, 165, 0));
								btningresar.setFont(new Font("Lato", Font.BOLD, 16));
								btningresar.setBounds(108, 179, 105, 40);
								// frame.getContentPane().add(Ingresar);
								panelLogin.add(btningresar);
								btningresar.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										String nick = nombretxt.getText();
										String c = contraseyatxt.getText();
										
										if((!nick.equals("") && !c.equals("")) || (!nick.equals("admin") && !c.equals("admin"))) {
											Connection con = null;
											try {
												con = BD.initBD("baseDeDatos.db");
											} catch (Exception e3) {
												// TODO Auto-generated catch block
												e3.printStackTrace();
											}
											int resul = 0;
											try {
												resul = BD.obtenerUsuario(con, nick, c);
											} catch (Exception e2) {
												// TODO Auto-generated catch block
												e2.printStackTrace();
											}
											if((resul == 0) && !nick.equals("admin") && !c.equals("admin")){
												JOptionPane.showMessageDialog(null, "Todavia no te has registrado","��ERROR!!", JOptionPane.ERROR_MESSAGE);
												nombretxt.setText("");
												contraseyatxt.setText("");
											}else if(resul==1) {
												JOptionPane.showMessageDialog(null, "La contrase�a no es correcta","��ERROR!!", JOptionPane.ERROR_MESSAGE);
												
												contraseyatxt.setText("");
											}else {
												if((resul == 2) && (!nick.equals("admin") && !c.equals("admin"))){
													
													JOptionPane.showMessageDialog(null, "Cargando SneakerHome, bienvenid@ "+ nick,"WELCOME", JOptionPane.INFORMATION_MESSAGE);
													Usuario u = new Usuario(nick,c);
													
													try {
														new VentanaPrincipal(frame, u);
													} catch (Exception e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}
													frame.dispose();
												}else if(nick.equals("admin") && c.equals("admin")){
													JOptionPane.showMessageDialog(null, "Cargando SneakerHome VISUAL admin web","WELCOME", JOptionPane.INFORMATION_MESSAGE);
													Usuario admin = new Usuario("admin","admin");
													new VentanaAdmin(frame, admin);
													frame.dispose();
												}
											}
										}
									}
										
									
								});
								
								
										JLabel lblNewLabel = new JLabel("NICKNAME");
										lblNewLabel.setForeground(new Color(255, 140, 0));
										lblNewLabel.setFont(new Font("Lato", Font.BOLD, 18));
										lblNewLabel.setBounds(108, 11, 132, 30);
										// frame.getContentPane().add(lblNewLabel);
										panelLogin.add(lblNewLabel);
										
												JLabel lblNewLabel_1 = new JLabel("PASSWORD");
												lblNewLabel_1.setForeground(new Color(255, 140, 0));
												lblNewLabel_1.setFont(new Font("Lato", Font.BOLD, 18));
												lblNewLabel_1.setBounds(108, 85, 155, 30);
												// frame.getContentPane().add(lblNewLabel_1);
												panelLogin.add(lblNewLabel_1);
												
														contraseyatxt = new JPasswordField();
														contraseyatxt.setForeground(new Color(255, 140, 0));
														contraseyatxt.setBackground(new Color(255, 228, 181));
														contraseyatxt.setBounds(68, 126, 172, 22);
														panelLogin.add(contraseyatxt);

		JPanel panelRegistro = new JPanel();
		panelRegistro.setBackground(new Color(255, 228, 196));
		tabbedPane.addTab("Registro", null, panelRegistro, null);
		panelRegistro.setLayout(null);

		JButton btnAvatar = new JButton("Escoger avatar");
		btnAvatar.setBackground(new Color(255, 222, 173));
		btnAvatar.setForeground(new Color(255, 140, 0));
		btnAvatar.setBounds(167, 142, 129, 23);
		// frame.getContentPane().add(Ingresar);
		panelRegistro.add(btnAvatar);

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setForeground(new Color(255, 140, 0));
		labelNombre.setFont(new Font("Lato", Font.BOLD, 11));
		labelNombre.setBounds(36, 11, 63, 14);
		panelRegistro.add(labelNombre);

		JLabel labelcontrasenya = new JLabel("Contraseya");
		labelcontrasenya.setForeground(new Color(255, 140, 0));
		labelcontrasenya.setFont(new Font("Lato", Font.BOLD, 11));
		labelcontrasenya.setBounds(36, 62, 83, 14);
		panelRegistro.add(labelcontrasenya);

		JLabel labelTarjeta = new JLabel("Tarjeta Credito");
		labelTarjeta.setForeground(new Color(255, 140, 0));
		labelTarjeta.setFont(new Font("Lato", Font.BOLD, 11));
		labelTarjeta.setBounds(36, 118, 96, 14);
		panelRegistro.add(labelTarjeta);

		nombre = new JTextField();
		nombre.setForeground(new Color(255, 140, 0));
		nombre.setBackground(new Color(255, 228, 181));
		nombre.setBounds(36, 31, 96, 20);
		panelRegistro.add(nombre);
		nombre.setColumns(10);

		password = new JPasswordField();
		password.setForeground(new Color(255, 140, 0));
		password.setBackground(new Color(255, 228, 181));
		password.setBounds(36, 87, 96, 20);
		panelRegistro.add(password);

		tarjeta = new JTextField();
		tarjeta.setForeground(new Color(255, 140, 0));
		tarjeta.setBackground(new Color(255, 228, 181));
		tarjeta.setBounds(36, 143, 96, 20);
		panelRegistro.add(tarjeta);
		tarjeta.setColumns(10);

		lblAvatar = new JLabel("");
		lblAvatar.setSize(96, 108);
		lblAvatar.setLocation(186, 23);
		lblAvatar.setForeground(new Color(0, 0, 153));
		lblAvatar.setFont(new Font("Lato", Font.BOLD, 21));
		panelRegistro.add(lblAvatar);



		/*
		 * Eventos(Registro)
		 */

		JButton botonRegistro = new JButton("REGISTRARSE");
		botonRegistro.setForeground(new Color(255, 140, 0));
		botonRegistro.setBackground(new Color(255, 222, 173));
		botonRegistro.setFont(new Font("Lato", Font.BOLD, 16));
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
						LoginDeustoSneaker.tmUsuarios.put(u.getNombre(), u);
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


		botonRegistro.setBounds(85, 200, 147, 33);
		panelRegistro.add(botonRegistro);
		
		
		btnAvatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc = new JFileChooser("src/main/resources/avatares"); //Objeto que me va a permitir seleccionar un fichero
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
				lblAvatar.setIcon(imagenConDimensiones);
				lblAvatar.setPreferredSize(new DimensionUIResource(100, 100));
			}
		});

	}

	public void vaciarCampos() {
		nombre.setText("");
		password.setText("");
		tarjeta.setText("");
		lblAvatar.setIcon(null);
	}
}