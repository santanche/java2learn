package pt.c08componentes.s10statistics.s03component.v01;

/**
 * Registers a set of numbers and calculates the sum and average of these numbers.
 * 
 * @author Andre Santanche
 */
public class StatisticsComponent implements IStatistics {
   public final static int STANDARD_CAPACITY = 50;
   
   private double valueSet[];
   private int size;
   
   /*
    * Constructor
    **************/

   public StatisticsComponent()
   {
      this(STANDARD_CAPACITY);
   }
   
   public StatisticsComponent(int capacity) {
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
