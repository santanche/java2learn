package pt.c02oo.s03relacionamento.s02grafico;

public class App1GraficoValores {
   public static void main(String args[]) {
      Grafico g1 = new Grafico(true, '#');
      g1.plota(10);
      g1.plota(12);
      g1.plota(8);
      System.out.println();

      Grafico g2 = new Grafico(false, '*');
      g2.plota(4);
      g2.plota(5);
      g2.plota(7);      
   }
}
