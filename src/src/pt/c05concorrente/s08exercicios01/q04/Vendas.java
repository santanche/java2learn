package pt.c05concorrente.s08exercicios01.q04;

import java.util.Scanner;

public class Vendas extends Thread
{
    private PedidosSincronizado centralPedidos;
    
    public Vendas(PedidosSincronizado centralPedidos)
    {
        this.centralPedidos = centralPedidos;
    }
    
    public void run()
    {
        while(true)
        {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Digite codigo: ");
            int codigoProduto = 
                Integer.parseInt(entrada.nextLine());
            System.out.println("Digite quantidade: ");
            int quantProduto = 
                Integer.parseInt(entrada.nextLine());
            centralPedidos.despacha(codigoProduto,
                                    quantProduto);
        }
    }
}
