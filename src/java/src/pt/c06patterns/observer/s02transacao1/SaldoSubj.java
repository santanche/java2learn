package pt.c06patterns.observer.s02transacao1;

/* Questao 01 da lista de Design Patterns e
 * questao de prova de 2015.1
 */
public class SaldoSubj extends Subject {
   private float valor;
   public float getValor() {
       return valor;
   }

   public void movimento(float valorMovimento) {
       valor += valorMovimento;
       for (Transacao ass: assinantes)
          ass.movimento(valorMovimento);
   }
   
}
