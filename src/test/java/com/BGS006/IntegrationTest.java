package com.BGS006;

import com.BGS006.bbdd.UsuarioDB;
import com.BGS006.cliente.jdo.Usuario;
import com.BGS006.dao.UsuarioDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.jdo.PersistenceManagerFactory;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


//@RunWith(MockitoJUnitRunner.class)
public class IntegrationTest {
//
//    @Mock
//    protected static PersistenceManagerFactory pmf;
//
//    @InjectMocks
//    private UsuarioDAO u;
//
////    @Mock
////    UsuarioDB udb;
//
//    private Usuario us;
//
//    @Before
//    public void setUp() {
//        u = new UsuarioDAO();
//        //udb = new UsuarioDB();
//        us = new Usuario("suhar", "","", "");
//    }
//
//    @After
//    public void tearDown() {
//        u = null;
//      //  udb = null;
//    }
//
//    @Test
//    public void recibeUsuarioDAO() throws Exception {
//        Mockito.doThrow(new Exception()).doNothing().when(pmf).getPersistenceManager().currentTransaction().commit();
//        //doNothing().when(pmf.getPersistenceManager().currentTransaction().commit());
//        when(u.getAll()).thenReturn(Arrays.asList(us));
//        //when(u.find("suhar")).thenReturn(us);
//        assertNotNull(u.getAll());
//        //assertEquals("suhar",u.find("suhar").getNombre());
//    }
//    @Test
//    public void recibeUsuarioDB() throws Exception {
//
//        when(udb.getUsuario("alberto")).thenReturn(new Usuario("alberto", "","",""));
//
//        when(udb.LoginUsuario("suhar", "")).thenReturn(true);
//
//
//
//        assertEquals("suhar", udb.getUsuario("suhar").getNombre());
//        assertTrue(udb.LoginUsuario("suhar",""));
//
//    }

}
