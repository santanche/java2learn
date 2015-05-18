package pt.c06patterns.factory.s07zebatata.produto;

public interface FabricaBatata
{
    public Olho criaOlhoEsquerdo();
    public Olho criaOlhoDireito();
    public Nariz criaNariz();
    public Boca criaBoca();
}
