package com.BGS006.Cliente.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TreeMap;

import com.BGS006.Cliente.jdo.Articulo;
import com.BGS006.Cliente.jdo.Calcetines;
import com.BGS006.Cliente.jdo.Color;
import com.BGS006.Cliente.jdo.Genero;
import com.BGS006.Cliente.jdo.Limpiador;
import com.BGS006.Cliente.jdo.Usuario;
import com.BGS006.Cliente.jdo.Zapatillas;

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
	 * Método que recibe los datos de un Articulo y comprueba que está registrado en
	 * la BBDD
	 * 
	 * @param nom nombre del Artiuclo
	 * @param con contraseña del Articulo
	 * @return 0 si el Articulo no está registrado 1 si el Articulo está registrado
	 *         pero la contraseña no es correcta 2 si el usuario está registrado y
	 *         la contraseña es correcta
	 * @throws DeustoException
	 */
	public static int articuloRegistrado(Connection con, int ID, String name) {
		String sentencia = "SELECT ID FROM Articulos WHERE 	Name ='" + name + "'";
		Statement st = null;
		int resul = 0;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sentencia);
			if (rs.next()) { // Hemos encontrado una tupla que cumple la condición
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
			if(rs.next()) { //Hemos encontrado una tupla que cumple la condición
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
	 * Método que recibe los datos de un Usuario y comprueba que está registrado en la BBDD
	 * @param nom nombre del usuario
	 * @param con contraseña del usuario
	 * @return 0 si el usuario no está registrado
	 * 		   1 si el usuario está registrado pero la contraseña no es correcta
	 * 		   2 si el usuario está registrado y la contraseña es correcta
	 */
	public static int obtenerUsuario(Connection con, String nombre, String c){
		String sentencia = "SELECT Contraseya FROM usuarios WHERE 	Nombre ='"+nombre+"'";
		Statement st = null;
		int resul=0;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sentencia);
			if(rs.next()) { //Hemos encontrado una tupla que cumple la condición
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
	 * Método que recibe los datos de un Articulo y comprueba que está registrado en la BBDD
	 * @param nom nombre del Artiuclo
	 * @param con contraseña del Articulo
	 * @return 0 si el Articulo no está registrado
	 * 		   1 si el Articulo está registrado pero la contraseña no es correcta
	 * 		   2 si el usuario está registrado y la contraseña es correcta
	 */
	public static int obtenerArticulo(Connection con, int ID, String nombre) {
		String sentencia = "SELECT ID FROM articulos WHERE 	Nombre ='"+nombre+"'";
		Statement st = null;
		int resul=0;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sentencia);
			if(rs.next()) { //Hemos encontrado una tupla que cumple la condición
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
		String sent = "INSERT INTO Articulos VALUES(" + z.getId() + ",'" + z.getNombre() + "','" + z.getPrecio() + "',"
				+ z.getRutaImagen() + ",'" + z.getStock() + "','" + z.getTalla() + "','" + z.getColor() + "','"
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
		String sent = "INSERT INTO Articulos VALUES(" + l.getId() + ",'" + l.getNombre() + "','" + l.getPrecio() + "',"
				+ l.getRutaImagen() + ",'" + l.getStock() + "','null','null','null','" + l.isPlus() + "','l')";
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
		String sent = "INSERT INTO Articulos VALUES(" + c.getId() + ",'" + c.getNombre() + "','" + c.getPrecio() + "',"
				+ c.getRutaImagen() + ",'" + c.getStock() + "','" + c.getTalla() + "','" + c.getColor() + "','"
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
	 * Método que permite al usuario cambiar su contraseña y se actualiza su info en la BD
	 * @param con Conexion
	 * @param nick El nick del usuario al que le vamos a cambiar la contraseña
	 * @param c La nueva contraseña
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
	 * Método que obtiene un mapa con los Articulos de la BBDD
	 * @param con Conexión con la BBDD
	 * @return TreeMap<String,Articulo>
	 * @throws DeustoException 
	 */
	public static TreeMap<Integer, Articulo> cargarMapaArticulosDeInfoBBDD(Connection con) {
		TreeMap<Integer, Articulo> tmArticulo = new TreeMap<>();
		Statement stmt = null;
		
		String sentSQL = "SELECT * FROM Articulos";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sentSQL);
			while(rs.next()) { 
					long ID = rs.getInt("ID");
					String nombre = rs.getString("Nombre");
					int precio = rs.getInt("Precio");
					String imagen = rs.getString("Imagen");
					int stock = rs.getInt("Stock");
					int talla = rs.getInt("Talla");
					String color = rs.getString("Color");
					String gen = rs.getString("Genero");
					Boolean plus = rs.getBoolean("Plus");
					String tipoArticulo = rs.getString("TipoArticulo");
					Articulo a = null;
					if(tipoArticulo.equals("z")) {
						a = new Zapatillas(nombre,precio,ID,imagen,stock,talla,color,gen);
					}else if(tipoArticulo.equals("l")) {
						a = new Limpiador(nombre,precio,ID,imagen,stock,plus);	
					}else if(tipoArticulo.equals("c")) {
						a = new Calcetines(nombre,precio,ID,imagen,stock,talla,color,gen);
					}
					tmArticulo.put((int) ID, a);
					
				}
			rs.close();
			stmt.close();
			
		} catch (Exception e) {
		} finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
		}
		return tmArticulo;
	}
}
