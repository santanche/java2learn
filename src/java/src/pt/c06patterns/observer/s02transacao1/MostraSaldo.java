package pt.c06patterns.observer.s02transacao1;

public class MostraSaldo implements Transacao {
   public void movimento(float valorMovimento) {
      System.out.println("Novo movimento: " + valorMovimento);
   }
}
