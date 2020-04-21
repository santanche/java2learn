package pt.c03java.s07anotacao.s03dao;

@MapTabela("TABIND")
public class Individuo
{
    @MapChavePrimaria
    @MapCampo("NAME")
    public String nome;
    
    @MapCampo("AGE")
    public int idade;

    @MapCampo("MARRIED")
    public boolean casado;
}
