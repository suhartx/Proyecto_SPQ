package com.BGS006.bbdd;

import com.BGS006.cliente.jdo.Compra;
import com.BGS006.cliente.jdo.Usuario;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;
import org.mockito.Mock;

import java.io.FileInputStream;
import java.sql.Connection;

import static org.junit.Assert.assertEquals;

public class CompraDBTest {

    public CompraDBTest() {
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
    private Compra c = new Compra(5,"alberto",25.55);

//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }


    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("dbsample/compras.xml"));
    }

    @Test
    public void testInsertarCompra() throws Exception
    {
        ComprasDB.insertarCompra(c);
        assertEquals(0,ComprasDB.rowcount());
    }

    @Test
    public void testEliminarCompra()
    {
        //ComprasDB.eliminarCompra(c);
        assertEquals(0,UsuarioDB.rowcount());
    }



}
