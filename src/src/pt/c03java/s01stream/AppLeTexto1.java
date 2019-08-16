package pt.c03java.s01stream;

import java.io.FileReader;
import java.io.IOException;

public class AppLeTexto1
{
    public static String DIRETORIO = AppLeTexto1.class.getResource(".").getPath() + "/";

    public static void main(String args[])
    {
    	try {
    		FileReader arquivo = new FileReader(DIRETORIO + "texto1.txt");
    	    
    	    int caractere = arquivo.read();
    	    while (caractere != -1)
    	    {
    	    	System.out.println((char)caractere);
    	    	caractere = arquivo.read();
    	    }
    	    
    	    arquivo.close();
    	} catch (IOException erro) {
    	    System.out.println("Não consegui criar o arquivo =(");
    		 erro.printStackTrace();
    	}
    }
}
