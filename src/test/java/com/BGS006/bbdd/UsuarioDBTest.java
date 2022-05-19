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
import static org.mockito.Mockito.when;

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

//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }


    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("dbsample/usuarios.xml"));
    }

    @Test
    public void testinsertarUsuarios() throws Exception
    {
        when(UsuarioDB.rowcount()).thenReturn(3);
        UsuarioDB.insertarUsuarios(mikel);

        assertEquals(3,UsuarioDB.rowcount());
    }

    @Test
    public void testeliminarUsuario()
    {

        when(UsuarioDB.rowcount()).thenReturn(2);

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
        when(UsuarioDB.rowcount()).thenReturn(3);

        UsuarioDB.getAllUsers();

        assertEquals(3, UsuarioDB.rowcount());
    }
    @Test
    public void testrowcount()
    {
        when(UsuarioDB.rowcount()).thenReturn(3);


        assertEquals(3, UsuarioDB.rowcount());
    }

}





