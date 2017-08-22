package com.udea.RevisorTest;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.udea.principal.Clasificador;
import com.udea.principal.LectorArchivos;
import com.udea.principal.TipoLinea;

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
	
	@Test
	public void TestClasificadorNulo() 
	{
		Clasificador miClasi = new Clasificador();
		assertTrue(miClasi.ClasificarLinea("")==TipoLinea.nulo);
	}	
	
	@Test
	public void TestClasificadorLibreria() 
	{
		Clasificador miClasi = new Clasificador();
		assertTrue(miClasi.ClasificarLinea("import java.io.*;")==TipoLinea.libreria);
	}	
	
	@Test
	public void TestClasificadorVariable1() 
	{
		Clasificador miClasi = new Clasificador();
		assertTrue(miClasi.ClasificarLinea("int x = 0;")==TipoLinea.variable);
	}	
	
	/*@Test
	public void TestClasificadorVariable2() 
	{
		Clasificador miClasi = new Clasificador();
		assertTrue(miClasi.ClasificarLinea("int x = 0; //hola ")==TipoLinea.variable);
	}	*/
	
	@Test
	public void TestClasificadorVariable3() 
	{
		Clasificador miClasi = new Clasificador();
		System.out.println(miClasi.ClasificarLinea("public int x = 0;"));
		assertTrue(miClasi.ClasificarLinea("public int x = 0;")==TipoLinea.variable);
	}		
	
	@Test
	public void TestAllanaComillasNulo() 
	{
		Clasificador miClasi = new Clasificador();
		assertTrue(miClasi.AllanarComillas("").equals(""));
	}	
	
	@Test
	public void TestAllanaComillasSinComillas() 
	{
		Clasificador miClasi = new Clasificador();
		assertTrue(miClasi.AllanarComillas("asd f").equals("asd f"));
	}	
	
	@Test
	public void TestAllanaComillasAbreCierra() 
	{
		Clasificador miClasi = new Clasificador();
		assertTrue(miClasi.AllanarComillas("asdas\"1234\" dads").equals("asdas dads"));
	}	
	
}
