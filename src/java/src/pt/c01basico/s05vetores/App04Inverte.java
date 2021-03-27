package pt.c01basico.s05vetores;

import java.util.Random;

public class App04Inverte {

   public static void main(String[] args) {

      int numeros[] = new int[10];

      Random rand = new Random();

      for (int n = 0; n < 10; n++)
          numeros[n] = rand.nextInt(100);

      System.out.println("=== Números gerados:");
      for (int n = 0; n < 10; n++)
          System.out.print(numeros[n] + " ");

      System.out.println("\n=== Números na ordem inversa:");
      for (int n = 9; n >= 0; n--)
          System.out.print(numeros[n] + " ");
   }

}
