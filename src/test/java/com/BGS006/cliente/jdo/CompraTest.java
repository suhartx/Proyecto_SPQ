package com.BGS006.cliente.jdo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CompraTest {

    Compra c;
    Articulo a,a2;

    @Before
    public void setUp() throws Exception {
        c = new Compra(123,"alberto",25.55,2);
        a = new Articulo("a1",10.99,222,"",20);
        a2 = new Articulo("a2",10.99,333,"",20);
    }

    @Test
    public void testGetId() {
        long id = 123;
        assertEquals(id, c.getIdCompra(), 0.001);
    }

    @Test
    public void testSetId() {
        c.setIdCompra(222);
        assertEquals(222, c.getIdCompra(), 0.001);
    }


    @Test
    public void testGetNombreUsuario() {
        assertEquals("alberto", c.getNombreUsuario());
    }


    @Test
    public void testSetNombreUsuario() {
        c.setNombreUsuario("alberto2");
        assertEquals("alberto2", c.getNombreUsuario());
    }

    @Test
    public void anyadirArticulo(){
        c.anyadirArticulo(a);
        c.anyadirArticulo(a2);
        assertEquals(c.getNumArticulo(),2);
    }


}
