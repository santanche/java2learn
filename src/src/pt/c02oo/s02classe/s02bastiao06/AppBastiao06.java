package pt.c02oo.s02classe.s02bastiao06;

public class AppBastiao06
{
    public static void main(String[] args)
    {
        Bastiao primeiroBastiao;
        primeiroBastiao = new Bastiao(1, "acordado", "Asdrubal");
        primeiroBastiao.aparece();
        
        Bastiao segundoBastiao;
        segundoBastiao = primeiroBastiao;
        segundoBastiao.aparece();
        
        segundoBastiao.dorme();
        
        primeiroBastiao.aparece();
   }

}
