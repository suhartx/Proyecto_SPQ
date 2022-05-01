package org.BGS006.database;

import org.BGS006.cliente.jdo.Usuario;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDB {

	public static boolean correcto;
	
    public static Usuario u = new Usuario();

    /**
     * This is the method that inserts Users into the database
     * @param nuevoUsuario
     */
    public static void insertarUsuarios(Usuario nuevoUsuario) {
       
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        
        try {
            String query = " INSERT INTO USUARIO (NOMBRE, CONTRASENYA, RUTAAVATAR, TARJETAPAGO)"
                    + " VALUES (?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, nuevoUsuario.getNombre());
            preparedStatement.setString(2, nuevoUsuario.getContrasenya());
            preparedStatement.setString(3, nuevoUsuario.getRutaAvatar());
            preparedStatement.setString(4, nuevoUsuario.getTarjetaPago());
//            preparedStatement.setString(5, nuevoUsuario.getApellido1());
//            preparedStatement.setString(6, nuevoUsuario.getApellido2());
//            preparedStatement.setString(7, nuevoUsuario.getDireccion());
//            preparedStatement.setInt(8, nuevoUsuario.getTarjetaCredito());
//            preparedStatement.setBoolean(9, nuevoUsuario.isAdmin());
            preparedStatement.execute();

            System.out.println("Insert existoso");

        } catch (Exception e) {
            System.out.println("ERROR al insertar el usuario");
            System.out.println(e);
        }
    }


    /**
     * This method is used to delete users from the database using the mail as parameter
     * @param nombre
     */
    public static void eliminarUsuario(String nombre) {

        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();

        try {

            String query = "DELETE FROM USUARIO WHERE NOMBRE = '" + nombre + "'";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {

            System.out.println("No se pudo eliminar el usuario");
            System.out.println(e);
        }

    }
    
    /**
     * Method used to log the User
     * @param nombre
     * @param contrasenya
     * @return
     */
    public static boolean LoginUsuario(String nombre, String contrasenya) {
    	
    	correcto = false;
        boolean comprobar = false;

        try {
            PreparedStatement preparedStatement;
            Connection con = ConexionDB.Conexion();

            String query = "SELECT CONTRASENYA FROM USUARIO WHERE NOMBRE = '" + nombre + "'";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                if (resultSet.getString("CONTRASENYA").equals(contrasenya)) {
                    System.out.println("Si");
                    u.setNombre(nombre);
                    System.out.println(u.getNombre());
                    if (getUsuario(nombre).equals("admin")) {
                        //Tengo que hacer el enable del boton Administrar
                        System.out.println("Es Admin");
                    } else {
                        System.out.println("No es admin");
                    }
                    comprobar = true;
                    break;
                } else {
                    System.out.println("Contrasenya Incorrecta");
                    JOptionPane.showMessageDialog(null, "NOMBRE O CONTRASENYA INCORRECTAS");
                }
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un ERROR");
            System.out.println(e);
        }
        if (comprobar == true) {
            System.out.println("Existe y la contrasenya concuerda,permitir el logeo");

           correcto = true;
           //MainVShop.main(null);
            //SUSTITUIR ESTO CON EL SIGUIENTE CON ABRIR LA VENTANA
            //POSIBLEMENTE SEA NECESARIO GUARDAR DATOS DE USUARIO

        } else {
            System.out.println("Problema de conexion");
        }
        //Unicamente para ver que esto es cierto
        return comprobar;
    }

    
    /**
     * Method used to get a signed in user
     * @param nombre
     * @return
     */
    public static Usuario getUsuario(String nombre) {
        Usuario user = new Usuario();
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        try {
            String query = "SELECT NOMBRE,CONTRASENYA FROM USUARIO WHERE NOMBRE = '" + nombre + "'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                    if (resultSet.getString("NOMBRE").equals(nombre)) {
                    user.setNombre(nombre);
                    user.setContrasenya(resultSet.getString("CONTRASENYA"));
                } else {
                    System.err.println("No hay usuario asi");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(user.getNombre());
        System.out.println(user.getContrasenya());
        return user;
    }

    /**
     * Method used to recover all the users
     * @param usuarioslist
     */
    public static void getAllUsers (ArrayList<Usuario>usuarioslist) {
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();

        try {
            String query = "SELECT * FROM USUARIO";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {

            	String nom = resultSet.getString("NOMBRE");
            	String cont = resultSet.getString("CONTRASENYA");
            	String rut = resultSet.getString("RUTAAVATAR");
            	String tar = resultSet.getString("TARJETAPAGO");

                Usuario n1= new Usuario(nom,cont,tar,rut);
                System.out.println(n1.toString());

                usuarioslist.add(n1);
            }
            for (int i = 1; i <usuarioslist.size(); i++) {
                System.out.println("Vuelta n: "+i);

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
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
            String query = "SELECT * FROM USUARIO";
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
