package pt.c02oo.s03relacionamento.s02grafico;

public class App3GraficoPotencia {

   public static void main(String[] args) {
      Grafico g1 = new Grafico(true, '#');
      Grafico g2 = new Grafico(false, '*');

      Potencia p = new Potencia(1, 7);

      p.conecta(g1);
      p.apresenta();

      p.conecta(g2);
      p.apresenta();
   }

}
