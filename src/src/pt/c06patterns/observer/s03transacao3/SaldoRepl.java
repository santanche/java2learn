package pt.c06patterns.observer.s03transacao3;

public class SaldoRepl extends SaldoSubject {

  public void movimento(float valorMovimento) {
     super.movimento(valorMovimento);
     notify(valorMovimento);
  }

}
