package pt.c09generica.s04Statistics;

public class Statistics {

   private int position = 0;
   private int values[];
   
   public Statistics(int size) {
      values = new int[size];
   }
   
   public void add(int value) {
      values[position] = value;
      position++;
   }
   
   public int sum() {
      int s = 0;
      for (int p = 0; p < position; p++)
         s += values[p];
      return s;
   }
}
