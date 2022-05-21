package com.BGS006.bbdd;

import com.BGS006.cliente.jdo.Usuario;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

//    @InjectMocks
//    private ConexionDB Connectiondb;
    @Mock
    private Connection con = ConexionDB.Conexion();
    @Mock
    private Usuario mikel = new Usuario("mikel", "mikel","","");
    private Usuario alberto = new Usuario("alberto", "alberto","","");

//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }


    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("dbsample/usuarios.xml"));
    }

    @Test
    public void testInsertarUsuarios() throws Exception
    {
        UsuarioDB.insertarUsuario2(mikel);
        assertNotEquals(0,UsuarioDB.rowcount());
        int count = UsuarioDB.rowcount();
        System.out.println("Total usuarios: "+ count);
    }

    @Test
    public void testEliminarUsuario()
    {
       UsuarioDB.eliminarUsuario(mikel);
       assertEquals(2,UsuarioDB.rowcount());
       int count = UsuarioDB.rowcount();
       System.out.println("Total usuarios: "+ count);
    }

    @Test
    public void testLoginUsuario()
    {
        boolean login = UsuarioDB.LoginUsuario(mikel.getNombre(),mikel.getContrasenya());
        assertTrue(login);
    }

    @Test
    public void testgetUsuario()
    {
        Usuario data= UsuarioDB.getUsuario("mikel");
        assertEquals(data ,data);
    }

    @Test
    public void testgetAllUsers()
    {
        UsuarioDB.getAllUsers();
        assertNotEquals(0, UsuarioDB.rowcount());
    }
    @Test
    public void testrowcount()
    {
        int data = UsuarioDB.rowcount();
        assertEquals(0, data);
    }

}





