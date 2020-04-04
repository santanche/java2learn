package pt.c02oo.s04estatica.s01registro;

public class Registro {
   static int contador = 0;
   
   static int proximoContador() {
      contador++;
      return contador;
   }
}
