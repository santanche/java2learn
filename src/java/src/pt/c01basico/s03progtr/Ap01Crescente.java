package pt.c01basico.s03progtr;

import java.util.Random;

public class Ap01Crescente {

   public static void main(String[] args) {
      // gerando números aleatórios
      Random rand = new Random();
      int a = rand.nextInt(100),
          b = rand.nextInt(100);

      System.out.println("Numeros sorteados: ");
      System.out.println(a);
      System.out.println(b);

      if (a > b)
        System.out.println("Maior: " + a);
      else
        System.out.println("Maior: " + b);
   }

}
