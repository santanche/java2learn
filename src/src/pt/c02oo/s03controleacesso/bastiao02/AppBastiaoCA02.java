package pt.c02oo.s03controleacesso.bastiao02;

public class AppBastiaoCA02
{
    public static void main(String[] args)
           throws InterruptedException     // isso eh usado por causa do Thread.sleep
    {
        Bastiao primeiroBastiao;
        primeiroBastiao = new Bastiao(1, "acordado", "Asdrubal");
        primeiroBastiao.aparece();
        
        System.out.println("====================================\n");

        for (int b = 1; b <= 9; b++)
        {
            if (primeiroBastiao.getIdade() >= 3)
            {
                primeiroBastiao.setIdade(1);
                primeiroBastiao.aparece();
            }
            else
                primeiroBastiao.cresce();
            
            Thread.sleep(1000);
            
            System.out.println("====================================\n");
            
        }
    }

}
