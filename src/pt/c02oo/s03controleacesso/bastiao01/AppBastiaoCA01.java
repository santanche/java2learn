package pt.c02oo.s03controleacesso.bastiao01;

public class AppBastiaoCA01
{
    public static void main(String[] args)
           throws InterruptedException     // isso eh usado por causa do Thread.sleep
    {
        Bastiao primeiroBastiao;
        primeiroBastiao = new Bastiao(1, "acordado", "Asdrubal");
        
        primeiroBastiao.aparece();
        
        System.out.println("====================================\n");

        for (int b = 1; b <= 3; b++) {
            primeiroBastiao.dorme();
            Thread.sleep(1000);
            
            System.out.println("------------------------------------\n");

            primeiroBastiao.acorda();
            Thread.sleep(1000);

            System.out.println("------------------------------------\n");

            primeiroBastiao.cresce();
            Thread.sleep(1000);
            
            System.out.println("====================================\n");
        }
    }

}
