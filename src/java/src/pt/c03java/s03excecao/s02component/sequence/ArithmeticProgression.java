package pt.c03java.s03excecao.s02component.sequence;

public class ArithmeticProgression implements IMathSequenceRatio {
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
