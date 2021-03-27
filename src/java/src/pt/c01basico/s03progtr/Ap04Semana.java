package pt.c01basico.s03progtr;

import java.util.Random;

public class Ap04Semana {
   public static void main(String args[])
   {
   // gerando um dia da semana aleatório
      Random rand = new Random();
      int diaSemana = rand.nextInt(7) + 1;
      System.out.println("Dia da semana: " + diaSemana);

      switch (diaSemana) {
        case 1 : System.out.println("domingo"); break;
        case 2 : System.out.println("segunda"); break;
        case 3 : System.out.println("terca");   break;
        case 4 : System.out.println("quarta");  break;
        case 5 : System.out.println("quinta");  break;
        case 6 : System.out.println("sexta");   break;
        case 7 : System.out.println("sabado");  break;
        default: System.out.println("invalido");
      }
   }
}
