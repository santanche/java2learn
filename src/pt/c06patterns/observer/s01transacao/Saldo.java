package pt.c06patterns.observer.s01transacao;

/* Questao 01 da lista de Design Patterns e
 * questao de prova de 2015.1
 */
public class Saldo implements Transacao {
   private float valor;
   public float getValor() {
       return valor;
   }

   public void movimento(float valorMovimento) {
       valor += valorMovimento;
   }
   
}
