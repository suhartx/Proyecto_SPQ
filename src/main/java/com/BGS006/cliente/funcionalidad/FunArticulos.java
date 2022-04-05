package com.BGS006.cliente.funcionalidad;

import java.util.ArrayList;

import com.BGS006.cliente.jdo.Articulo;
import com.BGS006.cliente.jdo.Calcetines;
import com.BGS006.cliente.jdo.Limpiador;
import com.BGS006.cliente.jdo.Zapatillas;

public class FunArticulos {
	public ArrayList<Articulo> arrayArticulos;
	private static FunArticulos instance;

	public static FunArticulos getInstance() {
		if (instance == null) {
			instance = new FunArticulos();
		}

		return instance;
	}
	
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
	
	
	public void addCalcetin(Calcetines c) {
		if(comprobarArticulo(c.getNombre())){
			System.out.println("El usuario ya est� registrado");
		} else {
			arrayArticulos.add(c);
		}
		
	}
	
	public void addZapatilla(Zapatillas z) {
		if(comprobarArticulo(z.getNombre())){
			System.out.println("El usuario ya est� registrado");
		} else {
			arrayArticulos.add(z);
		}
	}
	
	public void addLimpiador(Limpiador l) {
		if(comprobarArticulo(l.getNombre())){
			System.out.println("El usuario ya est� registrado");
		} else {
			arrayArticulos.add(l);
		}
	}
	
	public void eliminarArticulo(Articulo a) {
		if(comprobarArticulo(a.getNombre())){
			arrayArticulos.remove(a);
		} else {
			System.out.println("Ese usuario no est� en el sistema");
		}
	}
	
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
