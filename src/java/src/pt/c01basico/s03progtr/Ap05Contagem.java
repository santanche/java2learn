package pt.c01basico.s03progtr;

public class Ap05Contagem {

   public static void main(String[] args) {
      int cont = 0;

      do {
        cont++;
        System.out.println(cont);
      } while (cont < 5);
      
      cont = 0;

      while (cont < 5) {
        cont++;
        System.out.println(cont);
      }
      
      for (cont = 1; cont <= 5; cont++)
         System.out.println(cont);      
   }

}
