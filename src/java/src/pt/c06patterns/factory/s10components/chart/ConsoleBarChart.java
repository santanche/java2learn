package pt.c06patterns.factory.s10components.chart;

import pt.c06patterns.factory.s10components.chart.exception.InvalidBlankChar;
import pt.c06patterns.factory.s10components.chart.exception.UnsupportedNegativeNumber;

public class ConsoleBarChart extends BarChart {
   private char character;
   
   public ConsoleBarChart() {
      super();
      character = '*';
   }

   public char getCharacter() {
      return character;
   }

   public void setCharacter(char character) throws InvalidBlankChar {
      if (character == ' ')
         throw new InvalidBlankChar("the chart does not support blank character");
      this.character = character;
   }

   public void plot() {
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
