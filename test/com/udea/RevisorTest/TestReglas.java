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
		TipoRespuesta tr = Reglas.RevizarVariable("int variable = 1;");
		assertTrue(tr == TipoRespuesta.correcto);
	}

	@Test
	public void TestVariableComoMetodo()
	{
		TipoRespuesta tr = Reglas.RevizarVariable("public void Metodo()");
		assertTrue(tr == TipoRespuesta.no_aplica);
	}
	
	@Test
	public void TestVariableConComentarios()
	{
		TipoRespuesta tr = Reglas.RevizarVariable("public float k = 2;//Hola mundo");
		assertTrue(tr == TipoRespuesta.correcto);
	}

	@Test
	public void TestVariableEstatica()
	{
		TipoRespuesta tr = Reglas.RevizarVariable("public static float k;//Hola mundo");
		assertTrue(tr == TipoRespuesta.correcto);
	}

	@Test
	public void TestVariableMayuscula()
	{
		TipoRespuesta tr = Reglas.RevizarVariable("public static float Kabra;");
		assertTrue(tr == TipoRespuesta.incorrecto);
	}
	@Test
	public void TestMetodoSinParentesis()
	{
		TipoRespuesta tr = Reglas.RevizarMetodo("Public void Casa(");
		assertTrue(tr == TipoRespuesta.incorrecto);
	}
	
	@Test
	public void TestMetodoSinMetodoCorrecto()
	{
		TipoRespuesta tr = Reglas.RevizarMetodo("Public void Casa(float casa)");
		assertTrue(tr == TipoRespuesta.correcto);
	}
}
