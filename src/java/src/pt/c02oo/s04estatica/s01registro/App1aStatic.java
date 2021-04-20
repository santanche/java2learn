package pt.c02oo.s04estatica.s01registro;

public class App1aStatic {
   public static void main(String args[]) {
      RegistroS.contador = 5;
      
      System.out.println("Contador: " + RegistroS.contador);
      System.out.println("Contador: " + RegistroS.proximoContador());
   }
}
