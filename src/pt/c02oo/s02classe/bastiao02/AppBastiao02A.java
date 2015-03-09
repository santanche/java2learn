package pt.c02oo.s02classe.bastiao02;

public class AppBastiao02A
{
    public static void main(String[] args)
           throws InterruptedException     // isso eh usado por causa do Thread.sleep
    {
        BastiaoA theBastian;
        theBastian = new BastiaoA(1, "acordado");
        theBastian.aparece();
        
        for (int b = 1; b <= 3; b++) {
            theBastian.dorme();
            Thread.sleep(1000);

            theBastian.acorda();
            Thread.sleep(1000);

            theBastian.cresce();
            Thread.sleep(1000);
        }
    }

}
