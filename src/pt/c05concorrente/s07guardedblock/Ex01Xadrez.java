package pt.c05concorrente.s07guardedblock;

import java.util.Scanner;

public class Ex01Xadrez
{
    public static class Tabuleiro
    {
        Jogador ultimoJogou = null;
        
        public synchronized void solicitaVez(Jogador candidato)
        {
            if (ultimoJogou == null)
                ultimoJogou = candidato;
                
            // se foi o ultimo a jogar, deixa esperando ateh
            // o oponente jogar
            while (candidato == ultimoJogou)
            {
                try {
                    wait();
                } catch (InterruptedException e) {
                    /* nada */
                }
            }
            
            // libera para jogar
        }
        
        public synchronized void fazJogada(Jogador jogou)
        {
            // verificacao de jogada correta
            if (ultimoJogou == jogou) {
                System.out.println("*** Erro: jogada duplicada");
                System.exit(0);
            }
            
            // chama algum processo que realiza a jogada
            
            // passa automaticamente a ser o ultimo que jogou
            ultimoJogou = jogou;
            
            notifyAll();
        }
    }
    
    public static class Jogador extends Thread
    {
        String rotulo;
        Tabuleiro oTabuleiro;
        
        public Jogador(String rotulo, Tabuleiro oTabuleiro)
        {
            this.rotulo = rotulo;
            this.oTabuleiro = oTabuleiro;
        }
        
        public void run()
        {
            boolean continua = true;
            
            while (continua)
            {
                oTabuleiro.solicitaVez(this);
                
                /* tempo usado para realizar a sua jogada */
                int tempoEspera = (int)(Math.random() * 1000);
                System.out.println(rotulo + " estah jogando (" +
                                   tempoEspera + " espera)...");
                try {
                    Thread.sleep(tempoEspera);
                } catch (InterruptedException e) {
                    continua = false;
                }
        
                oTabuleiro.fazJogada(this);
            }
        }
    }

    public static void main(String args[])
    {
        Tabuleiro oTabuleiro = new Tabuleiro();
        
        Jogador doriana = new Jogador("Doriana", oTabuleiro),
                alcebiades = new Jogador("Alcebiades", oTabuleiro);
        
        Scanner teclado = new Scanner(System.in);
        
        alcebiades.start();
        doriana.start();
        
        System.out.println("Digite <ENTER> para encerrar...");
        teclado.nextLine();
        
        alcebiades.interrupt();
        doriana.interrupt();
        
        System.out.println("Terminou");
     }
}
