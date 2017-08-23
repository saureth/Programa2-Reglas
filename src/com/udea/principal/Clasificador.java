package com.udea.principal;

public class Clasificador {

	public TipoLinea ClasificarLinea(String linea) 
	{
		if(linea.equals("")|| linea.equals(" ")) {
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
		
		if(p.contains(";"))
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
			else  
			{				
				String aux = AllanarComillas(p);
				String aux2 = AllanarParentesis(aux);
				String aux3= aux+aux2;
				if(!aux3.contains("=")) 
				{
					return TipoLinea.llamadaMetodo;
				}
				else return TipoLinea.variable;
			}			
		}
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
	
	public String AllanarParentesis(String l) 
	{
		if(l.equals("")) 
		{
			return "";
		}
		if(!l.contains("(")) 
		{
			return l;
		}
		else 
		{
			int c1 = l.indexOf("(");
			int c2 = l.indexOf(")",c1+1);
			String aux = l.substring(c1,c2+1);
			l = l.replace(aux, "");
			return l;
		}
		//return "";
	}
	
}