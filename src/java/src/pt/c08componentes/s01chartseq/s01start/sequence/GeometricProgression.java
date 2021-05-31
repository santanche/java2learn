package pt.c08componentes.s01chartseq.s01start.sequence;

public class GeometricProgression implements IGeometricProgression {
   private int initial,
               ratio;
   private int current;
   
   public GeometricProgression() {
      initial = 1;
      ratio = 2;
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
      current *= ratio;
      return current;
   }
}
