package org.BGS006.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {

	/**
	 * This method is used to connect with the database
	 * @return
	 */
    public static Connection Conexion() {

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Lo que esta entre parentesis igual que el  datanuclus, user, password (Si uso puerto )
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deustosneakerdb", "spq", "spq");
            System.out.printf("Conexion lograda");

        } catch (Exception e) {

            System.out.println("Fallo crítico");

        }

        return con;
    }
    
    /**
     * This method is used to execute the query
     * @param query
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int executeQuery(String query) throws ClassNotFoundException, SQLException {
    	Connection con = Conexion();
    	return con.createStatement().executeUpdate(query);
    }
    //SUSTITUIR PRODUCTO POR ARTICULO
    /**
     * This method is used to insert the products into the database
     * @param nuevoProducto
     */
//    public void InsertarProducto(Producto nuevoProducto) {
//        ProductoDB.insertarProducto(nuevoProducto);
//    }
}
