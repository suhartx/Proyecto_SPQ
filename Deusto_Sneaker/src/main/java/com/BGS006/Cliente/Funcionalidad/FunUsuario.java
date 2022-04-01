package com.BGS006.Cliente.Funcionalidad;
import java.util.ArrayList;


import com.BGS006.Cliente.jdo.Usuario;

	//Arraylist
	
public class FunUsuario {
	public ArrayList<Usuario> arrayUsuarios;
	private static FunUsuario instance;

	public static FunUsuario getInstance() {
		if (instance == null) {
			instance = new FunUsuario();
		}

		return instance;
	}
	
	public boolean comprobarUsuario(String nom) {
		boolean esta = false;
		for(int i = 0; i < arrayUsuarios.size(); i++) {
			if(arrayUsuarios.get(i).getNombre().equals(nom)) {
				esta = true;
				break;
			}
		}
		return esta;
		
	}

	public void CrearUsuario(Usuario u) {
		if(comprobarUsuario(u.getNombre())){
			System.out.println("El usuario ya está registrado");
		} else {
			arrayUsuarios.add(u);
			System.out.println("Usuario creado");
		}
	}
	
	public void modificarContraUsuario(Usuario u, String contra) {
		
		int posicion = 0;
		
		for(int i = 0; i < arrayUsuarios.size(); i++) {
			if(arrayUsuarios.get(i).equals(u)) {
				posicion = i;
				arrayUsuarios.get(posicion).setContrasenya(contra);
				break;
			}
		}
	}

	public void eliminarUsuario(Usuario u) {
		if(comprobarUsuario(u.getNombre())){
			arrayUsuarios.remove(u);
		} else {
			System.out.println("Ese usuario no está en el sistema");
		}
	}
}
