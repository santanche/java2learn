package pt.c02oo.s07heranca.s01lista.s04construtor;

public class Lista {
   protected int vlista[];
   protected int ultimo = -1;
   
   public Lista(int tamanho) {
      vlista = new int[tamanho];
   }
   
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
