package pt.c05concorrente.s01thread;

public class Ex03TicTac extends Thread
{
    private int numeroBatidas,
                tempoEntreBatidas;

    private boolean tic = true;
    
    public Ex03TicTac(int numeroBatidas, int tempoEntreBatidas)
    {
        this.numeroBatidas = numeroBatidas;
        this.tempoEntreBatidas = tempoEntreBatidas;
    }
    
    public void run()
    {
        for (int b = 1; b <= numeroBatidas; b++)
        {
            try {
                Thread.sleep(tempoEntreBatidas);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print(tempoEntreBatidas * b + " : ");
            System.out.print((tic) ? "Tic" : "Tac"); 
            System.out.println(" (" + b + ")");
            tic = !tic;
        }
    }

    public static void main(String args[])
    {
        Ex03TicTac thread01 = new Ex03TicTac(10, 1000);
        thread01.start();
    }
}
