package pt.c01basico.s05vetores;

import java.util.Random;

public class App01DiaSemanaRandom {

   public static void main(String[] args) {
      String ds[] = {"invalido", "domingo", "segunda", "terca", "quarta", "quinta", "sexta", "sabado"};

      Random rand = new Random();
      int diaSemana = rand.nextInt(7) + 1;
      System.out.println("Dia da semana: " + ((diaSemana < 1 || diaSemana > 7) ? "invalido" : ds[diaSemana]));
   }

}
