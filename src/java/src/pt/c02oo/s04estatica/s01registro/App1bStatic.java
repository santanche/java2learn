package pt.c02oo.s04estatica.s01registro;

public class App1bStatic {
   public static void main(String args[]) {
      RegistroS r1 = new RegistroS(),
               r2 = new RegistroS();
      r1.contador = 5;
      r2.contador = 7;
      
      System.out.println("Contador r1: " + r1.contador);
      System.out.println("Contador r2: " + r2.contador);
      System.out.println("Contador r1: " + r1.proximoContador());
      System.out.println("Contador r2: " + r2.proximoContador());
   }
}
