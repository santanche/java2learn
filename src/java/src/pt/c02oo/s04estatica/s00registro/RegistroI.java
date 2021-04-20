package pt.c02oo.s04estatica.s00registro;

public class RegistroI {
   int contador = 0;
   
   int proximoContador() {
      contador++;
      return contador;
   }
}
