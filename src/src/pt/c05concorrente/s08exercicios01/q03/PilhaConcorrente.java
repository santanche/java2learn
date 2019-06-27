package pt.c05concorrente.s08exercicios01.q03;

public class PilhaConcorrente
{
    private int pilha[];
    private int topo = 0;
    
    public PilhaConcorrente(int tamanho)
    {
        pilha = new int[tamanho];
    }
    
    public synchronized void empilha(int valor)
    {
        while (topo >= pilha.length)
        {
            System.out.println("  >> pilha cheia (" + valor +
                               "), esperando...");
            try {
                wait();
            } catch (InterruptedException e) {
                /* nada */
            }
        }
        
        pilha[topo] = valor;
        System.out.println("empilhei[" + topo + "]: " + valor);
        topo++;
        notifyAll();
    }
    
    public synchronized int desempilha()
    {
        while (topo <= 0)
        {
            System.out.println("  >> pilha vazia, esperando...");
            try {
                wait();
            } catch (InterruptedException e) {
                /* nada */
            }
        }
        
        topo--;
        int valor = pilha[topo];
        System.out.println("desempilhei[" + topo + "]: " + valor);
        notifyAll();
        return valor;
    }
}
