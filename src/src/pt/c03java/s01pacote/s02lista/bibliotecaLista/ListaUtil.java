package pt.c03java.s01pacote.s02lista.bibliotecaLista;

public class ListaUtil extends Lista {
   private boolean duplicatas = true;
   
   public ListaUtil(int tamanho, boolean duplicatas) {
      super(tamanho);
      this.duplicatas = duplicatas;
   }
   
   public boolean getDuplicatas() {
      return duplicatas;
   }
   
   public void setDuplicatas(boolean duplicatas) {
      this.duplicatas = duplicatas;
   }

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
      
      if (!duplicatas) {
         int s = 0;
         for (int v = 0; v <= ultimo; v++)
            if (vlista[s] != vlista[v]) {
               s++;
               vlista[s] = vlista[v];
            }
         ultimo = s;
      }
   }

}
