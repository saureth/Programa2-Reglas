package com.udea.principal;

import java.util.ArrayList;
import java.util.List;

/*
- las variables inician en minúsculas.
- Las clases inician en Mayúsculas.
- Los métodos inician por Mayúsculas.
- las llaves se ponen en líneas independientes
- La cantidad de abrir paréntesis por línea debe ser igual a la cantidad de cerrar
- La cantidad de abrir llave debe ser igual a la cantidad de Cerrar
*/
public class Reglas 
{
	public static TipoRespuesta RevizarVariable(String linea)
	{
		TipoRespuesta respuesta = TipoRespuesta.correcto;
		String p = linea.replaceAll(" ", "");
		int indiceComentario = p.indexOf("//");
		if(indiceComentario != -1)
		{
			p = p.substring(0, indiceComentario);
		}
		indiceComentario = p.indexOf("/*");
		if(indiceComentario != -1)
		{
			p = p.substring(0, indiceComentario);
		}
		
		if(!p.substring(p.length()-1).equals(";"))
		{
			//System.out.println("La línea no es una variable");
			return TipoRespuesta.no_aplica;
		}

		String[] palabras = linea.split(" ");

		/*
		List<String> palabras = new ArrayList<String>();
		for (int i = 0; i < lineas.length; i++) {
			String string = lineas[i];
			palabras.add(string);
		}
		*/
		
		int i = 0;
		String[] palabrasIgnorables = {"public", "private", "static"};
		for (int j = 0; j < 5; j++) {
			for (int j2 = 0; j2 < palabrasIgnorables.length; j2++) {
				if (palabras[i].equals(palabrasIgnorables[j2])) 
				{
					i++;
					break;
				}
			}
		}
		if ((i+1) >= palabras.length)
		{
			System.out.println("La cariable no parece tener nombre");
			return TipoRespuesta.incorrecto;
		}
		String nombrePalabra = palabras[i+1];
		String pl = nombrePalabra.substring(0, 1);
		if (pl.equals(pl.toUpperCase()))
		{
			System.out.println("La variable debería iniciar en minúscula");
			return TipoRespuesta.incorrecto;
		}
		return respuesta;
	}
	
	public static TipoRespuesta RevizarMetodo(String linea)
	{
		if(!(linea.contains("(") &&linea.contains(")")))
			return TipoRespuesta.incorrecto;

		if(linea.contains(";"))
			return TipoRespuesta.incorrecto;
		
		String[] palabras = linea.split(" ");
		int i = 0;
		String[] palabrasIgnorables = {"public", "private", "static"};
		for (int j = 0; j < 5; j++) {
			for (int j2 = 0; j2 < palabrasIgnorables.length; j2++) {
				if (palabras[i].equals(palabrasIgnorables[j2])) 
				{
					i++;
					break;
				}
			}
		}
		if ((i+1) >= palabras.length)
		{
			System.out.println("La cariable no parece tener nombre");
			return TipoRespuesta.incorrecto;
		}
		String nombrePalabra = palabras[i+1];
		String pl = nombrePalabra.substring(0, 1);
		if (!pl.equals(pl.toUpperCase()))
		{
			System.out.println(pl + "Los métodos deberían iniciar en mayúsculas");
			return TipoRespuesta.incorrecto;
		}
		return TipoRespuesta.correcto;
	}
}
