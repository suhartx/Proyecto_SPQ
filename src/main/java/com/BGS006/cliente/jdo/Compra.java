package com.BGS006.cliente.jdo;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.ArrayList;
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
	
	
	public Compra(ArrayList<Articulo> articulos, double precio) {
		super();
		this.idCompra = count++;
		this.numArticulos = articulos.size();
		this.precio = precio;
		this.articulos = articulos;
	}

	public Compra(long id, String nombreUsuario,double precio,int numArticulos) {
		this.idCompra = id;
		this.nombreUsuario = nombreUsuario;
		this.precio = precio;
		this.numArticulos = numArticulos;
		this.articulos = new ArrayList<Articulo>();
	}

	public String getNombreUsuario(){
		return nombreUsuario;
	}
	
	public long getIdCompra() {
		return idCompra;
	}

	public int getNumArticulo() {

		return articulos.size();
	}
	public void setIdCompra(long id) {
		this.idCompra = id;
	}
	
	public double getPrecio(){
		double precio = 0;
		for (Articulo a:this.articulos) {
			precio += a.getPrecio();
		}

		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public ArrayList<Articulo> getArticulo() {
		return articulos;
	}
	
	public void setArticulos(ArrayList<Articulo> articulo) {
		this.articulos = articulo;
	}

	public void anyadirArticulo(Articulo a){
		this.articulos.add(a);
		this.precio += a.getPrecio();
		this.numArticulos += 1;
	}
	public void quitarArticulo(Articulo a){

		int i = 0;
		for (i=0;i<articulos.size();i++) {
			if (a.getNombre() == articulos.get(i).getNombre()){
				precio -= a.getPrecio();
				articulos.remove(i);
			}
		}

	}

	public double getPrec() {
		return precio;
	}
	
	
	
}
