package com.udea.RevisorTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.udea.principal.ContarLineas;

public class TestContarLineas {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void TestContarLineasParametroNull() {
		int resultado = ContarLineas.ContarLineas(null);
		assertTrue(resultado==0);
	}
	
	@Test
	public void TestContarLineasParametroVacio(){
		List<String> lineas = new ArrayList<>();
		int resultado = ContarLineas.ContarLineas(lineas);
		assertTrue(resultado==0);
	}
	
	@Test
	public void TestContarLineasFor(){
		List<String> programa = new ArrayList<>();
		programa.add("for(int i=0;i<3;i++){");
		int resultado = ContarLineas.ContarLineas(programa);
		assertTrue(resultado==3);
	}
	
	@Test
	public void TestContarLineasForConInstrucciones(){
		List<String> programa = new ArrayList<>();
		programa.add("for(int i=0;i<3;i++){");
		programa.add("System.out.println(i);");
		programa.add("}");
		
		int resultado = ContarLineas.ContarLineas(programa);
		assertTrue(resultado==4);
	}
	
	@Test
	public void TestContarLineasForConInstrucciones2(){
		List<String> programa = new ArrayList<>();
		programa.add("for(int i=0;i<3;i++){");
		programa.add("System.out.println(i);");
		programa.add("j+1");
		programa.add("}");
		programa.add("{");
		
		int resultado = ContarLineas.ContarLineas(programa);
		assertTrue(resultado==5);
	}
	
	@Test
	public void TestContarLineasForConInstruccionesMismaLinea(){
		List<String> programa = new ArrayList<>();
		programa.add("for(int i=0;i<3;i++){j=j+1;k=k+1;}");
		int resultado = ContarLineas.ContarLineas(programa);
		assertTrue(resultado==5);
	}

}
