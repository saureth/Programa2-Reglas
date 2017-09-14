package com.udea.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContarLineasClases {
	
	public static int ContarLineasClase(List<String> clase) {
		int cantidad = 0;
		boolean comenzarConteo = false;
		
		if(clase==null) {
			return 0;
		}
		if(clase.isEmpty()) {
			return 0;
		}
		for (String linea : clase) {
			if(!comenzarConteo) {
				Pattern pat = Pattern.compile("(public|private|protected) class ([a-zA-Z0-9{ ]{0,100})");
			    Matcher mat = pat.matcher(linea);
			    if(mat.matches()) {
			    	comenzarConteo = true;
			    }
			}else {
				Pattern pat = Pattern.compile("(public|static|private|protected) ([a-zA-Z0-9 ]{1,100})[(]([a-zA-Z0-9,){ ]{1,100})");
			    Matcher mat = pat.matcher(linea);
			    if(!mat.matches()) {
			    	List<String> programa = new ArrayList<>();
			    	programa.add(linea);
			    	cantidad += ContarLineas.ContarLineas(programa);
			    }
			}
			
		}
		return cantidad;
	}
}
