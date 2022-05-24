package com.BGS006.bbdd;

import com.BGS006.cliente.jdo.Articulo;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;
import org.mockito.Mock;

import java.io.FileInputStream;
import java.sql.Connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ArticuloDBTest {

    public ArticuloDBTest() {
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
    private Articulo a = new Articulo("Nike 1", 28.45,  0, "ruta", 0);


//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }


    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("dbsample/articulos.xml"));
    }

    @Test
    public void testInsertarArticulo() throws Exception
    {
        ArticuloDB.insertarArticulo(a);
        assertEquals(3,ArticuloDB.rowcount());
    }

    @Test
    public void testEliminarCompra()
    {
//        ArticuloDB.insertarArticulo(a);
//        ArticuloDB.eliminarArticulo(a);
//        assertEquals(0,UsuarioDB.rowcount());
    }

    @Test
    public void testrowcount()
    {
        int data = ArticuloDB.rowcount();
        assertEquals(3, data);
    }

}
