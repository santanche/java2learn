package pt.c08componentes.s01chartseq.s01start.chart;

import pt.c08componentes.s01chartseq.s01start.sequence.ISequence;

public class BarChart implements IBarChart {
   private boolean filled;
   private char character;
   private int n;
   
   private ISequence sequence;
   
   public BarChart() {
      filled = true;
      character = '*';
      n = 3;
   }

   public boolean isFilled() {
      return filled;
   }

   public void setFilled(boolean filled) {
      this.filled = filled;
   }

   public char getCharacter() {
      return character;
   }

   public void setCharacter(char character) {
      this.character = character;
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
   
   public void plot() {
      if (sequence != null) {
         int value = sequence.first();
         for (int s = 1; s <= n; s++) {
            for (int v = 1; v < value; v++)
               System.out.print((filled) ? character : ' ');
            System.out.println(character);
            value = sequence.next();
         }
      }
   }
}
