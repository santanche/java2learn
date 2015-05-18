package pt.c06patterns.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppLeBastiaoDAO
{
    public static String DIRETORIO = AppLeBastiaoDAO.class.getResource(".").getPath() + "/";

    public static void main(String argumentos[])
    {
        BufferedReader arquivo;

        BastiaoDAO theBastian = new BastiaoDAO();
        
        try {
            arquivo = new BufferedReader(new FileReader(DIRETORIO + "bastiao.txt"));

            theBastian.read(arquivo);

            arquivo.close();
            
            theBastian.aparece();
        } catch (IOException erro) {
            System.out.println("Não consegui criar o arquivo =(");
        }
    }
}
