package pt.c08componentes.s10statistics.s02interface;

import java.util.Vector;

/**
 * Registers a set of numbers and calculates the sum and average of these numbers.
 * 
 * @author Andre Santanche
 */
public class Statistics implements IStatisticsServices {
   private Vector<Double> valueSet;
   
   /*
    * Constructor
    **************/
   
   public Statistics(int capacity) {
      super();
      valueSet = new Vector<Double>(capacity);
   }

   /*
    * IStatisticsServices Interface
    *******************************/
   
   public void insertValue(double value) {
      valueSet.add(value);
   }

   public double sum() {
      double theSum = 0.0f;
      
      for (double value : valueSet)
         theSum += value;
      
      return theSum;
   }

   public double average() {
      double avg = 0;
      
      if (valueSet.size() > 0)
         avg = sum() / valueSet.size();
      
      return avg;
   }
}
