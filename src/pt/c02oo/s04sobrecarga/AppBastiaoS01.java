package pt.c02oo.s04sobrecarga;

public class AppBastiaoS01
{
    public static void main(String[] args)
    {
        Bastiao primeiroBastiao;
        primeiroBastiao = new Bastiao();
        primeiroBastiao.aparece();
        
        primeiroBastiao.setNome("Alcebiades");
        primeiroBastiao.aparece();
        
        System.out.println("====================================\n");
        
        Bastiao segundoBastiao = new Bastiao(2, "acordado", "Galadriel");
        segundoBastiao.aparece();
        
        segundoBastiao.setIdade("grande");
        segundoBastiao.aparece();
    }

}
