package com.BGS006.cliente.jdo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LimpiadorTest {

    Limpiador l,l2;


    @Before
    public void setUp() throws Exception {
        l = new Limpiador("lim", 250.0, 1234, "ruta" , 12, true);
        l2 = new Limpiador("lim2", 150.0, 5678, "ruta2" , 9, false);

    }

    @Test
    public void testGetTalla(){
        assertTrue(l.isPlus());

    }

    @Test
    public void testSetTalla() {
        l2.setPlus(true);
        assertTrue(l2.isPlus());
    }

}
