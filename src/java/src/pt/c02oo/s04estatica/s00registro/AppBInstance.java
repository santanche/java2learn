package pt.c02oo.s04estatica.s00registro;

public class AppBInstance {
   public static void main(String args[]) {
      RegistroI r1 = new RegistroI(),
                r2 = new RegistroI();
      r1.contador = 5;
      r2.contador = 7;
      
      System.out.println("Contador r1: " + r1.contador);
      System.out.println("Contador r2: " + r2.contador);
      System.out.println("Contador r1: " + r1.proximoContador());
      System.out.println("Contador r2: " + r2.proximoContador());
   }
}
