package pt.c02oo.s02classe.bastiao03;

public class App1Objeto
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
