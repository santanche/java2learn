package pt.c05concorrente.s08exercicios01.q04;

public class Producao extends Thread
{
    private PedidosSincronizado centralPedidos;
    
    public Producao(PedidosSincronizado centralPedidos)
    {
        this.centralPedidos = centralPedidos;
    }
    
    public void run()
    {
        while (true)
        {
            int codigoProduto =
                centralPedidos.produz();
            Fabrica.produzLote20(codigoProduto);
        }
    }
}
