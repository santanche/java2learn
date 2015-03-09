package pt.c05concorrente.s01thread;

public class Ex01TicTac extends Thread
{
    private int numeroBatidas;
    private boolean tic = true;
    
    public Ex01TicTac(int numeroBatidas)
    {
        this.numeroBatidas = numeroBatidas;
    }
    
    public void run()
    {
        for (int b = 1; b <= numeroBatidas; b++) {
            System.out.print((tic) ? "Tic" : "Tac"); 
            System.out.println(" (" + b + ")");
            tic = !tic;
        }
    }

    public static void main(String args[])
    {
        Ex01TicTac thread01 = new Ex01TicTac(10);
        thread01.start();
        System.out.println("Depois da thread.");
    }
}
