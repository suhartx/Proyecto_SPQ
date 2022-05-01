package org.BGS006.cliente.jdo;

public class Zapatillas extends Articulo {

	private int talla;
	private String color;
	private String gen;
	
	
	public Zapatillas(String nombre, double precio, String rutaImagen) {
		super(nombre, precio, rutaImagen);
		// TODO Auto-generated constructor stub
	}


	public Zapatillas(String nombre, double precio, String rutaImagen,  int talla, String color,
			String gen) {
		super(nombre, precio,  rutaImagen);
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
