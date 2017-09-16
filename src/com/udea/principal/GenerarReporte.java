package com.udea.principal;

import java.io.PrintWriter;
import java.util.List;

public class GenerarReporte {
	
	
	public static void GenerarElReporte()
	{
		try(  PrintWriter out = new PrintWriter( "reporte.xls" )  ){
			List<String> listaArchivos = ContarClases.RetornaNombres("./src/com/udea/principal");
			String respuesta = "Class Name\tClass LOC\tNumber Of Methods";
			out.println(respuesta);
			//*
			for(String archivo:listaArchivos)
			{
				List<String> lineasArchivo = ContarClases.RetornaLista("./src/com/udea/principal/" + archivo);
				int loc = ContarLineasClases.ContarLineasClase(lineasArchivo);
				int nom = ContarLineasClases.ContarLineasMetodosClases(lineasArchivo);
				if(nom!=0) {
					respuesta=respuesta + "\n" + archivo + "\t" + loc + "\t" + nom;
					out.println(archivo + "\t" + loc + "\t" + nom);
				}				
			}
			System.out.println(respuesta);
			//*/
		}catch (Exception e) {
			System.out.println("Error");
		}
		
	}

}
