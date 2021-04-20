package pt.c02oo.s04estatica.s00registro;

public class AppAInstance {
   public static void main(String args[]) {
      RegistroI r = new RegistroI();
      
      r.contador = 5;
      
      System.out.println("Contador: " + r.contador);
      System.out.println("Contador: " + r.proximoContador());
   }
}
