package com.BGS006.cliente.jdo;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

/**
 * Clase limpiador
 */
@PersistenceCapable(detachable = "true")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Limpiador extends Articulo{

	private boolean plus;

	/**
	 * Constructor de la clase limpiador
	 * @param nombre
	 * @param precio
	 * @param id
	 * @param rutaImagen
	 * @param stock
	 */
	public Limpiador(String nombre, double precio, long id, String rutaImagen, int stock) {
		super(nombre, precio, id, rutaImagen, stock);
		// TODO Auto-generated constructor stub
	}

	public Limpiador(String nombre, double precio, long id, String rutaImagen, int stock, boolean plus) {
		super(nombre, precio, id, rutaImagen, stock);
		this.plus = plus;
	}

	/**
	 * Getter isPLus, devuelve isPlus
	 * @return
	 */
	public boolean isPlus() {
		return plus;
	}

	/**
	 * Setter isPlus, modifica isPlus
	 * @param plus
	 */
	public void setPlus(boolean plus) {
		this.plus = plus;
	}


}
