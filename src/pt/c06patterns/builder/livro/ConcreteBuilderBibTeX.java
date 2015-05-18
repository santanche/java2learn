package pt.c06patterns.builder.livro;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ConcreteBuilderBibTeX implements AbstractBuilderLivro
{
    private PrintWriter pw;
    
    public ConcreteBuilderBibTeX()
    {
        try {
            FileWriter fw = new FileWriter("livro.bib");
            pw = new PrintWriter(fw);
            pw.println("@book {");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void criaTitulo(String titulo)
    {
        pw.println("  title = {" + titulo + "},");

    }
    
    public void criaAutor(String autor)
    {
        pw.println("  author = {" + autor + "},");
    }

    public void criaDataPublicacao(Date dataPublicacao)
    {
        pw.println("  day = {" + dataPublicacao.getDay() + "},");
        pw.println("  month = {" + dataPublicacao.getMonth() + "},");
        pw.println("  year = {" + dataPublicacao.getYear() + "},");
    }

    public void encerra()
    {
        pw.println("}");
        pw.close();
    }

}
