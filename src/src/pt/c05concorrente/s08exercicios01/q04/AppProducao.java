package pt.c05concorrente.s08exercicios01.q04;

public class AppProducao
{
    public static void main(String[] args)
    {
        PedidosSincronizado centralPedidos =
            new PedidosSincronizado();
        
        Vendas asVendas = new Vendas(centralPedidos);
        Producao aProducao = new Producao(centralPedidos);
        
        asVendas.start();
        aProducao.start();
    }
}
