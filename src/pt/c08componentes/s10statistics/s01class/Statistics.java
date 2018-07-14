package pt.c08componentes.s10statistics.s01class;

/**
 * Registers a set of numbers and calculates the sum and average of these numbers.
 * 
 * @author Andre Santanche
 */
public class Statistics {
   private double valueSet[];
   private int last;
   
   /*
    * Constructor
    **************/
   
   public Statistics(int size)
   {
       super();
       valueSet = new double[size];
       last = -1;
   }

   /*
    * IStatistics Interface
    ***********************/
   
   public void insertValue(double value)
   {
      if (last < valueSet.length) {
        last++;
        valueSet[last] = value;
      }
   }

   public double sum()
   {
       double theSum = 0.0f;
       
       for (int p = 0; p <= last; p++)
         theSum += valueSet[p];
       
       return theSum;
   }

   public double average()
   {
       double avg = 0;
       
       if (last > -1)
         avg = sum() / (last + 1);
       
       return avg;
   }
}
