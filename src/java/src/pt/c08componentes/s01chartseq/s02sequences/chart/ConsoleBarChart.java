package pt.c08componentes.s01chartseq.s02sequences.chart;

public class ConsoleBarChart extends BarChart {
   private char character;
   
   public ConsoleBarChart() {
      super();
      character = '*';
   }

   public char getCharacter() {
      return character;
   }

   public void setCharacter(char character) {
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
            }
            System.out.println();
            value = sequence.next();
         }
      }
   }
}
