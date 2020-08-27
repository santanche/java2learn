package pt.c02oo.s04estatica.s01registro;

public class App1aStatic {
   public static void main(String args[]) {
      Registro.contador = 5;
      
      System.out.println("Contador: " + Registro.contador);
      System.out.println("Contador: " + Registro.proximoContador());
   }
}
