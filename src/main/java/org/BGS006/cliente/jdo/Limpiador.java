package org.BGS006.cliente.jdo;

public class Limpiador extends Articulo{

	private boolean plus;
	
	public Limpiador(String nombre, double precio, String rutaImagen) {
		super(nombre, precio, rutaImagen);
		// TODO Auto-generated constructor stub
	}

	public Limpiador(String nombre, double precio, String rutaImagen, boolean plus) {
		super(nombre, precio, rutaImagen);
		this.plus = plus;
	}

	public boolean isPlus() {
		return plus;
	}

	public void setPlus(boolean plus) {
		this.plus = plus;
	}


}
