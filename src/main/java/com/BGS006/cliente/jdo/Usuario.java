package com.BGS006.cliente.jdo;

import java.util.ArrayList;

public class Usuario {

	
	private String nombre;
	private String contrasenya;
	private String tarjetaPago;
	private String rutaAvatar;
	
	private ArrayList<Articulo> carro; // Compra
	private ArrayList<Compra> pedidos;
	
	
	public Usuario(String nombre, String contrasenya, String tarjetaPago, String rutaAvatar, String a2, String c, String d, int ta, boolean ad) {
		super();
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.tarjetaPago = tarjetaPago;
		this.rutaAvatar = rutaAvatar;
	}
	public Usuario() {
		super();
		this.nombre = "";
		this.contrasenya = "";
		this.tarjetaPago = "";
		this.rutaAvatar = "";
	}

	public Usuario(String nombre, String contrasenya,String tarjetaPago,String rutaAvatar) {
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.tarjetaPago = tarjetaPago;
		this.rutaAvatar = rutaAvatar;
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
		return carro;
	}


	public void setCarro(ArrayList<Articulo> carro) {
		this.carro = carro;
	}


	public ArrayList<Compra> getPedidos() {
		return pedidos;
	}



	public void setPedidos(ArrayList<Compra> pedidos) {
		this.pedidos = pedidos;
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


}
