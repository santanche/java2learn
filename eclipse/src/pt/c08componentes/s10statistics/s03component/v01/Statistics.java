package pt.c08componentes.s10statistics.s03component.v01;

/**
 * Registers a set of numbers and calculates the sum and average of these numbers.
 * 
 * @author Andre Santanche
 */
public class Statistics implements IStatistics {
   public final static int STANDARD_SIZE = 50;
   
   private double valueSet[];
   private int last;
   
   /*
    * Constructor
    **************/

   public Statistics()
   {
      this(STANDARD_SIZE);
   }
   
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
