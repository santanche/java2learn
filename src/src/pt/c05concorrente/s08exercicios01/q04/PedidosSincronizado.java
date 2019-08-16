package pt.c05concorrente.s08exercicios01.q04;

public class PedidosSincronizado
{
    private int listaPedidos[] = new int[10];
    private int totalPedidos = 0;
    private int lote = 1;
    
    public synchronized void despacha(int codigo, int quant)
    {
        while (totalPedidos + quant > 3000) {
            System.out.println("Mais que 3000, esperando...");
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        
        listaPedidos[codigo] += quant;
        totalPedidos += quant;
        System.out.println("Pedido gerado (" + codigo + ", " + quant + ")");
        notifyAll();
    }
    
    public synchronized int produz()
    {
        int produzir = -1;
        do {
            for (int p = 0; p < 10 && produzir == -1; p++)
                if (listaPedidos[p] >= 20)
                    produzir = p;
            
            if (produzir == -1)
                try {
                    wait();
                } catch (InterruptedException e) {
                }
        } while (produzir == -1);
        
        listaPedidos[produzir] -= 20;
        totalPedidos -= 20;
        lote++;
        notifyAll();
        return produzir;
    }
}
