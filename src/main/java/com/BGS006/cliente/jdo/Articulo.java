package com.BGS006.cliente.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 * clase donde se genaran los objetos articulo
 */
@PersistenceCapable(detachable = "true")
public class Articulo {

	@PrimaryKey
	private String nombre;
	private double precio;
	private long id;

	private String rutaImagen;
	private int stock;

	/**
	 * constructor con parametros
	 * @param nombre
	 * @param precio
	 * @param id
	 * @param rutaImagen
	 * @param stock
	 */


	public Articulo(String nombre, double precio, long id, String rutaImagen, int stock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.id = id;
		this.rutaImagen = rutaImagen;
		this.stock = stock;
	}

	/**
	 * constructor sin parametros
	 */
    public Articulo() {

    }

	/**
	 * recibe el nombre
	 * @return
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * establece el nombre
	 * @param nombre
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * recibe el precio
	 * @return
	 */

	public double getPrecio() {
		return precio;
	}

	/**
	 * establece el precio
	 * @param precio
	 */

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * recibe la ruta donde esta almacenada la imagen
	 * @return
	 */
	public String getRutaImagen() {
		return rutaImagen;
	}

	/**
	 * establece la ruta donde esta almacenada la imagen
	 * @param rutaImagen
	 */
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	/**
	 * recibe el id
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * establece el id
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * recibe el stock
	 * @return
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * establece el stock
	 * @param stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
