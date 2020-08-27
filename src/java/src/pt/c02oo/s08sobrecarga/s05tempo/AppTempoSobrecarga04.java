package pt.c02oo.s08sobrecarga.s05tempo;

public class AppTempoSobrecarga04 {
   public static void main(String args[]) {
      Horario h1 = new Horario(),
              h2 = new Horario(10, 15, 59),
              h3 = new Horario("07:53:02");
      
      h1.tick();
      h2.tick();
      h3.tick();
      
      System.out.println("Horario 1: " + h1);
      System.out.println("Horario 2: " + h2);
      System.out.println("Horario 3: " + h3);
   }
}
