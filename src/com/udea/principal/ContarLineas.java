package com.udea.principal;

import java.util.List;

public class ContarLineas {
	public static int ContarLineas(List<String> programa){
		int contador=0;
		if(programa==null){
			return 0;
		}
		if(programa.size()==0){
			return 0;
		}
		
		for (String linea : programa) {
			String sublineas[] = linea.split(";");
			if(sublineas.length>1){
				
			}else{
				if(linea.contains("for")){
					contador+=3;
				}else if(linea.length()==1 && (linea.equals("{") || linea.equals("}"))){
					
				}else{
					contador++;
				}
			}
			
			
			
		}
		
		return contador;
	}
}
