package com.BGS006.cliente.jdo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcetinesTest {

    Calcetines c;


    @Before
    public void setUp() throws Exception {
        c = new Calcetines("c", 20.0, 1, "ruta" , 4, 10,"rojo", "hombre");
    }

    @Test
    public void testGetTalla(){
        assertEquals(10, c.getTalla());

    }

    @Test
    public void testSetTalla( ) {
        c.setTalla(20);
        assertEquals(20, c.getTalla());
    }

    @Test
    public void testGetColor() {
        assertEquals("rojo", c.getColor());
    }

    public void testSetColor(String color) {
        c.setColor("azul");
        assertEquals("azul", c.getColor());
    }

    public void testGetGen() {

            assertEquals("hombre", c.getGen());


    }

    public void setGen(String gen) {
        c.setGen("mujer");
        assertEquals("mujer", c.getGen());
    }
}
