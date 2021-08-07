package pt.c08componentes.s01chartseq.s02sequences.sequence;

import pt.c06patterns.factory.s10components.sequence.IMathRatioSequence;

public class ArithmeticProgression implements IMathRatioSequence {
   private int initial,
               ratio;
   private int current;
   
   public ArithmeticProgression() {
      initial = 1;
      ratio = 1;
      current = initial;
   }
   
   public int getInitial() {
      return initial;
   }
   
   public void setInitial(int initial) {
      this.initial = initial;
   }
   
   public int getRatio() {
      return ratio;
   }
   
   public void setRatio(int ratio) {
      this.ratio = ratio;
   }
   
   public int first() {
      current = initial;
      return current;
   }
   
   public int next() {
      current += ratio;
      return current;
   }
}
