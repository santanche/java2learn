package pt.c02oo.s06heranca.s01lista.s04construtor;

public class Lista {
   protected int vlista[] = new int[100];
   protected int ultimo = -1;
   
   public void adicionar(int item) {
      if (ultimo+1 < vlista.length) {
         ultimo++;
         vlista[ultimo] = item;
      }
   }
   
   public String toString() {
      String str = "";
      for (int l = 0; l <= ultimo; l++)
         str += vlista[l] + ((l < ultimo) ? ", " : "");
      return str;
   }
}
