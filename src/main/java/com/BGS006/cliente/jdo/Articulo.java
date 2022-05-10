package com.BGS006.cliente.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Articulo {

	@PrimaryKey
	private String nombre;
	private double precio;
	private long id;

	private String rutaImagen;
	private int stock;




	public Articulo(String nombre, double precio, long id, String rutaImagen, int stock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.id = id;
		this.rutaImagen = rutaImagen;
		this.stock = stock;
	}

    public Articulo() {

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

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
