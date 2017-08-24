package com.udea.principal;

public class ContarLineas2 
{
	public static int ValorLinea(String linea)
	{
		linea = linea.replaceAll("\t", "");
		linea = linea.replaceAll(" ", "");
		if(linea.equals("")||linea.equals("{")||linea.equals("}"))
		{
			return 0;
		}
		if(linea.substring(0, 2).equals("//"))
		{
			return 0;
		}
		if(linea.substring(0, 4).equals("for("))
		{
			return 3;
		}
		if(linea.substring(0, 3).equals("if("))
		{
			return 1;
		}
		
		return 0;
	}
}
