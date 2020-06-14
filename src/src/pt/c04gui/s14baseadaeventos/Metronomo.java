package pt.c04gui.s14baseadaeventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Metronomo extends ActionSubject implements ActionListener {
   private Timer metro;
   private int quantidade, corrente;
    
   public Metronomo(int intervalo, int quantidade) {
      this.quantidade = quantidade;
      corrente = 0;
      metro = new Timer(intervalo, this);
   }
   
   public void start() {
      metro.start();
   }
    
   public void stop() {
      metro.stop();
   }
    
   public void actionPerformed(ActionEvent event) {
      corrente++;
      if (corrente >= quantidade)
         stop();
      notify(event);
   }
}
