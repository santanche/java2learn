package pt.c06patterns.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AppGravaBastiaoDAO
{
    public static String DIRETORIO = AppGravaBastiaoDAO.class.getResource(".").getPath() + "/";

    public static void main(String argumentos[])
    {
        PrintWriter arquivo;
        BastiaoDAO theBastian = new BastiaoDAO(1, "acordado", "Asdrubal");
        
        try {
            arquivo = new PrintWriter(new FileWriter(DIRETORIO + "bastiao.txt"));

            theBastian.write(arquivo);

            arquivo.close();
            
            System.out.println("Gravacao realizada com sucesso!");
        } catch (IOException erro) {
            System.out.println("Não consegui criar o arquivo =(");
        }
    }
}
