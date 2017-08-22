package com.udea.RevisorTest;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.udea.principal.LectorArchivos;

public class TestLineas {

	@Test
	public void TestArchivoNulo() 
	{
		LectorArchivos la = new LectorArchivos();
		List<String> codigo = la.AbrirArchivo("fadsa");
		assertTrue(codigo==null);
	}

	@Test
	public void TestArchivoNoNulo() 
	{
		LectorArchivos la = new LectorArchivos();
		List<String> codigo = la.AbrirArchivo("p1");
		assertTrue(codigo!=null);
	}
	
}
