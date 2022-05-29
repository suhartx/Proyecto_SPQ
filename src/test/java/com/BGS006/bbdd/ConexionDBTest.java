package com.BGS006.bbdd;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.Statement;

import static org.junit.Assert.*;

/**
 * Clase que testea la conexion a la BD
 */
public class ConexionDBTest {

    @InjectMocks
    private ConexionDB Connectiondb;
    @Mock
    private Connection mockConnection;
    @Mock private Statement mockStatement;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test()
    {
        assertEquals(0, 0);
    }

}