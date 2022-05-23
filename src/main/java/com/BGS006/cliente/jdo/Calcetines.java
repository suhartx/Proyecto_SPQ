package com.BGS006.cliente.jdo;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

/**
 * clase donde se generan los objetos calcetines
 */
@PersistenceCapable(detachable = "true")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Calcetines extends Articulo{

	private int talla;
	private String color;
	private String gen;

	/**
	 * contructor con parametros
	 * @param nombre
	 * @param precio
	 * @param id
	 * @param rutaImagen
	 * @param stock
	 */
	public Calcetines(String nombre, double precio, long id, String rutaImagen, int stock) {
		super(nombre, precio, id, rutaImagen, stock);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor con parametros
	 * @param nombre
	 * @param precio
	 * @param id
	 * @param rutaImagen
	 * @param stock
	 * @param talla
	 * @param color
	 * @param gen
	 */
	public Calcetines(String nombre, double precio, long id, String rutaImagen, int stock, int talla, String color,
			String gen) {
		super(nombre, precio, id, rutaImagen, stock);
		this.talla = talla;
		this.color = color;
		this.gen = gen;
	}


	/**
	 * recibe la talla
	 * @return
	 */
	public int getTalla() {
		return talla;
	}

	/**
	 * establece la talla
	 * @param talla
	 */
	public void setTalla(int talla) {
		this.talla = talla;
	}

	/**
	 * recibe el color
	 * @return
	 */
	public String getColor() {
		return color;
	}

	/**
	 * establece el color
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * recibe el genero
	 * @return
	 */
	public String getGen() {
		return gen;
	}

	/**
	 * establece el genero
	 * @param gen
	 */
	public void setGen(String gen) {
		this.gen = gen;
	}

	
}
