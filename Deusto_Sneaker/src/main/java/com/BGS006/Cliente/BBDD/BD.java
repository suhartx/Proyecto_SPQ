package com.BGS006.Cliente.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
	
	/**
	 * Crea la conexion con la BBDD
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
	 * @param con Conexion 
	 */
	public static void closeBD(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
	}
	
	/**
	 * Metodo que crea las tablas necesarias en la BBDD
	 * @param con Conexion
	 */
	public static void crearTablas(Connection con){
		String sent1 = "CREATE TABLE IF NOT EXISTS Articulos(ID Integer,Name String,Precio Double, Imagen String,Stock Integer, Talla Integer,Color String, Genero String, Plus String)";
		String sent2 = "CREATE TABLE IF NOT EXISTS Usuarios(Nick String, Contraseya String, Tarjeta String,Avatar String)";
				
		Statement st = null;
		
		try {
			st = con.createStatement();
			st.executeUpdate(sent1);
			st.executeUpdate(sent2);
		} catch (Exception e) {
		} finally {
			if(st!=null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
		}
	}
}
