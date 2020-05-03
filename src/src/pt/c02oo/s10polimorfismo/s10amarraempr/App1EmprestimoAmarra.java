package pt.c02oo.s10polimorfismo.s10amarraempr;

import java.util.Scanner;

public class App1EmprestimoAmarra {
   public static void main(String[] args) {
      Emprestimo emp;

      System.out.print("Digite T para emprestimo com taxa e N sem: ");
      Scanner teclado = new Scanner(System.in);
      String tipo = teclado.nextLine();
      teclado.close();
      
      if (tipo.equalsIgnoreCase("T"))
         emp = new EmprestimoTA(200, 5, 1, 15);
      else
         emp = new Emprestimo(200, 5, 1);
      
      int i = 1;
      float pct = emp.proximaParcela();
      while (pct > 0) {
         if (pct > 0)
            System.out.println("Emprestimo: parcela " + i + " eh " + pct);
         pct = emp.proximaParcela();
         i++;
      }
   }
}
