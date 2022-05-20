package com.BGS006.cliente.jdo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArticuloTest {

    Articulo a1;


    @Before
    public void setUp() throws Exception {
        a1 = new Zapatillas("zapatillas",20.0,1,"ruta",6,5, "negro","H");
    }


    @Test
    public void testGetNombre() {
        assertEquals("zapatillas", a1.getNombre());
    }


    @Test
    public void testSetNombre() {
        a1.setNombre("zapatillas2");
        assertEquals("zapatillas2", a1.getNombre());
    }

    @Test
    public void testGetPrecio() {
        double precio = 20.0d;
        assertEquals(precio, a1.getPrecio(), 0.001);
    }

    @Test
    public void testSetPrecio() {
        a1.setPrecio(21.0d);
        assertEquals(21.0d, a1.getPrecio(), 0.001);
    }

    @Test
    public void getRutaImagen() {
        String ruta = "ruta";
        assertEquals(ruta, a1.getRutaImagen());
    }


    public void setRutaImagen( ) {
        a1.setRutaImagen("RutaNueva");
        assertEquals("RutaNueva", a1.getRutaImagen());
    }

    public void getId() {
        long id = 1;
        assertEquals(id, a1.getId());
    }


    public void setId(long id) {
        a1.setId(2);
        assertEquals(2, a1.getId());
    }

    public void getStock() {
        long id = 6;
        assertEquals(id, a1.getId());
    }


    public void setStock(int stock) {
        a1.setStock(8);
        assertEquals(8, a1.getId());
    }
}
