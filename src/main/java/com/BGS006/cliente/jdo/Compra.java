package com.BGS006.cliente.jdo;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.ArrayList;

/**
 * clase donde se generan los objetos compra
 */
@PersistenceCapable(detachable = "true")
public class Compra {

	private static int count = 0;
	@PrimaryKey
	private long idCompra;
	private int numArticulos;
	private double precio;
	private String nombreUsuario;

	@Persistent(defaultFetchGroup = "true")
	private Usuario usuario;


	@Join
	@Persistent(defaultFetchGroup = "true")
	private ArrayList<Articulo> articulos;

	/**
	 * Constructor con parametros
	 * @param articulos
	 * @param precio
	 */
	public Compra(ArrayList<Articulo> articulos, double precio) {
		super();
		this.idCompra = count++;
		this.numArticulos = articulos.size();
		this.precio = precio;
		this.articulos = articulos;
	}

	/**
	 * constructor con parametros
	 * @param id
	 * @param nombreUsuario
	 * @param precio
	 * @param numArticulos
	 */
	public Compra(long id, String nombreUsuario,double precio,int numArticulos) {
		this.idCompra = id;
		this.nombreUsuario = nombreUsuario;
		this.precio = precio;
		this.numArticulos = numArticulos;
		this.articulos = new ArrayList<Articulo>();
	}

	/**
	 * recibe el nombre de usuario
	 * @return
	 */
	public String getNombreUsuario(){
		return nombreUsuario;
	}

	/**
	 * establece el nombre de usuario
	 * @param nombreUsuario2
	 */
	public void setNombreUsuario(String nombreUsuario2){
		this.nombreUsuario = nombreUsuario2;
	}

	/**
	 * recibe el id de la compra
	 * @return
	 */
	public long getIdCompra() {
		return idCompra;
	}

	/**
	 * recibe el numero de articulos
	 * @return
	 */
	public int getNumArticulo() {

		return articulos.size();
	}

	/**
	 * establece el numero de articulos
	 * @param numero
	 */
	public void setNumArticulos(int numero){
		this.numArticulos = numero;
	}

	/**
	 * establece el id de la compra
	 * @param id
	 */
	public void setIdCompra(long id) {
		this.idCompra = id;
	}

	/**
	 * recibe el precio
	 * @return
	 */
	public double getPrecio(){
		double precio = 0;
		for (Articulo a:this.articulos) {
			precio += a.getPrecio();
		}

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
	 * recibe una lista de articulos
	 * @return
	 */
	public ArrayList<Articulo> getArticulo() {
		return articulos;
	}

	/**
	 * establece una lista de articulos
	 * @param articulo
	 */
	public void setArticulos(ArrayList<Articulo> articulo) {
		this.articulos = articulo;
	}

	/**
	 * Metodo para añadir articulo
	 * @param a
	 */
	public void anyadirArticulo(Articulo a){
		this.articulos.add(a);
		this.precio += a.getPrecio();
		this.numArticulos += 1;
	}

	/**
	 * metodo para quitar articulo
	 * @param a
	 */
	public void quitarArticulo(Articulo a){

		int i = 0;
		for (i=0;i<articulos.size();i++) {
			if (a.getNombre() == articulos.get(i).getNombre()){
				precio -= a.getPrecio();
				articulos.remove(i);
			}
		}

	}

	/**
	 * recibe el precio
	 * @return
	 */
	public double getPrec() {
		return precio;
	}
	
	
	
}
