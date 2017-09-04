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
	
	@Test
	public void TestContarLienasInstruccionesMismaLinea(){
		List<String> programa = new ArrayList<>();
		programa.add("j=j+1;k=k+1;k--");
		int resultado = ContarLineas.ContarLineas(programa);
		assertTrue(resultado==3);
	}
	
	@Test
	public void TestContarLineasDosFor(){
		List<String> programa = new ArrayList<>();
		programa.add("for(int i=0;i<3;i++){");
		programa.add("for(int j=0;j<4;j++){k=k+1;}");
		programa.add("}");
		int resultado = ContarLineas.ContarLineas(programa);
		assertTrue(resultado==7);
	}
	
	@Test
	public void TestContarLineasSentenciaIf(){
		List<String> programa = new ArrayList<>();
		programa.add("if(a==1){");
		int resultado = ContarLineas.ContarLineas(programa);
		assertTrue(resultado==1);
	}
	
	@Test
	public void TestContarLineasComentario(){
		List<String> programa = new ArrayList<>();
		programa.add("//Prueba");
		int resultado = ContarLineas.ContarLineas(programa);
		assertTrue(resultado==0);
	}
	
	@Test
	public void TestContarLineasProgramaCompleto(){
		List<String> programa = new ArrayList<>();
		programa.add("/*Programa 1");
		programa.add("*/");
		programa.add("//Iniciando metodo");
		programa.add("for(int i=0;i<3;i++){");
		programa.add("if(i=3){");
		programa.add("system.out.println(i)");
		programa.add("while(j<2){");
		programa.add("system.out.println(j);");
		programa.add("j++;");
		programa.add("}");
		programa.add("}");
		programa.add("system.out.println(termino)");
		
		int resultado = ContarLineas.ContarLineas(programa);
		assertTrue(resultado==9);
	}

}
