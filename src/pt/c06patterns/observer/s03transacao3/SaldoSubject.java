package pt.c06patterns.observer.s03transacao3;

import java.util.ArrayList;

import pt.c06patterns.observer.s01transacao.Saldo;
import pt.c06patterns.observer.s01transacao.Transacao;

public abstract class SaldoSubject extends Saldo {
   private ArrayList<Transacao> assinantes = new ArrayList<Transacao>();
   
   public void attach(Transacao ass) {
      assinantes.add(ass);
   }
   
   public void notify(float valorMovimento) {
      for (Transacao ass: assinantes)
         ass.movimento(valorMovimento);
   }
}
