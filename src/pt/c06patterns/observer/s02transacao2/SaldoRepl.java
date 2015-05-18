package pt.c06patterns.observer.s02transacao2;

import java.util.ArrayList;

import pt.c06patterns.observer.s01transacao.Saldo;
import pt.c06patterns.observer.s01transacao.Transacao;

public class SaldoRepl extends Saldo {
  private ArrayList<Transacao> assinantes = new ArrayList<Transacao>();
  
  public void attach(Transacao ass) {
     assinantes.add(ass);
  }
  
  public void movimento(float valorMovimento) {
     super.movimento(valorMovimento);
     for (Transacao ass: assinantes)
        ass.movimento(valorMovimento);
  }
}
