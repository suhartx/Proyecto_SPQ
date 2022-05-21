package com.BGS006;

import com.BGS006.cliente.jdo.*;
import junit.framework.JUnit4TestAdapter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CoverTest {

    Articulo art;
    Calcetines cal;
    Color col;
    Compra compra;
    Genero gen;
    Limpiador l;
    Usuario us;
    Zapatillas zap;
    ArrayList arts;


    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(CoverTest.class);
    }


    @Before
    public void setUp() {

        arts = new ArrayList<Articulo>();

        art = new Articulo("Articulo", 42,1, null,5);
        Articulo art2 = new Articulo("Articulo 2", 43,2,  null,5);
        arts.add(art);
        arts.add(art2);
        cal = new Calcetines("Calcetin 1", 32, 1,  "", 5);
        compra = new Compra(arts, art.getPrecio() + art2.getPrecio());
        l = new Limpiador("Limpiador Plus", 10,1, "", 5);
        zap = new Zapatillas("Zap 1", 45, 1,  "", 5);
        us = new Usuario("Ibai", "Test");

    }

    @Test
    public void testArticulo() {
        // art = new Articulo("Articulo", 42, null);
        assertEquals("Articulo", art.getNombre());
        assertEquals(42, art.getPrecio(), 0);
        assertNull(art.getRutaImagen());

        Articulo a = new Articulo();
        a.setNombre("Art");
        a.setPrecio(5);
        a.setRutaImagen("H");

        assertEquals("Art", a.getNombre());
        assertEquals(5, a.getPrecio(), 0);
        assertEquals("H", a.getRutaImagen());

    }

    @Test
    public void testCalcetines() {
         cal = new Calcetines("Calcetin 1", 4,1, "", 5);

        Calcetines cal2 = new Calcetines("Cal 2", 4,1, null, 5);
        assertEquals("Cal 2", cal2.getNombre());
        assertEquals(4, cal2.getPrecio(), 0);
        assertNull(cal2.getRutaImagen());

        cal.setNombre("Cal");
        cal.setPrecio(2);
        cal.setGen("S");
        cal.setColor("Amarillo");
        cal.setRutaImagen("Aqui");
        cal.setTalla(34);

        assertEquals("Cal", cal.getNombre());
        assertEquals(2, cal.getPrecio(), 0);
        assertEquals("Aqui", cal.getRutaImagen());
        assertEquals(34, cal.getTalla(), 0);
        assertEquals("Amarillo", cal.getColor());
        assertEquals("S", cal.getGen());

    }

    @Test
    public void testColor() {

        col = Color.BLANCO;
        assertEquals(Color.BLANCO, col);
    }

    @Test
    public void testLimpiador() {
         l = new Limpiador("Limpiador Plus", 5,5, "",6);
        Limpiador l2 = new Limpiador("L2", 5,5, null,6);

        assertEquals("L2", l2.getNombre());
        assertEquals(5, l2.getPrecio(),0);
        assertNull(l2.getRutaImagen());

        l.setNombre("L");
        l.setPrecio(2);
        l.setPlus(true);
        l.setRutaImagen("Aqui");

        assertTrue(l.isPlus());
        assertEquals("L", l.getNombre());
        assertEquals(2, l.getPrecio(), 0);
        assertEquals("Aqui", l.getRutaImagen());

    }

    @Test
    public void testZapatillas() {
        //zap = new Zapatillas("Zap 1", 45, null, 43, "Blanco", "H");
        Zapatillas zap2 = new Zapatillas("Zap2", 1,2, "", 6);

        assertEquals("Zap2", zap2.getNombre());
        assertEquals(1, zap2.getPrecio(), 0);

        zap.setGen("H");
        zap.setNombre("Zap 2");
        zap.setColor("Negro");
        zap.setPrecio(13);
        zap.setRutaImagen(null);
        zap.setTalla(34);

        assertEquals("Zap 2", zap.getNombre());
        assertEquals(13, zap.getPrecio(), 0);
        assertNull(zap.getRutaImagen());
        assertEquals(34, zap.getTalla(), 0);
        assertEquals("Negro", zap.getColor());
        assertEquals("H", zap.getGen());


    }

    @Test
    public void testGenero() {

        gen = Genero.H;
        assertEquals(Genero.H, gen);

    }

    @Test
    public void testUsuario() {

        // us = new Usuario("Ibai", "Test");
        Usuario user = new Usuario();
        Usuario user2 = new Usuario("Nombre", "Contra", "5555","");
        Usuario user3 = new Usuario("Name", "hola", "55555", null);

        ArrayList compras = new ArrayList<Compra>();
        compras.add(compra);

        us.setCarro(arts);
        us.setPedidos(compras);
        us.setNombre("Test");
        us.setContrasenya("Hola");
        us.setTarjetaPago("1234");
        us.setRutaAvatar("Home");

        assertEquals(arts, us.getCarro());
        assertEquals(compras, us.getCompras());
        assertEquals("Test", us.getNombre());
        assertEquals("Hola", us.getContrasenya());
        assertEquals("1234", us.getTarjetaPago());
        assertEquals("Home", us.getRutaAvatar());

    }

    @Test
    public void testCompra() {

        // art = new Articulo("Articulo", 42, null);
        //Articulo art2 = new Articulo("Articulo 2", 43, null);
        //compra = new Compra(arts, art.getPrecio() + art2.getPrecio());

       Compra newComp = new Compra (5, "Ibai", 55,6);
        newComp.setArticulos(arts);
        assertEquals(compra.getArticulo(), arts);
        assertEquals(compra.getIdCompra(), 5);
        assertEquals(compra.getNumArticulo(), 2);
        assertEquals(compra.getPrecio(), 85, 0);
        assertEquals(newComp.getNombreUsuario(), "Ibai");

        compra.quitarArticulo(art);
        compra.anyadirArticulo(art);

        assertEquals(compra.getArticulo(), arts);
        compra.setIdCompra(0);
        assertEquals(compra.getIdCompra(), 0);

        compra.setPrecio(50.0);
        assertEquals(compra.getPrec(), 50, 0);


    }


}
