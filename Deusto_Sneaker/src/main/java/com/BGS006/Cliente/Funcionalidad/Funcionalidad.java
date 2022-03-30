package com.BGS006.Cliente.Funcionalidad;

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
}
