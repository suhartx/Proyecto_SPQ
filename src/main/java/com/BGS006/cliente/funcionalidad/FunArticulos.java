package com.BGS006.cliente.funcionalidad;

import java.util.ArrayList;

import com.BGS006.cliente.jdo.Articulo;
import com.BGS006.cliente.jdo.Calcetines;
import com.BGS006.cliente.jdo.Limpiador;
import com.BGS006.cliente.jdo.Zapatillas;

/**
 * Clase que define la funcionalidad de articulos de usuario
 */
public class FunArticulos {
	public ArrayList<Articulo> arrayArticulos;
	private static FunArticulos instance;

	/**
	 * Crea o devuelve una instancia a la clase
	 * @return Devuelve el objeto de clase
	 */
	public static FunArticulos getInstance() {
		if (instance == null) {
			instance = new FunArticulos();
		}

		return instance;
	}

	/**
	 *
	 * Comprobacion de un articulo
	 * @param nom nombre del articulo
	 * @return Booleano si existe o no
	 */
	public boolean comprobarArticulo(String nom) {
		boolean esta = false;
		for(int i = 0; i < arrayArticulos.size(); i++) {
			if(arrayArticulos.get(i).getNombre().equals(nom)) {
				esta = true;
				break;
			}
		}
		return esta;
		
	}

	/**
	 *
	 * Añade un calcetin
	 * @param c calcetin
	 */
	public void addCalcetin(Calcetines c) {
		if(comprobarArticulo(c.getNombre())){
			System.out.println("El usuario ya est� registrado");
		} else {
			arrayArticulos.add(c);
		}
		
	}


	/**
	 *
	 * Añade una zapatilla a la bbdd
	 * @param z zapatilla que se añade
	 */
	public void addZapatilla(Zapatillas z) {
		if(comprobarArticulo(z.getNombre())){
			System.out.println("El usuario ya est� registrado");
		} else {
			arrayArticulos.add(z);
		}
	}


	/**
	 *
	 * Añade un limpiador
	 * @param l Referencia del objeto limpiador
	 */
	public void addLimpiador(Limpiador l) {
		if(comprobarArticulo(l.getNombre())){
			System.out.println("El usuario ya est� registrado");
		} else {
			arrayArticulos.add(l);
		}
	}


	/**
	 *
	 * Elimina el articulo
	 * @param a Un articulo para eliminar
	 */
	public void eliminarArticulo(Articulo a) {
		if(comprobarArticulo(a.getNombre())){
			arrayArticulos.remove(a);
		} else {
			System.out.println("Ese usuario no est� en el sistema");
		}
	}


	/**
	 *
	 * Modifica de un articulo con un stock dado
	 * @param c Referencia al articulo
	 * @param stock Número nuevo de stock
	 */
	public void modificarStock(Articulo c, int stock) {
		int posicion = 0;
		
		for(int i = 0; i < arrayArticulos.size(); i++) {
			if(arrayArticulos.get(i).equals(c)) {
				posicion = i;
				arrayArticulos.get(posicion).setStock(c.getStock()+stock);
				break;
			}
		}
	}
}
