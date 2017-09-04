package com.udea.principal;

import java.util.List;

public class ContarLineas {
	public static int ContarLineas(List<String> programa) {
		int contador = 0;
		if (programa == null) {
			return 0;
		}
		if (programa.size() == 0) {
			return 0;
		}

		for (String linea : programa) {
			if(linea.contains("//")){
				
			}else if(linea.contains("/*")){
				
			}else if(linea.contains("*/")){
				
			}
			else if (linea.contains("for")) {
				contador += 3;
				if(linea.contains("{")){
					int position = linea.indexOf("{");
					int diferencia = linea.length()-position;
					if(diferencia>1){
						String subString = linea.substring(position, linea.length()-1);
						String sub[] = subString.split(";");
						//System.out.println(sub.length);
						contador+=sub.length;
					}
				}
			} else if (linea.length() == 1 && (linea.equals("{") || linea.equals("}"))) {

			} else {
				if(linea.contains("{")){
					int posicion = linea.indexOf("{");
					int diferencia = linea.length()-posicion;
					if(diferencia>1){
						String sub[] = linea.split("{");
						
					}
				}
				String sublineas[] = linea.split(";");
				if(sublineas.length>1){
					contador+=sublineas.length;
				}else{
					contador++;
				}
				
			}

		}

		return contador;
	}
}
