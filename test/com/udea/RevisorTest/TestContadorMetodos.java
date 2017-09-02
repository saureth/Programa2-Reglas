package com.udea.RevisorTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.udea.principal.ContadorMetodos;
import com.udea.principal.ContarLineas;

public class TestContadorMetodos 
{
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void TestContarMetodosDeUnaClase() {
		int resultado = ContadorMetodos.ContarMetodos("public class Casa {}");
		assertTrue(resultado==0);
	}
}
