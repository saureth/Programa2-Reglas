package com.udea.principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

public class LectorArchivos 
{
	static File archivo;
	static FileReader fr;
	static BufferedReader br;
	static JFileChooser jfc;
	static List<String> p = new ArrayList<String>();
	
	public List<String> ObtenerCodigo() 
	{
		jfc = new JFileChooser();
		jfc.showOpenDialog(null);		
		archivo = jfc.getSelectedFile();
		return AbrirArchivo(jfc.getSelectedFile().getPath());
	}
	
	
	public List<String> AbrirArchivo(String url)
	{
	     try 
	     {
	    	String completeUrl = new File("").getAbsolutePath() + "/Archivos/" + url;
	    	archivo = new File(completeUrl);
			fr = new FileReader (archivo);
		} catch (FileNotFoundException e) 
	    {
			return null;
		}
	     br = new BufferedReader(fr);
	     String linea;
	     try 
	     {
			while((linea=br.readLine())!=null)
			{
			    p.add(linea);
			}
		} catch (IOException e) 
	    {
			return null;
		}
	     return p;
	}
	
	public static List<String> Abrir(String url)
	{
	     try 
	     {
	    	String completeUrl = new File("").getAbsolutePath() + url;
	    	archivo = new File(completeUrl);
			fr = new FileReader (archivo);
		} catch (FileNotFoundException e) 
	    {
			return null;
		}
	     br = new BufferedReader(fr);
	     String linea;
	     try 
	     {
			while((linea=br.readLine())!=null)
			{
			    p.add(linea);
			}
		} catch (IOException e) 
	    {
			return null;
		}
	     return p;
	}
	
}
