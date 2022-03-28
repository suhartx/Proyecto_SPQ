package com.BGS006.Cliente.jdo;

public class Calcetines extends Articulo{

	private int talla;
	private Color color;
	private Genero gen;
	
	public Calcetines(String nombre, double precio, long id, String rutaImagen, int stock) {
		super(nombre, precio, id, rutaImagen, stock);
		// TODO Auto-generated constructor stub
	}
	
	public Calcetines(String nombre, double precio, long id, String rutaImagen, int stock, int talla, Color color,
			Genero gen) {
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Genero getGen() {
		return gen;
	}

	public void setGen(Genero gen) {
		this.gen = gen;
	}

	
}
