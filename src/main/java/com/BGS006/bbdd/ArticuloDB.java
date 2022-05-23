package com.BGS006.bbdd;

import com.BGS006.cliente.jdo.Articulo;

import java.sql.*;
import java.util.TreeMap;

public class ArticuloDB {

    /**
     * Método que inserta en la base de datos el artículo pasado por parámetro
     * @param nuevoarticulo
     */
    public static void insertarArticulo(Articulo nuevoarticulo) {
        Statement st = null;
        Connection con = ConexionDB.Conexion();
        String query = "INSERT INTO ARTICULO VALUES('" + nuevoarticulo.getNombre() + "',"+nuevoarticulo.getPrecio()+",'"+nuevoarticulo.getRutaImagen()+"')";

        try {
            st = con.createStatement();
            st.executeUpdate(query);

            System.out.println("Insert articulo existoso");

        } catch (Exception e) {
            System.out.println("ERROR al insertar el articulo");
            System.out.println(e);
        }
    }

    /**
     * Método que elimina el artículo pasado por parámetro en caso de estar en la base de datos
     * @param a
     */
    public static void eliminarArticulo(Articulo a) {

        Statement st = null;
        Connection con = ConexionDB.Conexion();
        String query = "DELETE FROM ARTICULO WHERE NOMBRE = '" + a.getNombre() + "'";

        try {
            st = con.createStatement();
            st.executeUpdate(query);
            System.out.println("Se elimino el articulo correctamente");


        } catch (SQLException e) {

            System.out.println("No se pudo eliminar el articulo");
            System.out.println(e);
        }

    }

    /**
     * Método que muestra todos los artículos en la base de datos
     * @param con
     * @return mapa con los artículos
     */
    public static TreeMap<String, Articulo> cargarMapaArticulosDeInfoBBDD(Connection con) {
        TreeMap<String, Articulo> tmArticulos = new TreeMap<>();
        Statement stmt = null;

        String sentSQL = "SELECT * FROM ARTICULO";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sentSQL);
            while(rs.next()) {
                String nombre = rs.getString("NOMBRE");
                double precio = rs.getDouble("PRECIO");
                String ruta = rs.getString("RUTAIMAGEN");
                String id = "";
                int stock = 0;
                //Articulo a = new Articulo(nombre, precio,id, ruta, stock);
                //tmArticulos.put(nombre, a);

            }
            rs.close();
            stmt.close();

        } catch (Exception e) {
        } finally {
            if(stmt!=null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            }
        }
        return tmArticulos;
    }

    /**
     * This is the method that shows the quantity of Users in the database
     * @return número de usuarios en la base de datos
     */
    public static int rowcount () {
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        int count=0;
        try {
            String query = "SELECT * FROM ARTICULO";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                count++;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return count;
    }
}
