package com.BGS006.cliente.jdo;

import com.BGS006.PerfTest;
import org.databene.contiperf.Required;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UsuarioTest extends Usuario {

    Usuario u;
    final Logger logger = LoggerFactory.getLogger(PerfTest.class);

    @Before
    public void setUp() throws Exception {
        u = new Usuario("gorka", "gorka","","");

    }
    @Test
    public void testGetNombre() {
        assertEquals("gorka", u.getNombre());
    }

    @Test
    public void testSetNombre() {
        u.setNombre("Jose");
        assertEquals("Jose",u.getNombre());
    }

    @Test
    public void testGetContrasenya() {
        assertEquals("gorka", u.getContrasenya());
    }

    @Test
    public void testSetContrasenya() {
        u.setContrasenya("12345");
        assertEquals("12345",u.getContrasenya());
    }

    @Test
    public void testGetTarjetaPago() {
        assertEquals("",u.getTarjetaPago());
    }

    @Test
    public void testSetTarjetaPago() {
        u.setTarjetaPago("hola");
        assertEquals("hola",u.getTarjetaPago());

    }

    @Test
    public void testGetRutaAvatar() {
        assertEquals("", u.getRutaAvatar());
    }

    @Test
    public void testSetRutaAvatar() {
        u.setRutaAvatar("hola");
        assertEquals("hola",u.getRutaAvatar());
    }

    @Test
    public void testGetCarro() {
        assertNotNull(u.getCarro());
    }

    @Test
    public void testSetCarro() {
        Articulo c = new Articulo("algo", 20, 1, "",2);
        ArrayList<Articulo> a =  new ArrayList<Articulo>();
        a.add(c);
        u.setCarro(a);
        assertEquals("algo",u.getCarro().get(0).getNombre() );
    }

    @Test
    public void testGetCompras() {
        assertNotNull(u.getCompras());

    }

    @Test
    public void testSetPedidos() {
        Compra c = new Compra(1,"gorka", 100,4);
        ArrayList<Compra> a =  new ArrayList<Compra>();
        a.add(c);
        u.setPedidos(a);
        assertEquals("gorka",u.getCompras().get(0).getNombreUsuario() );

    }

    @Test
    public void testAddPedido() {
        Compra c = new Compra(2,"ibai", 100,4);
        u.addPedido(c);
        assertEquals("ibai", u.getCompras().get(0).getNombreUsuario());

    }

    @Test
    public void testAddCarrito() {
        Articulo c = new Articulo("cosas", 20, 2, "",2);

        u.addCarrito(c);
        assertEquals("cosas",u.getCarro().get(0).getNombre() );

    }

    @Test
    public void testLimpiarCarrito() {
        u.limpiarCarrito();
        assertTrue(u.getCarro().isEmpty());
    }

    @Test
    public void testEliminarArticulo() {
        Articulo c = new Articulo("cosas", 20, 2, "",2);

        u.addCarrito(c);
        u.eliminarArticulo(0);
        assertEquals(0,u.getCarro().size());
    }
    @Test
    public void testToString() {
        String expected = "Usuario{" +
                "nombre='" + u.getNombre() + '\'' +
                ", contrasenya='" + u.getContrasenya() + '\'' +
                ", tarjetaPago='" + u.getTarjetaPago() + '\'' +
                ", rutaAvatar='" + u.getRutaAvatar() + '\'' +
                '}';
        assertEquals(expected, u.toString());
    }

}