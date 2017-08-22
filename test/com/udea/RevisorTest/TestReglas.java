package com.udea.RevisorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.udea.principal.Reglas;
import com.udea.principal.TipoRespuesta;


public class TestReglas 
{

	@Test
	public void TestVariable1()
	{
		TipoRespuesta tr = Reglas.RevizarVariable("int perro = 1;");
		assertTrue(tr == TipoRespuesta.correcto);
	}
}
