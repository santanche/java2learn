package pt.c02oo.s08sobrecarga.s03tempo;

public class AppTempoSobrecarga02 {
   public static void main(String args[]) {
      Horario h1 = new Horario(),
              h2 = new Horario(),
              h3 = new Horario();
      
      h1.define();
      h2.define(10, 15, 59);
      h3.define("07:53:02");
      
      h1.tick();
      h2.tick();
      h3.tick();
      
      System.out.println("Horario 1: " + h1);
      System.out.println("Horario 2: " + h2);
      System.out.println("Horario 3: " + h3);
   }
}
