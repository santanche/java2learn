package pt.c06patterns.builder.livro;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ConcreteBuilderXML implements AbstractBuilderLivro
{
    private PrintWriter pw;
    
    public ConcreteBuilderXML()
    {
        try {
            FileWriter fw = new FileWriter("livro.xml");
            pw = new PrintWriter(fw);
            pw.println("<livro>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void criaAutor(String autor)
    {
        pw.println("<autor>" + autor + "</autor>");
    }

    public void criaTitulo(String titulo)
    {
        pw.println("<titulo>" + titulo + "</titulo>");
    }

    public void criaDataPublicacao(Date dataPublicacao)
    {
        pw.println("<data>" + dataPublicacao + "</data>");
    }
    
    public void encerra()
    {
        pw.println("</livro>");
        pw.close();
    }
}
