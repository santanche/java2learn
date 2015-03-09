package pt.c05concorrente.s08exercicios01.q03;

public class Consumidor extends Thread
{
    private PilhaConcorrente aPilha;
    private int quantidade;
    
    public Consumidor(PilhaConcorrente aPilha, int quantidade)
    {
        this.aPilha = aPilha;
        this.quantidade = quantidade;
    }
    
    public void run()
    {
        for (int i = 1; i <= quantidade; i++)
            aPilha.desempilha();
    }
}
