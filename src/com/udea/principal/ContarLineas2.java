package com.udea.principal;

import java.util.List;

public class ContarLineas2 
{
	public static int ValorLinea(String linea)
	{
		linea = linea.replaceAll("\t", "");
		linea = linea.replaceAll(" ", "");
		if(linea.equals("")||linea.equals("{")||linea.equals("}")||linea.length()<4)
		{
			return 0;
		}
		if(linea.substring(0, 2).equals("//"))
		{
			return 0;
		}
		if(linea.length()>3 && linea.substring(0, 4).equals("for("))
		{
			return 3;
		}
		if(linea.substring(0, 3).equals("if("))
		{
			return 1;
		}
		
		return 1;
	}
	
	public static int ContarLineas(List<String> lista)
	{
		int n = 0;
		
		for (String linea : lista) {
			
			n += ValorLinea(linea);
		}
		
		return n;
	}
	
}
