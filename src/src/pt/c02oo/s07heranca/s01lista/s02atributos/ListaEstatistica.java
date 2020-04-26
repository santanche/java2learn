package pt.c02oo.s07heranca.s01lista.s02atributos;

public class ListaEstatistica extends Lista {

   public double soma() {
      double s = 0;
      for (int l = 0; l <= ultimo; l++)
         s += vlista[l];
      return s;
   }
   
   public double media() {
      return (ultimo >= 0)
            ? soma() / (ultimo+1) : 0;
   }

}
