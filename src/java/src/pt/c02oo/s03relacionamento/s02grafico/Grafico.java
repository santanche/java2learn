package pt.c02oo.s03relacionamento.s02grafico;

public class Grafico {
   boolean preenchido;
   char caractere;
   
   Grafico(boolean preenchido, char caractere) {
      this.preenchido = preenchido;
      this.caractere = caractere;
   }

   void plota(int valor) {
      for (int v = 1; v < valor; v++)
         System.out.print((preenchido) ? caractere : ' ');
      System.out.println(caractere);
   }
}
