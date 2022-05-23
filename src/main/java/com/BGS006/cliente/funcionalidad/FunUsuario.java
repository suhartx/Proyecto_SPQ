package com.BGS006.cliente.funcionalidad;

import java.util.ArrayList;

import com.BGS006.cliente.jdo.Articulo;
import com.BGS006.cliente.jdo.Usuario;


/**
 * Clase que define la funcionalidad del usuario
 */
public class FunUsuario {
	public ArrayList<Usuario> arrayUsuarios;
	private static FunUsuario instance;


	/**
	 * Devuelve una instancia a la clase si existe. Si no la crea.
	 * @return El objeto de la clase
	 */
	public static FunUsuario getInstance() {
		if (instance == null) {
			instance = new FunUsuario();
		}

		return instance;
	}


	/**
	 *
	 * Comprobamos que un usuario exista
	 * @param nom Nombre de usuario
	 * @return True : si existe. False : sino
	 */
	public boolean comprobarUsuario(String nom) {
		boolean esta = false;
		for (int i = 0; i < arrayUsuarios.size(); i++) {
			if (arrayUsuarios.get(i).getNombre().equals(nom)) {
				esta = true;
				break;
			}
		}
		return esta;

	}

	/**
	 *
	 * Creamos un usuario nuevo
	 * @param u Usuario a crear
	 */
	public void CrearUsuario(Usuario u) {
		if (comprobarUsuario(u.getNombre())) {
			System.out.println("El usuario ya est� registrado");
		} else {
			arrayUsuarios.add(u);
			System.out.println("Usuario creado");
		}
	}


	/**
	 *
	 * Modifica la contraseña de un usuario concreto
	 * @param u El usuario a modificar
	 * @param contra La nueva contraseña
	 */
	public void modificarContraUsuario(Usuario u, String contra) {

		int posicion = 0;

		for (int i = 0; i < arrayUsuarios.size(); i++) {
			if (arrayUsuarios.get(i).equals(u)) {
				posicion = i;
				arrayUsuarios.get(posicion).setContrasenya(contra);
				break;
			}
		}
	}

	/**
	 *
	 * Elimina un usuario concreto
	 * @param u El usuario a eliminar
	 */
	public void eliminarUsuario(Usuario u) {
		if (comprobarUsuario(u.getNombre())) {
			arrayUsuarios.remove(u);
		} else {
			System.out.println("Ese usuario no est� en el sistema");
		}
	}

	/**
	 * Añadimos un articulo nuevo a la cesta
	 * @param u El usuario que tiene el carrito
	 * @param a El articulo que se añade a la cesta
	 */
	public void aniadirArticuloACesta(Usuario u, Articulo a) {
		if (u.getCarro().size() < 100) {
			u.getCarro().add(a);
		} else {
			System.out.println("Maximo numero de productos");
		}
	}
}
