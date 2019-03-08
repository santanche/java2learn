package pt.c05concorrente.s02interrupcao;

import java.util.Scanner;

public class Ex01Mensagem extends Thread
{
    private String mensagem[] = {
        "Digite alguma coisa, por favor!",
        "Estou ficando impaciente!",
        "Helloooooowwwww",
        "Nao me faca ir ai!",
    };
    
    int proximaMensagem = 0;
    
    public void run()
    {
        boolean continua = true;
        
        while (continua)
        {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                continua = false;
            }

            if (continua) {
                System.out.println("***** " + mensagem[proximaMensagem]);
                proximaMensagem = (proximaMensagem + 1) % 4;
            }
        }
    }
    
    public static void main(String args[])
    {
        Ex01Mensagem controle = new Ex01Mensagem();
        controle.start();
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = teclado.nextLine();
        
        controle.interrupt();
        
        System.out.println("Bem vindo " + nome);
     }
}
