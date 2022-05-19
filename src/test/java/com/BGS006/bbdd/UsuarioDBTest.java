package com.BGS006.bbdd;

import com.BGS006.cliente.jdo.Usuario;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;
import org.mockito.Mock;

import java.io.FileInputStream;
import java.sql.Connection;

import static org.junit.Assert.*;

public class UsuarioDBTest {

    public UsuarioDBTest() {


        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/deustosneakerdb");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "spq");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "spq");
    }

    @Mock
    private Connection con = ConexionDB.Conexion();
    @Mock
    private Usuario mikel = new Usuario("mikel", "mikel","","");

    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("dbsample/usuarios.xml"));
    }

    @Test
    public void testinsertarUsuarios() throws Exception
    {
        UsuarioDB.insertarUsuarios(mikel);

        assertEquals(3,UsuarioDB.rowcount());
    }

    @Test
    public void testeliminarUsuario()
    {
        UsuarioDB.eliminarUsuario(mikel.getNombre());

        assertEquals(2,UsuarioDB.rowcount());
    }

    @Test
    public void testLoginUsuario()
    {
        assertEquals(false, false);
    }

    @Test
    public void testgetUsuario()
    {

        Usuario data= UsuarioDB.getUsuario("jose");

        assertEquals(data ,data);
    }

    @Test
    public void testgetAllUsers()
    {
        UsuarioDB.getAllUsers();

        assertEquals(3, UsuarioDB.rowcount());
    }
    @Test
    public void testrowcount()
    {
        int data = UsuarioDB.rowcount();

        assertEquals(2, data);
    }

}





