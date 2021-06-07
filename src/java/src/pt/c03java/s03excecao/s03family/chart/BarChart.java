package pt.c03java.s03excecao.s03family.chart;

import pt.c03java.s03excecao.s03family.chart.exception.InvalidBlankChar;
import pt.c03java.s03excecao.s03family.chart.exception.UnsupportedNegativeNumber;
import pt.c03java.s03excecao.s03family.sequence.ISequence;

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

   public void setCharacter(char character) throws InvalidBlankChar {
      if (character == ' ')
         throw new InvalidBlankChar("the chart does not support blank character");
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
   
   public void plot() throws UnsupportedNegativeNumber {
      if (sequence != null) {
         int value = sequence.first();
         for (int s = 1; s <= n; s++) {
            if (value > 0) {
               for (int v = 1; v < value; v++)
                  System.out.print((filled) ? character : ' ');
               System.out.print(character);
            } else if (value < 0) {
               System.out.println("?");
               throw new UnsupportedNegativeNumber("the chart does not support a negative number");
            }
            System.out.println();
            value = sequence.next();
         }
      }
   }
}
