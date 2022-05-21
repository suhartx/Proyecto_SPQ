package com.BGS006.bbdd;



import com.BGS006.cliente.jdo.Compra;

import java.sql.*;
import java.util.TreeMap;

public class ComprasDB {

    /**
     * This is the method that inserts Compras into the database
     * @param nuevaCompra
     */
    public static void insertarCompra(Compra nuevaCompra) {
        Statement st = null;
        Connection con = ConexionDB.Conexion();
        String query = "INSERT INTO COMPRA VALUES(" + nuevaCompra.getIdCompra() + ","+nuevaCompra.getNumArticulo()+","+nuevaCompra.getPrecio()+",'"+nuevaCompra.getNombreUsuario()+"',"+ 0 +")";

        try {
            st = con.createStatement();
            st.executeUpdate(query);

            System.out.println("Insert compra existosa");

        } catch (Exception e) {
            System.out.println("ERROR al insertar la compra");
            System.out.println(e);
        }
    }

    /**
     * This method is used to delete compras from the database using the ID as parameter
     * @param
     */
    public static void eliminarCompra(Compra c) {

        Statement st = null;
        Connection con = ConexionDB.Conexion();
        String query = "DELETE FROM Compra WHERE idCompra = '" + c.getIdCompra() + "'";

        try {
            st = con.createStatement();
            st.executeUpdate(query);
            System.out.println("Se elimino la compra correctamente");


        } catch (SQLException e) {

            System.out.println("No se pudo eliminar la compra");
            System.out.println(e);
        }

    }

    /**
     * M todo que obtiene un mapa con los Articulos de la BBDD
     * @param con Conexion con la BBDD
     * @return TreeMap<String,Articulo>
     */
    public static TreeMap<Long, Compra> cargarMapaComprasDeInfoBBDD(Connection con) {
        TreeMap<Long, Compra> tmCompras = new TreeMap<>();
        Statement stmt = null;

        String sentSQL = "SELECT * FROM COMPRA_ARTICULOS";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sentSQL);
            while(rs.next()) {
                long id = rs.getLong("IDCOMPRA_OID");
                String usuario = rs.getString("NOMBRE_EID");
                double precio = rs.getDouble("IDX");

                //Compra c = new Compra(id,usuario,precio);

                //tmCompras.put(id, c);
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
        return tmCompras;
    }

    /**
     * This is the method that shows the quantity of Users in the database
     * @return
     */
    public static int rowcount () {
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        int count=0;
        try {
            String query = "SELECT * FROM COMPRA_ARTICULOS";
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
