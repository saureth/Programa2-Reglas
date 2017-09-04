package com.udea.RevisorTest;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;

import com.udea.principal.ContarClases;
import com.udea.principal.LectorArchivos;

public class TestContarClases {

	@Test
	public void TestNulo() 
	{
		ContarClases ca = new ContarClases();
		int cantidad = ca.Contar("");
		assertTrue(cantidad == -1);
	}
	
	@Test
	public void TestNoEncontrado() 
	{
		ContarClases ca = new ContarClases();
		int cantidad = ca.Contar("../../../../../../asdasdasasd");
		assertTrue(cantidad == -1);
	}
	
	@Test
	public void TestCantidadEsCero() 
	{
		ContarClases ca = new ContarClases();
		int cantidad = ca.Contar("./bin/");
		assertTrue(cantidad == 0);
	}
	
	@Test
	public void TestCantidadMayorCero() 
	{
		ContarClases ca = new ContarClases();
		int cantidad = ca.Contar("./src/com/udea/principal");
		assertTrue(cantidad > 0);
	}
	
}