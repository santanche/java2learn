package pt.c02oo.s01estudocaso.s06classe;

public class Bits06Classe
{
    static int combinacoes;
    
    static void inicializa()
    {
        combinacoes = 1;
    }
    
    static int proximoNumeroCombinacoes()
    {
        combinacoes *= 2;
        return combinacoes;
    }
}
