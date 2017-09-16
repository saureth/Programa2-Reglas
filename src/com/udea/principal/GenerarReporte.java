package com.udea.principal;

import java.util.List;

public class GenerarReporte {
	
	
	public static void GenerarElReporte()
	{
		List<String> listaArchivos = ContarClases.RetornaNombres("./src/com/udea/principal");
		
		for(String archivo:listaArchivos)
		{
			System.out.println(archivo);
		}
	}

}
