package com.BGS006.cliente.jdo;

import javax.jdo.annotations.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Usuario implements Serializable {

	@PrimaryKey
	private String nombre;
	private String contrasenya;
	private String tarjetaPago;
	private String rutaAvatar;

	@Persistent(defaultFetchGroup = "true")
	@Join
	private List<Articulo> carro; // Compra


	@Persistent(mappedBy = "usuario", dependentElement = "true", defaultFetchGroup = "true")
	@Join
	private List<Compra> compras;
	


	public Usuario() {
		super();
		this.nombre = "";
		this.contrasenya = "";
		this.tarjetaPago = "";
		this.rutaAvatar = "";
		this.carro=new ArrayList<Articulo>();
		this.compras =new ArrayList<Compra>();
	}

	public Usuario(String nombre, String contrasenya,String tarjetaPago,String rutaAvatar) {
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.tarjetaPago = tarjetaPago;
		this.rutaAvatar = rutaAvatar;
		this.carro=new ArrayList<Articulo>();
		this.compras =new ArrayList<Compra>();
	}



	public Usuario (String nombre, String contrasenya) {
		this.nombre = nombre;
		this.contrasenya = contrasenya;
}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getContrasenya() {
		return contrasenya;
	}


	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}


	public String getTarjetaPago() {
		return tarjetaPago;
	}


	public void setTarjetaPago(String tarjetaPago) {
		this.tarjetaPago = tarjetaPago;
	}


	public String getRutaAvatar() {
		return rutaAvatar;
	}


	public void setRutaAvatar(String rutaAvatar) {
		this.rutaAvatar = rutaAvatar;
	}

	public ArrayList<Articulo> getCarro() {
		return (ArrayList<Articulo>) carro;
	}


	public void setCarro(ArrayList<Articulo> carro) {
		this.carro = carro;
	}


	public ArrayList<Compra> getCompras() {
		return (ArrayList<Compra>) compras;
	}



	public void setPedidos(ArrayList<Compra> compras) {
		this.compras = compras;
	}
	public void addPedido(Compra compra){
		this.compras.add(compra);
	}

	public void addCarrito(Articulo a) {
		if(a !=null) {
			carro.add(a);
		}
	}

	public void limpiarCarrito() {
		carro.clear();
	}

	public  void eliminarArticulo(int id) {
		Articulo f = carro.remove(id);
	}

	public int compareTo(Usuario u) {
		return u.nombre.compareTo(this.nombre);
	}



	@Override
	public String toString() {
		return "Usuario{" +
				"nombre='" + nombre + '\'' +
				", contrasenya='" + contrasenya + '\'' +
				", tarjetaPago='" + tarjetaPago + '\'' +
				", rutaAvatar='" + rutaAvatar + '\'' +
				'}';
	}


}
