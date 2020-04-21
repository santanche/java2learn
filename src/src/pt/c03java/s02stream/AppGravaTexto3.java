package pt.c03java.s02stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AppGravaTexto3
{

    public static String DIRETORIO = AppGravaTexto3.class.getResource(".").getPath() + "/";

    public static void main(String argumentos[])
    {
        FileWriter arquivo;
        PrintWriter formatado;

        try {
           // o segundo parametro indica se fara append ou nao
            arquivo = new FileWriter(DIRETORIO + "texto2.txt", true);

            formatado = new PrintWriter(arquivo);

            formatado.println("amigo do Horacio");

            formatado.close();
            
            System.out.println("Gravacao realizada com sucesso!");
        } catch (IOException erro) {
            System.out.println("N�o consegui criar o arquivo =(");
        }
    }
}
