package pt.c05concorrente.s08exercicios01.q02.s02;

public class Servidor
{
    public synchronized void enviaMensagem(
                                 String mensagem, Chat origem, Chat destino)
    {
        destino.recebeMensagem(mensagem, origem);
    }
}
