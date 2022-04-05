package com.BGS006.cliente.jdo;

public class Limpiador extends Articulo{

	private boolean plus;
	
	public Limpiador(String nombre, double precio, long id, String rutaImagen, int stock) {
		super(nombre, precio, id, rutaImagen, stock);
		// TODO Auto-generated constructor stub
	}

	public Limpiador(String nombre, double precio, long id, String rutaImagen, int stock, boolean plus) {
		super(nombre, precio, id, rutaImagen, stock);
		this.plus = plus;
	}

	public boolean isPlus() {
		return plus;
	}

	public void setPlus(boolean plus) {
		this.plus = plus;
	}


}
