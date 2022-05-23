package com.BGS006.cliente.jdo;

import javax.jdo.annotations.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase donde se generan los objetos usuario
 */
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


	/**
	 * constructor básico
	 */
	public Usuario() {
		super();
		this.nombre = "";
		this.contrasenya = "";
		this.tarjetaPago = "";
		this.rutaAvatar = "";
		this.carro=new ArrayList<Articulo>();
		this.compras =new ArrayList<Compra>();
	}

	/**
	 * Constructor con parametros
	 * @param nombre
	 * @param contrasenya
	 * @param tarjetaPago
	 * @param rutaAvatar
	 */
	public Usuario(String nombre, String contrasenya,String tarjetaPago,String rutaAvatar) {
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.tarjetaPago = tarjetaPago;
		this.rutaAvatar = rutaAvatar;
		this.carro=new ArrayList<Articulo>();
		this.compras =new ArrayList<Compra>();
	}


	/**
	 * Constructor con dos paramentros
	 * @param nombre
	 * @param contrasenya
	 */
	public Usuario (String nombre, String contrasenya) {
		this.nombre = nombre;
		this.contrasenya = contrasenya;
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
	 * recibe la contraseña
	 * @return
	 */
	public String getContrasenya() {
		return contrasenya;
	}

	/**
	 * establece la contraseña
	 * @param contrasenya
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	/**
	 * recibe la tarjeta de pago
	 * @return
	 */
	public String getTarjetaPago() {
		return tarjetaPago;
	}

	/**
	 * establece la tarjeta de pago
	 * @param tarjetaPago
	 */
	public void setTarjetaPago(String tarjetaPago) {
		this.tarjetaPago = tarjetaPago;
	}

	/**
	 * recibe la ruta del avatar
	 * @return
	 */
	public String getRutaAvatar() {
		return rutaAvatar;
	}

	/**
	 * establece la ruta del avatar
	 * @param rutaAvatar
	 */
	public void setRutaAvatar(String rutaAvatar) {
		this.rutaAvatar = rutaAvatar;
	}

	/**
	 * recibe el carro
	 * @return
	 */
	public ArrayList<Articulo> getCarro() {
		return (ArrayList<Articulo>) carro;
	}

	/**
	 * establece el carro
	 * @param carro
	 */
	public void setCarro(ArrayList<Articulo> carro) {
		this.carro = carro;
	}

	/**
	 * recibe las compras
	 * @return
	 */
	public ArrayList<Compra> getCompras() {
		return (ArrayList<Compra>) compras;
	}


	/**
	 * establece los pedidos
	 * @param compras
	 */
	public void setPedidos(ArrayList<Compra> compras) {
		this.compras = compras;
	}

	/**
	 * Añade un pedido
	 * @param compra
	 */
	public void addPedido(Compra compra){
		this.compras.add(compra);
	}

	/**
	 * añade articulos a un carrito
	 * @param a
	 */
	public void addCarrito(Articulo a) {
		if(a !=null) {
			carro.add(a);
		}
	}

	/**
	 * limpia el carro
	 */
	public void limpiarCarrito() {
		carro.clear();
	}

	/**
	 * elimina articulos del carro
	 * @param id
	 */
	public  void eliminarArticulo(int id) {
		Articulo f = carro.remove(id);
	}

	/**
	 * compara dos usuarios
	 * @param u
	 * @return
	 */
	public int compareTo(Usuario u) {
		return u.nombre.compareTo(this.nombre);
	}


	/**
	 * Muestra todos lo datos del usuario
	 * @return
	 */
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
