package pt.c03java.s00argumentos;

public class AppArgs2 {

   public static void main(String[] args) {
      if (args.length == 0)
         System.out.println("você precisa digitar argumentos");
      else
         for (int a = 0; a < args.length; a++)
            System.out.println("argumento " + (a+1) + ": " + args[a]);
   }

}
