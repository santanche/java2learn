package pt.c09generica.s04Statistics;

public class StatisticsGenerics<Type extends Number> {

   private int position = 0;
   private Type values[];
   
   public StatisticsGenerics(int size) {
      Object[] v = new Object[size];
      values = (Type [])v;
   }
   
   public void add(Type value) {
      values[position] = value;
      position++;
   }
   
   public float sum() {
      float s = 0;
      for (int p = 0; p < position; p++)
         s += values[p].floatValue();
      
      return s;
   }
}
