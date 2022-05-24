package com.BGS006.cliente.jdo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZapatillasTest {
    Zapatillas z;


    @Before
    public void setUp() throws Exception {
        z = new Zapatillas("z", 20.0, 123, "" , 4, 10,"rojo", "hombre");
    }

    @Test
    public void testGetNombre() {
        assertEquals("z", z.getNombre());
    }

    @Test
    public void testSetNombre() {
        z.setNombre("z2");
        assertEquals("z2",z.getNombre());
    }

    @Test
    public void testGetID(){
        assertEquals(123, z.getId());

    }

    @Test
    public void testSetID( ) {
        z.setId(321);
        assertEquals(321, z.getId());
    }

    @Test
    public void testGetStock(){
        assertEquals(4, z.getStock());

    }

    @Test
    public void testSetStock( ) {
        z.setStock(10);
        assertEquals(10, z.getStock());
    }

    @Test
    public void testGetTalla(){
        assertEquals(10, z.getTalla());

    }

    @Test
    public void testSetTalla( ) {
        z.setTalla(20);
        assertEquals(20, z.getTalla());
    }

    @Test
    public void testGetColor() {
        assertEquals("rojo", z.getColor());
    }

    @Test
    public void testSetColor() {
        z.setColor("azul");
        assertEquals("azul", z.getColor());
    }

    @Test
    public void testGetGenero() {
        assertEquals("hombre", z.getGen());
    }

    @Test
    public void testSetGenero() {
        z.setGen("mujer");
        assertEquals("mujer", z.getGen());
    }

}
