package pt.c02oo.s02classe.s02bastiao05;

public class AppBastiao05
{
    public static void main(String[] args)
           throws InterruptedException     // isso eh usado por causa do Thread.sleep
    {
        BastiaoEstatico.inicializa(1, "acordado", "Asdrubal");
        
        System.out.println("====================================\n");

        for (int b = 1; b <= 3; b++) {
            BastiaoEstatico.dorme();
            Thread.sleep(1000);
            
            System.out.println("------------------------------------\n");

            BastiaoEstatico.acorda();
            Thread.sleep(1000);

            System.out.println("------------------------------------\n");

            BastiaoEstatico.cresce();
            Thread.sleep(1000);
            
            System.out.println("====================================\n");
        }
    }

}
