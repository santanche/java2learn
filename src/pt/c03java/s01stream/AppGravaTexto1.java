package pt.c03java.s01stream;

import java.io.FileWriter;
import java.io.IOException;

public class AppGravaTexto1
{
    // captura o diretorio em que se encontra a classe bastiao
    public static String DIRETORIO =
          AppGravaTexto1.class.getResource(".").getPath() + "/";
   
    public static void main(String argumentos[])
    {
        FileWriter arquivo;

        try {
            arquivo = new FileWriter(DIRETORIO + "texto1.txt");

            arquivo.write('T');
            arquivo.write('e');
            arquivo.write('c');
            arquivo.write('o');
            arquivo.write('d');
            arquivo.write('o');
            arquivo.write('n');
            arquivo.write('t');
            arquivo.write('e');

            arquivo.close();
            
            System.out.println("Gravacao concluida com sucesso!");
        } catch (IOException erro) {
            System.out.println("Não consegui criar o arquivo =(");
            erro.printStackTrace();
        }
    }
}
