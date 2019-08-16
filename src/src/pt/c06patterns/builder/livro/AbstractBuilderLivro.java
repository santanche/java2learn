package pt.c06patterns.builder.livro;

import java.util.Date;

public interface AbstractBuilderLivro
{
    public void criaTitulo(String titulo);
    public void criaAutor(String autor);
    public void criaDataPublicacao(Date dataPublicacao);
    public void encerra();
}
