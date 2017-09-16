package com.udea.principal;

import java.io.PrintWriter;
import java.util.List;

public class GenerarReporte {
	
	
	public static void GenerarElReporte()
	{
		try(  PrintWriter out = new PrintWriter( "reporte2.csv" )  ){
			List<String> listaArchivos = ContarClases.RetornaNombres("./src/com/udea/principal");
			String respuesta = "Class Name;Class LOC;Number Of Methods";
			out.println(respuesta);
			//*
			for(String archivo:listaArchivos)
			{
				List<String> lineasArchivo = ContarClases.RetornaLista("./src/com/udea/principal/" + archivo);
				int loc = ContarLineasClases.ContarLineasClase(lineasArchivo);
				int nom = ContarLineasClases.ContarLineasMetodosClases(lineasArchivo);
				if(nom!=0) {
					respuesta=respuesta + "\n" + archivo + ";" + loc + ";" + nom;
					out.println(archivo + ";" + loc + ";" + nom);
				}				
			}
			System.out.println(respuesta);
			//*/
		}catch (Exception e) {
			System.out.println("Error");
		}
		
	}
	
	public static void GenerarElReporteAnterior()
	{
		try(  PrintWriter out = new PrintWriter( "reporte1.csv" )  ){
			
			List<String> listaArchivos = ContarClases.RetornaNombres("C:\\Users\\LENOVO\\eclipse-workspace\\Programa1-TDD-\\src\\com\\udea");
			System.out.println(listaArchivos + "Casa");
			String respuesta = "Class Name;Class LOC;Number Of Methods";
			out.println(respuesta);
			//*
			for(String archivo:listaArchivos)
			{
				List<String> lineasArchivo = ContarClases.RetornaLista("C:\\Users\\LENOVO\\eclipse-workspace\\Programa1-TDD-\\src\\com\\udea\\" + archivo);
				int loc = ContarLineasClases.ContarLineasClase(lineasArchivo);
				int nom = ContarLineasClases.ContarLineasMetodosClases(lineasArchivo);
				if(nom!=0) {
					respuesta=respuesta + "\n" + archivo + ";" + loc + ";" + nom;
					out.println(archivo + ";" + loc + ";" + nom);
				}				
			}
			System.out.println(respuesta);
			//*/
		}catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		
	}

}
