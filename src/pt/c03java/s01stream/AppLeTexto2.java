package pt.c03java.s01stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppLeTexto2
{
    public static String DIRETORIO = AppLeTexto2.class.getResource(".").getPath() + "/";

	 public static void main(String args[])
    {
    	try {
    		FileReader arquivo = new FileReader(DIRETORIO + "texto2.txt");
    		BufferedReader formatado = new BufferedReader(arquivo);
    	    
    	    String linha = formatado.readLine();
    	    while (linha != null)
    	    {
    	    	System.out.println(linha);
    	    	linha = formatado.readLine();
    	    }
    	    
    	    arquivo.close();
    	} catch (IOException erro) {
    		erro.printStackTrace();
    	}
    }
}
