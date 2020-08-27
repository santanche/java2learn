package pt.c02oo.s03relacionamento.s02grafico;

public class App2GraficoPotencia {

   public static void main(String[] args) {
      Grafico g1 = new Grafico(true, '#');
      Potencia p = new Potencia(1, 7);
      p.conecta(g1);
      p.apresenta();
   }

}
