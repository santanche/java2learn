package pt.c02oo.s01estudocaso.s07objeto;

public class Bits07Instancia
{
    int combinacoes;
    
    Bits07Instancia()
    {
        combinacoes = 1;
    }
    
    int proximoNumeroCombinacoes()
    {
        combinacoes *= 2;
        return combinacoes;
    }
}
