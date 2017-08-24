package com.udea.RevisorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.udea.principal.ContarLineas2;
import com.udea.principal.Reglas;
import com.udea.principal.TipoRespuesta;

public class TestLineas2 
{
	@Test
	public void TestLineaVacia()
	{
		int tr = ContarLineas2.ValorLinea("");
		assertTrue(tr == 0);
	}
	@Test
	public void TestLineaTab()
	{
		int tr = ContarLineas2.ValorLinea("\t");
		assertTrue(tr == 0);
	}
	@Test
	public void TestLineaEspacio()
	{
		int tr = ContarLineas2.ValorLinea(" ");
		assertTrue(tr == 0);
	}
	@Test
	public void TestLineaEspaciosLlave()
	{
		int tr = ContarLineas2.ValorLinea("      }");
		assertTrue(tr == 0);
	}
	@Test
	public void TestLineaTabsLlave()
	{
		int tr = ContarLineas2.ValorLinea("\t\t\t}");
		assertTrue(tr == 0);
	}
	
	@Test
	public void TestComentario()
	{
		int tr = ContarLineas2.ValorLinea("//Comentario");
		assertTrue(tr == 0);
	}

	@Test
	public void TestCicloFor()
	{
		int tr = ContarLineas2.ValorLinea("for(int i = 0; i<50;i++)");
		assertTrue(tr == 3);
	}
	
	@Test
	public void TestCondiciones()
	{
		int tr = ContarLineas2.ValorLinea("if(a==b)");
		assertTrue(tr == 1);
	}
}
