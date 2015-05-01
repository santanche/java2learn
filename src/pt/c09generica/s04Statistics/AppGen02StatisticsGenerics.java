package pt.c09generica.s04Statistics;

import java.util.Scanner;

public class AppGen02StatisticsGenerics {
   public static void main(String args[])
   {
       StatisticsGenerics<Integer> stat = new StatisticsGenerics<Integer>(10);
       
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
