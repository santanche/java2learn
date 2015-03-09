package pt.c05concorrente.s01thread;

public class Ex04TicTac extends Thread
{
    private String rotulo;
    
    private int numeroBatidas,
                tempoEntreBatidas;

    private boolean tic = true;
    
    public Ex04TicTac(String rotulo, int numeroBatidas, int tempoEntreBatidas)
    {
        this.rotulo = rotulo;
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

            System.out.print(rotulo + " : " + tempoEntreBatidas * b + " : ");
            System.out.print((tic) ? "Tic" : "Tac"); 
            System.out.println(" (" + b + ")");
            tic = !tic;
        }
    }

    public static void main(String args[])
    {
        Ex04TicTac thread01 = new Ex04TicTac("A", 10, 1000);
        Ex04TicTac thread02 = new Ex04TicTac("B", 8, 2500);

        thread01.start();
        thread02.start();
    }
}
