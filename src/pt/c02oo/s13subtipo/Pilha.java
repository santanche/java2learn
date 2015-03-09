package pt.c02oo.s13subtipo;

public class Pilha
{
    private int vpilha[];
    private int topo;
    
    public Pilha(int tamanho)
    {
        vpilha = new int[tamanho];
        topo = -1;
    }
    
    public void empilha(int numero)
    {
        if (topo < vpilha.length-1) {
            topo++;
            vpilha[topo] = numero;
        }
    }
    
    public int desempilha()
    {
        int numero = 0;
        if (topo >= 0) {
            numero = vpilha[topo];
            topo--;
        }
        return numero;
    }
    
    public boolean vazia()
    {
        return topo < 0;
    }
    
    public int numeroElementos()
    {
        return topo + 1;
    }
}
