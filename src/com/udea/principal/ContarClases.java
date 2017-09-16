package com.udea.principal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ContarClases {
	
	public int Contar(String string) {
		if(string.isEmpty()) {
			return -1;
		}
		File c = new File(string);
		if(!c.exists()) {
			return -1;
		}		
		else {
			File[] files = c.listFiles();
			int count = 0;
			for(int i = 0; i< files.length;i++) {
				if(files[i].getName().contains(".java")) {
					count++;
				}
			}
			return count;
		}
	}
	
	public static List<String> RetornaLista(String string) {
		File c = new File(string);
		if(!c.exists()) {
			return null;
		}		
		else {
			return LectorArchivos.Abrir(string);
		}
	}

	public static List<String> RetornaNombres(String string) {
		if(string.isEmpty()) {
			return null;
		}
		File c = new File(string);
		if(!c.exists()) {
			return null;
		}		
		else {
			File[] files = c.listFiles();
			List<String> names = new ArrayList<>();
			int count = 0;
			for(int i = 0; i< files.length;i++) {
				if(files[i].getName().contains(".java")) {
					names.add(files[i].getName());
				}
			}
			return names;
		}
	}
	
}