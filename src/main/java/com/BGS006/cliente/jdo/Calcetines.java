package com.BGS006.cliente.jdo;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Calcetines extends Articulo{

	private int talla;
	private String color;
	private String gen;
	
	public Calcetines(String nombre, double precio, long id, String rutaImagen, int stock) {
		super(nombre, precio, id, rutaImagen, stock);
		// TODO Auto-generated constructor stub
	}
	
	public Calcetines(String nombre, double precio, long id, String rutaImagen, int stock, int talla, String color,
			String gen) {
		super(nombre, precio, id, rutaImagen, stock);
		this.talla = talla;
		this.color = color;
		this.gen = gen;
	}



	public int getTalla() {
		return talla;
	}

	public void setTalla(int talla) {
		this.talla = talla;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	
}
