package org.BGS006.cliente.jdo;

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

	@Persistent(defaultFetchGroup = "true")
	private Usuario usuario;



	@Join
	@Persistent(defaultFetchGroup = "true")
	private ArrayList<Articulo> articulos;
	
	
	public Compra(ArrayList<Articulo> articulos) {
		super();
		this.idCompra = count++;
		this.numArticulos = this.getNumArticulo();
		this.precio = this.getPrecio();
		this.articulos = articulos;
	}
	
	public long getIdCompra() {
		return idCompra;
	}

	public int getNumArticulo() {
		int contador = 0;
		for (Articulo a:this.articulos){
			contador++;
		}
		return contador;
	}

	
	public double getPrecio(){
		double precio = 0;
		for (Articulo a:this.articulos) {
			precio+= a.getPrecio();
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
		this.precio = this.getPrecio();
		this.numArticulos = this.getNumArticulo();
	}
	public void quitarArticulo(Articulo a){

		for (Articulo ar:this.articulos
			 ) {
			if (a.getNombre()==ar.getNombre())
			articulos.remove(a);
		}
	}
	
	
	
	
}
