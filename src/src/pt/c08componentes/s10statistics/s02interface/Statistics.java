package pt.c08componentes.s10statistics.s02interface;

/**
 * Registers a set of numbers and calculates the sum and average of these numbers.
 * 
 * @author Andre Santanche
 */
public class Statistics implements IStatistics {
   private double valueSet[];
   private int size;
   
   /*
    * Constructor
    **************/
   
   public Statistics(int capacity) {
      super();
      valueSet = new double[capacity];
      size = 0;
   }

   /*
    * IStatistics Interface
    ***********************/
   
   public void insertValue(double value) {
      if (size < valueSet.length) {
         valueSet[size] = value;
         size++;
      }
   }

   public double sum() {
      double theSum = 0.0f;
       
      for (int p = 0; p < size; p++)
         theSum += valueSet[p];
       
      return theSum;
   }

   public double average() {
      double avg = 0;
       
      if (size > 0)
         avg = sum() / size;
       
      return avg;
   }
}
