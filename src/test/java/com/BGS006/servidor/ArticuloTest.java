package com.BGS006.servidor;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import javax.sound.sampled.BooleanControl;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Clase con test de rendimiento de articulos
 */
public class ArticuloTest {

    @Rule
    public ContiPerfRule rule = new ContiPerfRule();

    private static HttpServer server;
    private static WebTarget target;

    @BeforeClass
    public static void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    /**
     * Test para obtener el tiempo de ejecucion para obtener articulos
     */
    @Test
    @PerfTest(invocations = 200, threads = 55)
    public void testGetUsersPerformance() {
        GenericType<List<Articulo>> genericType = new GenericType<List<Articulo>>() {};
        List<Articulo> articles = target.path("articulos/verArticulos").request(MediaType.APPLICATION_JSON).get(genericType);
        assertEquals(0, articles.size());
    }
    @AfterClass
    public static void tearDown() throws Exception {
        server.stop();
    }

}
