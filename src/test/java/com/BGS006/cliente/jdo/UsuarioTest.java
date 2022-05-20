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
        Compra c = new Compra(1,"gorka", 100);
        ArrayList<Compra> a =  new ArrayList<Compra>();
        a.add(c);
        u.setPedidos(a);
        assertEquals("gorka",u.getCompras().get(0).getNombreUsuario() );

    }

    @Test
    public void testAddPedido() {
        Compra c = new Compra(2,"ibai", 100);
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
    @Test
    public void testQuitarArticulo() throws Exception {
        Articulo a1 = new Zapatillas("hola",20,1,"",6,5, "negro","H");
        Articulo a2 = new Calcetines("ktal",20,2,"",6,5,"rojo","h");
        Compra c1 = new Compra(1,"suhar",30);

        c1.anyadirArticulo(a1);
        c1.anyadirArticulo(a2);
        u.addPedido(c1);

        logger.info("Starting testBagMultiply");
        ArrayList<Articulo> list1 = u.getCompras().get(0).getArticulo(); //lista de articulos
        u.getCompras().get(0).quitarArticulo(a2); //quito el articulo de la compra
        assertEquals(list1.remove(list1.size()-1), u.getCompras().get(0).getArticulo());
        logger.debug("Finishing testBagMultiply");
    }
}