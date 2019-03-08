package pt.c03java.s01stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AppGravaTexto2
{

    public static String DIRETORIO = AppGravaTexto2.class.getResource(".").getPath() + "/";

    public static void main(String argumentos[])
    {
        FileWriter arquivo;
        PrintWriter formatado;

        try {
            arquivo = new FileWriter(DIRETORIO + "texto2.txt");

            formatado = new PrintWriter(arquivo);

            formatado.println("Tecodonte");

            formatado.close();
            
            System.out.println("Gravacao realizada com sucesso!");
        } catch (IOException erro) {
            System.out.println("Não consegui criar o arquivo =(");
        }
    }
}
