package pt.c09generica.s01porvalor;

public class AppGen02Travessao {

   static void travessao(int tamanho) {
      for (int t = 1; t <= tamanho; t++)
         System.out.print("=");
      System.out.println();
   }

   public static void main(String[] args) {
      travessao(3);
      travessao(10);
   }

}
