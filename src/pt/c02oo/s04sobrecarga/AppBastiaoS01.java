package pt.c02oo.s04sobrecarga;

public class AppBastiaoS01
{
    public static void main(String[] args)
    {
        Bastiao primeiroBastiao;
        primeiroBastiao = new Bastiao();
        primeiroBastiao.aparece();
        
        System.out.println("====================================\n");
        
        primeiroBastiao.setNome("Alcebiades");
        primeiroBastiao.aparece();
    }

}
