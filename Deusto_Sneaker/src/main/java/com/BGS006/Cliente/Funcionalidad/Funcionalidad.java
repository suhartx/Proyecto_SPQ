package com.BGS006.Cliente.Funcionalidad;

	//Arraylist
	public class Funcionalidad {
		private static Funcionalidad instance;

		public static Funcionalidad getInstance() {
			if (instance == null) {
				instance = new Funcionalidad();
			}

			return instance;
		}

		public void Holamundo() {
			System.out.println("Hola mundo");
		}
		public void CrearUsuario() {
			System.out.println("Usuario creado");
		}
		public void BorrarUsuario(String nombre) {
			System.out.println("Usuario borrado");
			
		}
}
