package pt.c02oo.s09abstrata.s03tempo;

public abstract class Tempo
{
    public abstract long quantidade();

    public abstract String toString();

    public long diferenca(Tempo externo)
    {
        return quantidade() - externo.quantidade();
    }
    
    /*
     * Retorna:
     *     0 - se os tempos forem iguais
     *     1 - se o tempo deste objeto for maior que o externo
     *    -1 - se o tempo do objeto externo for maior que este
     */
    public int compara(Tempo externo)
    {
        int resultado = 0;
        if (quantidade() > externo.quantidade())
            resultado = 1;
        else if (quantidade() < externo.quantidade())
            resultado = -1;
        
        return resultado;
    }
}
