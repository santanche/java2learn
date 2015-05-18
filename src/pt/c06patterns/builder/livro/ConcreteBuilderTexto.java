package pt.c06patterns.builder.livro;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ConcreteBuilderTexto implements AbstractBuilderLivro
{
    private PrintWriter pw;
    
    public ConcreteBuilderTexto()
    {
        try {
            FileWriter fw = new FileWriter("livro.txt");
            pw = new PrintWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void criaAutor(String autor)
    {
        pw.println("Autor: " + autor);
    }

    public void criaTitulo(String titulo)
    {
        pw.println("Titulo: " + titulo);
    }

    public void criaDataPublicacao(Date dataPublicacao)
    {
        pw.println("Data: " + dataPublicacao);
    }
    
    public void encerra()
    {
        pw.close();
    }

}
