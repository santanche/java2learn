package pt.c02oo.s03relacionamento.s03agregacao;

public class Emprestimo {
   float s;
   int   n;
   float j;
   int   corrente;
   float p;

   Emprestimo(float s, int n, float j) {
      this.s = s;
      this.n = n;
      this.j = j;
      corrente = 1;
      this.p = s;
   }

   float proximaParcela() {
      float retorno = p;
      corrente++;
      if (corrente <= n)
         p = p + (p * (j/100));
      else
         p = 0;
      return retorno;
   }
}