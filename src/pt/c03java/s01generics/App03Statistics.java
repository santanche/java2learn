package pt.c03java.s01generics;

import java.util.Scanner;

public class App03Statistics {

   public static void main(String args[])
   {
       Statistics stat = new Statistics(10);
       
       Scanner teclado = new Scanner(System.in);
       
       System.out.print("Digite um numero: ");
       String entrada = teclado.nextLine();
       while (!entrada.equalsIgnoreCase("fim")) {
           Integer numero = new Integer(entrada);
           stat.add(numero);
           
           System.out.print("Digite outro numero: ");
           entrada = teclado.nextLine();
       }
       
       System.out.println("Soma: " + stat.sum());
       
       teclado.close();
   }
}
