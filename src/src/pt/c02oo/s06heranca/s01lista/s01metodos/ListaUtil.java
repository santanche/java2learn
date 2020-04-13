package pt.c02oo.s06heranca.s01lista.s01metodos;

public class ListaUtil extends Lista {

   public void ordena() {
      int lastSwap = ultimo;
      while (lastSwap > 0) {
         int swap = 0;
         for (int v = 0; v < lastSwap; v++)
            if (vlista[v] > vlista[v+1]) {
               int aux = vlista[v];
               vlista[v] = vlista[v+1];
               vlista[v+1] = aux;
               swap = v;
            }
          lastSwap = swap;
      }
   }

}
