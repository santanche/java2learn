package pt.c05concorrente.s08exercicios01.q02.s04;

public class Servidor
{
    private Chat ultimaOrigem = null;
    
    public synchronized void enviaMensagem(
                                 String mensagem, Chat origem, Chat destino)
    {
        while (origem == ultimaOrigem)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                /* nada */
            }
        }
        
        destino.recebeMensagem(mensagem, origem);
        ultimaOrigem = origem;
        notify();
    }
}
