package pt.c06patterns.factory.s10components.chart;

import pt.c06patterns.factory.s10components.sequence.ISequence;

public abstract class BarChart implements IBarChart {
   protected boolean filled;
   protected int n;
   
   protected ISequence sequence;
   
   public BarChart() {
      filled = true;
      n = 3;
   }

   public boolean isFilled() {
      return filled;
   }

   public void setFilled(boolean filled) {
      this.filled = filled;
   }

   public int getN() {
      return n;
   }

   public void setN(int n) {
      this.n = n;
   }

   public void connect(ISequence sequence) {
      this.sequence = sequence;
   }
   
   public abstract void plot();
}
