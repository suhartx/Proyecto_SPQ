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

        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();

        try {
            String query = " INSERT INTO COMPRA_ARTICULOS (IDCOMPRA_OID, NOMBRE_EID, IDX)"
                    + " VALUES (?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);
            preparedStatement.setLong(1, nuevaCompra.getIdCompra());
            preparedStatement.setString(2, nuevaCompra.getNombreUsuario());
            preparedStatement.setDouble(3, nuevaCompra.getPrecio());
            preparedStatement.execute();

            System.out.println("Insert compra existosa");

        } catch (Exception e) {
            System.out.println("ERROR al insertar la compra");
            System.out.println(e);
        }
    }

    /**
     * This method is used to delete compras from the database using the ID as parameter
     * @param ID
     */
    public static void eliminarCompra(Long id) {

        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();

        try {

            String query = "DELETE FROM ARTICULO WHERE IDCOMPRA_OID = '" + id + "'";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();

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

                Compra c = new Compra(id,usuario,precio);

                tmCompras.put(id, c);
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


}
