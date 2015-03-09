package pt.c05concorrente.s01thread;

public class Ex02TicTac implements Runnable
{
    private int numeroBatidas;
    private boolean tic = true;
    
    public Ex02TicTac(int numeroBatidas)
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
        Thread thread01 = new Thread(new Ex02TicTac(10));
        thread01.start();
        System.out.println("Depois da thread.");
    }
}
