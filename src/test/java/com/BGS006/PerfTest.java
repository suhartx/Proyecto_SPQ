package com.BGS006;

import com.BGS006.cliente.jdo.*;
import junit.framework.JUnit4TestAdapter;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@org.databene.contiperf.PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class PerfTest {

    private Usuario suhar;
    private Articulo a1;
    private Articulo a2;
    private Articulo a3;
    private Compra c1;

    final Logger logger = LoggerFactory.getLogger(PerfTest.class);

    static int iteration = 0;

    // If you use the EmptyReportModule, this is not generated
    //@Rule public ContiPerfRule rule = new ContiPerfRule(new EmptyReportModule());
    @Rule
    public ContiPerfRule rule = new ContiPerfRule();

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(PerfTest.class);
    }

    @Before
    public void setUp() {
        //logger.info("Entering setUp");
        logger.info("Entering setUp: {}", iteration++);

        suhar = new Usuario("suhar", "suhar","","");

        a1 = new Zapatillas("hola",20,1,"",6,5, "negro","H");
        a2 = new Calcetines("ktal",20,2,"",6,5,"rojo","h");
        a3 = new Limpiador("holakpasaktal",20,3,"",6,true);

        c1 = new Compra(1,"suhar",30);

        c1.anyadirArticulo(a1);
        suhar.addCarrito(a3);
        c1.anyadirArticulo(a2);
        suhar.addPedido(c1);

        logger.info("Leaving setUp");
    }

    @Test
    @org.databene.contiperf.PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 300)
    public void testBagMultiply() throws Exception {
        logger.info("Starting testBagMultiply");
        // {[12 CHF][7 USD]} *2 == {[24 CHF][14 USD]}
        Articulo expected = new Zapatillas("hola",20,1,"",6,5, "negro","H");
        assertEquals(expected, a1);
        assertEquals(suhar.getCarro().get(0), a3);
        assertTrue(((Limpiador)a3).isPlus());
        Thread.sleep(0);
        logger.debug("Finishing testBagMultiply");
    }



    c1.anyadirArticulo(a1);
    suhar.addCarrito(a3);
    c1.anyadirArticulo(a2);
    suhar.addPedido(c1);



}
