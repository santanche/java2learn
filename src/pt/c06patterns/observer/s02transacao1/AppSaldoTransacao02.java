package pt.c06patterns.observer.s02transacao1;

public class AppSaldoTransacao02 {

   public static void main(String args[]) {
      SaldoSubj saldo = new SaldoSubj();
      MostraSaldo mostra = new MostraSaldo();

      saldo.attach(mostra);
      
      saldo.movimento(20);
      saldo.movimento(50);
   }
}
