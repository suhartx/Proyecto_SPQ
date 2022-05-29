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


/**
 * Clase que testea los usuarios en la BD
 */
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
        UsuarioDB.insertarUsuarios(mikel);

        assertEquals(2,UsuarioDB.rowcount());
    }

    @Test
    public void testeliminarUsuario()
    {
        UsuarioDB.eliminarUsuario(mikel);
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

        assertEquals(2, UsuarioDB.rowcount());
    }
    @Test
    public void testrowcount()
    {
        int data = UsuarioDB.rowcount();

        assertEquals(2, data);
    }
    @Test
    public void testCambiarPassword()
    {
        UsuarioDB.cambiarPassword(con,mikel.getNombre(), "mikel2");
        String contraenaNueva = UsuarioDB.getUsuario("mikel").getContrasenya();
        assertEquals("mikel2", contraenaNueva);
    }

}




