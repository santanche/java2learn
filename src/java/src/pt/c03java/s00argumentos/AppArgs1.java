package pt.c03java.s00argumentos;

public class AppArgs1 {

   public static void main(String[] args) {
      for (int a = 0; a < args.length; a++)
         System.out.println("argumento " + (a+1) + ": " + args[a]);
   }

}
