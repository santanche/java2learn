package pt.c02oo.s03relacionamento.s02grafico;

public class Potencia {
   int inicial;
   int quantidade;
   Grafico saida;

   Potencia(int inicial, int quantidade) {
      this.inicial = inicial;
      this.quantidade = quantidade;
      saida = null;
   }

   void conecta(Grafico saida) {
      this.saida = saida;
   }

   void apresenta() {
      if (saida != null) {
         int v = inicial;
         for (int i = 1; i <= quantidade; i++) {
            saida.plota(v);
            v *= 2;
         }
      }
   }
}
