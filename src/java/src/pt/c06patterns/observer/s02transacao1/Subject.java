package pt.c06patterns.observer.s02transacao1;

import java.util.ArrayList;

public class Subject {
   protected ArrayList<Transacao> assinantes = new ArrayList<Transacao>();
   
   public void attach(Transacao ass) {
      assinantes.add(ass);
   }
}
