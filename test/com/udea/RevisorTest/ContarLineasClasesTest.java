package com.udea.RevisorTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.udea.principal.ContarLineasClases;

public class ContarLineasClasesTest {

	@Test
	public void ContarLineasClasesNull() {
		int resultado = ContarLineasClases.ContarLineasClase(null);
		assertTrue(resultado==0);
	}
	
	@Test
	public void contarLineasClaseVacia() {
		List<String> clase = new ArrayList<>();
		int resultado = ContarLineasClases.ContarLineasClase(clase);
		assertTrue(resultado==0);
	}
	
	@Test
	public void contarLineasClaseSinMetodosSinAtributos() {
		List<String> clase = new ArrayList<>();
		clase.add("package com.udea.Revisor;");
		clase.add("import java.util.ArrayList;");
		clase.add("public class Sumar{");
		clase.add("}");
		
		int resultado = ContarLineasClases.ContarLineasClase(clase);
		assertTrue(resultado==0);
	}
	
	@Test
	public void contarLineasClaseSinMetodosConAtributos() {
		List<String> clase = new ArrayList<>();
		clase.add("package com.udea.Revisor;");
		clase.add("import java.util.ArrayList;");
		clase.add("public class Sumar{");
		clase.add("private int numero1;");
		clase.add("private int numero2=2;");
		clase.add("}");
		
		int resultado = ContarLineasClases.ContarLineasClase(clase);
		System.out.println(resultado);
		assertTrue(resultado==2);
	}
	
	@Test
	public void contarLineasClasesConMetodosAtributos() {
		List<String> clase = new ArrayList<>();
		clase.add("package com.udea.Revisor;");
		clase.add("import java.util.ArrayList;");
		clase.add("public class Sumar{");
		clase.add("private int numero1;");
		clase.add("private int numero2=2;");
		clase.add("public void sumar(){");
		clase.add("j+1;");
		clase.add("}");
		clase.add("k*f;");
		clase.add("public void restar(int k,int j){");
		clase.add("j+1;");
		clase.add("}");
		clase.add("}");
		
		int resultado = ContarLineasClases.ContarLineasClase(clase);
		System.out.println(resultado);
		assertTrue(resultado==5);
	}

}

