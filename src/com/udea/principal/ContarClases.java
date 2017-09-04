package com.udea.principal;

import java.io.File;

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
	
}