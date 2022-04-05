package com.BGS006.cliente.jdo;

import java.util.ArrayList;

public class Compra {

	private long idCompra;
	private int numArticulo;
	private double precio;
	private ArrayList<Articulo> articulo;
	
	
	public Compra(long idCompra, int numArticulo, double precio, ArrayList<Articulo> articulo) {
		super();
		this.idCompra = idCompra;
		this.numArticulo = numArticulo;
		this.precio = precio;
		this.articulo = articulo;
	}
	
	public long getIdCompra() {
		return idCompra;
	}
	
	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
	}
	
	public int getNumArticulo() {
		return numArticulo;
	}
	
	public void setNumArticulo(int numArticulo) {
		this.numArticulo = numArticulo;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public ArrayList<Articulo> getArticulo() {
		return articulo;
	}
	
	public void setArticulo(ArrayList<Articulo> articulo) {
		this.articulo = articulo;
	}
	
	
	
	
	
}
