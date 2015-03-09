package pt.c05concorrente.s01thread;

public class Ex00TicTacSemThread
{
    private int numeroBatidas;
    private boolean tic = true;

    public Ex00TicTacSemThread(int numeroBatidas)
    {
        this.numeroBatidas = numeroBatidas;
    }

    public void executaTicTac()
    {
        for (int b = 1; b <= numeroBatidas; b++) {
            System.out.print((tic) ? "Tic" : "Tac"); 
            System.out.println(" (" + b + ")");
            tic = !tic;
        }
    }
    
    public static void main(String[] args)
    {
        Ex00TicTacSemThread tt = new Ex00TicTacSemThread(10);
        tt.executaTicTac();
        System.out.println("Depois do Tic Tac.");
    }

}
