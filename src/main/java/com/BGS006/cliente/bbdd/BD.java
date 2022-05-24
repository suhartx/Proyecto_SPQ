package com.BGS006.cliente.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TreeMap;

import com.BGS006.cliente.jdo.Articulo;
import com.BGS006.cliente.jdo.Calcetines;
import com.BGS006.cliente.jdo.Limpiador;
import com.BGS006.cliente.jdo.Usuario;
import com.BGS006.cliente.jdo.Zapatillas;

public class BD {

	/**
	 * Crea la conexion con la BBDD
	 * 
	 * @param baseDeDatos
	 * @return deuvelve la cionexion si ha sido exitosa la comunicacion
	 */
	public static Connection initBD(String nomBD) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:baseDeDatos");
		} catch (Exception e) {
		}
		return con;
	}

	/**
	 * Cierra la BBDD
	 * 
	 * @param con Conexion
	 */
	public static void closeBD(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * Metodo que crea las tablas necesarias en la BBDD
	 * 
	 * @param con Conexion
	 */
	public static void crearTablas(Connection con) {
		String sent1 = "CREATE TABLE IF NOT EXISTS Articulos(ID Integer,Nombre String,Precio Double, Imagen String,Stock Integer, Talla Integer,Color String, Genero String, Plus String,TipoArticulo String)";
		String sent2 = "CREATE TABLE IF NOT EXISTS Usuarios(Nombre String, Contraseya String, Tarjeta String,Avatar String)";

		Statement st = null;

		try {
			st = con.createStatement();
			st.executeUpdate(sent1);
			st.executeUpdate(sent2);
		} catch (Exception e) {
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}
	}

	/**
	 * M�todo que recibe los datos de un Articulo y comprueba que est� registrado en
	 * la BBDD
	 * 
	 * @param nom nombre del Artiuclo
	 * @param con contrase�a del Articulo
	 * @return 0 si el Articulo no est� registrado 1 si el Articulo est� registrado
	 *         pero la contrase�a no es correcta 2 si el usuario est� registrado y
	 *         la contrase�a es correcta
	 */
	public static int articuloRegistrado(Connection con, int ID, String name) {
		String sentencia = "SELECT ID FROM Articulos WHERE 	Name ='" + name + "'";
		Statement st = null;
		int resul = 0;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sentencia);
			if (rs.next()) { // Hemos encontrado una tupla que cumple la condici�n
				if (rs.getString("ID").equals(ID)) {
					resul = 2;
				} else {
					resul = 1;
				}
			} else {
				resul = 0;
			}
			rs.close();
		} catch (Exception e) {
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}
		return resul;
	}
	
	/**
	 * Metodo que comprueba si el nombre del usario esta ya introducido en la BBDD
	 * @param con Conexion
	 * @param nombre nick introducido por el usuario
	 * @return resul 
	 * 		
	 * 		1. Si el nombre ya esta regitrado y se debra escoger otro nombre
	 * 		0. Si el nombre no esta en la BBDD
	 */
	
	public static int estaRegistrado(Connection con, String nombre) {
		String sentencia = "SELECT Nombre FROM usuarios WHERE Nombre ='" + nombre + "'";
		Statement st = null;
		int resul = 0;
		
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sentencia);
			if(rs.next()) {
				if(rs.getString("Nombre").equals(nombre));
				resul = 1;
			}else {
				resul = 0;
			}
			rs.close();
		} catch (Exception e) {
		} finally {
			if(st!=null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}
		return resul;
	}
	

	public static void intertarUsuarioBBDD(Connection con, Usuario u) {
		String sent = "INSERT INTO Usuarios VALUES('" + u.getNombre() + "','" + u.getContrasenya() + "','"
				+ u.getTarjetaPago() + "','" + u.getRutaAvatar()+ "')";
		Statement st = null;
		try {
			st = con.createStatement();
			st.executeUpdate(sent);
		} catch (Exception e) {
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}
	}
	
	public static String conseguirAvatar(Connection con,String nick) {
		String sent = "SELECT Avatar FROM usuarios WHERE Nombre ='"+nick+"'";
		Statement st = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sent);
			if(rs.next()) { //Hemos encontrado una tupla que cumple la condici�n
				String avatar = rs.getString("Avatar");
				rs.close();
				return avatar;
			}
		} catch (Exception e) {
		} finally {
			if(st!=null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}
		return null;
	}
	
	/**
	 * M�todo que recibe los datos de un Usuario y comprueba que est� registrado en la BBDD
	 * @param nom nombre del usuario
	 * @param con contrase�a del usuario
	 * @return 0 si el usuario no est� registrado
	 * 		   1 si el usuario est� registrado pero la contrase�a no es correcta
	 * 		   2 si el usuario est� registrado y la contrase�a es correcta
	 */
	public static int obtenerUsuario(Connection con, String nombre, String c){
		String sentencia = "SELECT Contraseya FROM usuarios WHERE 	Nombre ='"+nombre+"'";
		Statement st = null;
		int resul=0;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sentencia);
			if(rs.next()) { //Hemos encontrado una tupla que cumple la condici�n
				if(rs.getString("Contraseya").equals(c)) {
					resul = 2;
				}else {
					resul = 1;
				}
			}else {
				resul = 0;
			}
			rs.close();
		} catch (Exception e) {
		} finally {
			if(st!=null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}
		return resul;
	}
	
	/**
	 * M�todo que recibe los datos de un Articulo y comprueba que est� registrado en la BBDD
	 * @param nom nombre del Artiuclo
	 * @param con contrase�a del Articulo
	 * @return 0 si el Articulo no est� registrado
	 * 		   1 si el Articulo est� registrado pero la contrase�a no es correcta
	 * 		   2 si el usuario est� registrado y la contrase�a es correcta
	 */
	public static int obtenerArticulo(Connection con, int ID, String nombre) {
		String sentencia = "SELECT ID FROM articulos WHERE 	Nombre ='"+nombre+"'";
		Statement st = null;
		int resul=0;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sentencia);
			if(rs.next()) { //Hemos encontrado una tupla que cumple la condici�n
				if(rs.getString("ID").equals(ID)) {
					resul = 2;
				}else {
					resul = 1;
				}
			}else {
				resul = 0;
			}
			rs.close();
		} catch (Exception e) {
		} finally {
			if(st!=null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}
		return resul;
	}

	/**
	 * Metodo que introduce un Zapatilla pasado por parametro en la tabla de Zapatilla de la BBDD
	 * @param con Conexion
	 * @param z Zapatilla ha introducir
	 */
	
	public static void insertarZapatillaBBDD(Connection con, Zapatillas z) {
		String sent = "INSERT INTO articulos VALUES(" + z.getId() + ",'" + z.getNombre() + "'," + z.getPrecio() + ",'"
				+ z.getRutaImagen() + "'," + z.getStock() + "," + z.getTalla() + ",'" + z.getColor() + "','"
				+ z.getGen() + "','null','z')";
		Statement st = null;

		try {
			st = con.createStatement();

		} catch (Exception e) {

		}
		try {
			st.executeUpdate(sent);
		} catch (Exception e) {

		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}

	}

	/**
	 * Metodo que introduce un Limpiador pasado por parametro en la tabla de Limpiador de la BBDD
	 * @param con Conexion
	 * @param l Limpiador ha introducir
	 */
	
	public static void insertarLimpiadorBBDD(Connection con, Limpiador l) {
		String sent = "INSERT INTO Articulos VALUES(" + l.getId() + ",'" + l.getNombre() + "'," + l.getPrecio() + ",'"
				+ l.getRutaImagen() + "'," + l.getStock() + ",'null','null','null','" + l.isPlus() + "','l')";
		Statement st = null;

		try {
			st = con.createStatement();

		} catch (Exception e) {

		}
		try {
			st.executeUpdate(sent);
		} catch (Exception e) {

		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {

				}
			}
		}

	}

	/**
	 * Metodo que introduce un Calcetin pasado por parametro en la tabla de Calcetin de la BBDD
	 * @param con Conexion
	 * @param c Calcetin ha introducir
	 */
	
	public static void insertarCalcetinBBDD(Connection con, Calcetines c) {
		String sent = "INSERT INTO Articulos VALUES(" + c.getId() + ",'" + c.getNombre() + "'," + c.getPrecio() + ",'"
				+ c.getRutaImagen() + "'," + c.getStock() + "," + c.getTalla() + ",'" + c.getColor() + "','"
				+ c.getGen() + "','null','c')";
		Statement st = null;
		try {
			st = con.createStatement();

		} catch (Exception e) {

		}
		try {
			st.executeUpdate(sent);
		} catch (Exception e) {

		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {

				}
			}
		}

	}

	/**
	 * Metodo que elimina un Articulo pasado por paremtro de la tabla de Articulos
	 * de la BBDD
	 * 
	 * @param con Conexion
	 * @param ID  ID del articulo a eliminar
	 */

	public static void eliminarArticuloBBDD(Connection con, long ID) {
		String sent = "DELETE FROM Articulos WHERE ID='" + ID + "'";
		Statement st = null;

		try {
			st = con.createStatement();
		} catch (Exception e) {
		}
		try {
			st.executeUpdate(sent);
		} catch (Exception e) {
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}
	}

	/**
	 * M�todo que permite al usuario cambiar su contrase�a y se actualiza su info en la BD
	 * @param con Conexion
	 * @param nick El nick del usuario al que le vamos a cambiar la contrase�a
	 * @param c La nueva contrase�a
	 */
	public static void cambiarContrasenya(Connection con, String nick, String c) {
		String sent = "UPDATE usuarios SET Contraseya = '" + c + "' WHERE Nombre = '" + nick + "'";
		Statement st = null;

		try {
			st = con.createStatement();
			st.executeUpdate(sent);
		} catch (Exception e) {
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}

	}
	
	/**
	 * M�todo que obtiene un mapa con los Articulos de la BBDD
	 * @param con Conexi�n con la BBDD
	 * @return TreeMap<String,Articulo>
	 * @thros DeustoException
	 */
	public static TreeMap<Integer, Articulo> cargarMapaArticulosDeInfoBBDD(Connection con) {
		TreeMap<Integer, Articulo> tmArticulo = new TreeMap<>();
		Statement stmt = null;
		
		String sentSQL = "SELECT * FROM articulos";
//		try {
//			stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(sentSQL);
//			while(rs.next()) {
//					long ID = rs.getInt("ID");
//					String nombre = rs.getString("Nombre");
//					int precio = rs.getInt("Precio");
//					String imagen = rs.getString("Imagen");
//					int stock = rs.getInt("Stock");
//					int talla = rs.getInt("Talla");
//					String color = rs.getString("Color");
//					String gen = rs.getString("Genero");
//					Boolean plus = rs.getBoolean("Plus");
//					String tipoArticulo = rs.getString("TipoArticulo");
//					Articulo a = null;
//					if(tipoArticulo.equals("z")) {
//						a = new Zapatillas(nombre,precio,ID,imagen,stock,talla,color,gen);
//					}else if(tipoArticulo.equals("l")) {
//						a = new Limpiador(nombre,precio,ID,imagen,stock,plus);
//					}else if(tipoArticulo.equals("c")) {
//						a = new Calcetines(nombre,precio,ID,imagen,stock,talla,color,gen);
//					}
//					tmArticulo.put((int) ID, a);
//
//				}
//			rs.close();
//			stmt.close();
//
//		} catch (Exception e) {
//		} finally {
//			if(stmt!=null) {
//				try {
//					stmt.close();
//				} catch (Exception e) {
//				}
//			}
//		}
		return tmArticulo;
	}

	/**
	 * Metodo que permite cargar un treeMap con todas las zaptillas de la BBDD
	 * @param con
	 * @return TreeMap con todas las zapatillas regitradas
	 */
	public static TreeMap<Integer,Articulo> cargarZapatillasDeInfoDeBBDD(Connection con) {
		TreeMap<Integer, Articulo> tmZapatillas = new TreeMap<>();
		Statement stmt = null;

		String sentSQL = "SELECT * FROM Articulos WHERE TipoArticulo = 'z'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sentSQL);
			while(rs.next()) {
				int ID = rs.getInt("ID");
				String nombre = rs.getString("Nombre");
				int precio = rs.getInt("Precio");
				String imagen = rs.getString("Imagen");
				int stock = rs.getInt("Stock");
				int talla = rs.getInt("Talla");
				String color = rs.getString("Color");
				String genero = rs.getString("Genero");

				Zapatillas z = new Zapatillas(nombre,precio,ID,imagen,stock,talla,color,genero);
				tmZapatillas.put(ID, z);
			}
			rs.close();
			stmt.close();
			System.out.println("Zapatillas cargadas con exito.... \n");
		} catch (Exception e1) {

		} finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (Exception e) {

				}
			}
		}

		return tmZapatillas;
	}

	/**
	 * Metodo que permite cargar un treeMap con todas los calcetines de la BBDD
	 * @param con
	 * @return TreeMap con todas las calcetines regitradas
	 */
	public static TreeMap<Integer,Articulo> cargarCalcetinesDeInfoDeBBDD(Connection con){
		TreeMap<Integer, Articulo> tmCalcetines = new TreeMap<>();
		Statement stmt = null;

		String sentSQL = "SELECT * FROM Articulos WHERE TipoArticulo = 'c'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sentSQL);
			while(rs.next()) {
				int ID = rs.getInt("ID");
				String nombre = rs.getString("Nombre");
				int precio = rs.getInt("Precio");
				String imagen = rs.getString("Imagen");
				int stock = rs.getInt("Stock");
				int talla = rs.getInt("Talla");
				String color = rs.getString("Color");
				String genero = rs.getString("Genero");

				Calcetines z = new Calcetines(nombre,precio,ID,imagen,stock,talla,color,genero);
				tmCalcetines.put(ID, z);
			}
			rs.close();
			stmt.close();
			System.out.println("Calcetines cargados con exito.... \n");
		} catch (Exception e) {

		} finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (Exception e) {

				}
			}
		}

		return tmCalcetines;
	}

	/**
	 * Metodo que permite cargar un treeMap con todas los limpiadores de la BBDD
	 * @param con
	 * @return TreeMap con todas los limpiadores regitradas
	 */
	public static TreeMap<Integer,Articulo> cargarLimpiadoresDeInfoDeBBDD(Connection con){
		TreeMap<Integer, Articulo> tmLimpiadores = new TreeMap<>();
		Statement stmt=null;

		String sentSQL = "SELECT * FROM Articulos WHERE TipoArticulo = 'l'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sentSQL);
			while(rs.next()) {
				int ID = rs.getInt("ID");
				String nombre = rs.getString("Nombre");
				int precio = rs.getInt("Precio");
				String imagen = rs.getString("Imagen");
				int stock = rs.getInt("Stock");
				Boolean plus = rs.getBoolean("Plus");

				Limpiador l = new Limpiador(nombre,precio,ID,imagen,stock,plus);
				tmLimpiadores.put(ID, l);
			}
			rs.close();
			stmt.close();
			System.out.println("Sudadera cargados con exito.... \n");
		} catch (Exception e) {

		} finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (Exception e) {

				}
			}
		}

		return tmLimpiadores;
	}

}
