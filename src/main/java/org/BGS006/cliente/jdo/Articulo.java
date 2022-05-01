package org.BGS006.cliente.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Articulo {

	@PrimaryKey
	private String nombre;
	private double precio;
	private String rutaImagen;
	//private int stock;


	
	
	public Articulo(String nombre, double precio, String rutaImagen/*, int stock*/) {
		this.nombre = nombre;
		this.precio = precio;
		this.rutaImagen = rutaImagen;
		//this.stock = stock;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}


	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

//
//	public int getStock() {
//		return stock;
//	}
//
//
//	public void setStock(int stock) {
//		this.stock = stock;
//	}
	
	

}
