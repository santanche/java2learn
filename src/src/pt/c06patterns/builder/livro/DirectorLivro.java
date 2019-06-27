package pt.c06patterns.builder.livro;

import java.util.Calendar;

public class DirectorLivro
{
    public void construct(AbstractBuilderLivro b)
    {
        b.criaTitulo("Vida dos Dinossauros");
        b.criaAutor("Alcebiades");
        b.criaDataPublicacao(Calendar.getInstance().getTime());
        b.encerra();
    }
}
