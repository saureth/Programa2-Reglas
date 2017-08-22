package com.udea.principal;

public class Clasificador {

	public TipoLinea ClasificarLinea(String linea) 
	{
		if(linea.equals("")) {
			return TipoLinea.nulo;
		}		
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
		
		p = linea.replaceAll("\t", "");
		
		if(p.substring(p.length()-1).equals(";"))
		{
			if(p.substring(0,5).equals("packa")||(p.substring(0,5).equals("impor")))
			{
				return TipoLinea.libreria;
			}
			else if((p.split(" "))[0].equals("public")|| (p.split(" "))[0].equals("private") || (p.split(" "))[0].equals("static"))
			{
				return TipoLinea.variable;
			}			
			else if(!p.contains(" "))
			{
				return TipoLinea.llamadaMetodo;
			}
			
			return TipoLinea.variable;
		}
		
		return TipoLinea.nulo;
	}
	
	
	public String AllanarComillas(String l) 
	{
		if(l.equals("")) 
		{
			return "";
		}
		if(!l.contains("\"")) 
		{
			return l;
		}
		else 
		{
			int c1 = l.indexOf("\"");
			int c2 = l.indexOf("\"",c1+1);
			String aux = l.substring(c1,c2+1);
			l = l.replace(aux, "");
			return l;
		}
	}
	
}