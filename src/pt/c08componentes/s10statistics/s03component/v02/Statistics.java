package pt.c08componentes.s10statistics.s03component.v02;

/**
 * Registers a set of numbers and calculates the sum and average of these numbers.
 * 
 * @author Andre Santanche
 */
public class Statistics implements IStatistics {
   public final static int STANDARD_SIZE = 50;
   
   private float valueSet[] = new float[STANDARD_SIZE];
   private int position = 0;
   
   /*
    * Constructor
    **************/

   public Statistics() {
      super();
   }
   
   public Statistics(int size)    {
      super();
      valueSet = new float[size];
   }

   /*
    * IStatistics Interface
    ***********************/
   
   public void insertValue(float value)
   {
      if (position < valueSet.length) {
        valueSet[position] = value;
        position++;
      }
   }

   public float sum()
   {
       float theSum = 0.0f;
       
       for (int p = 0; p < position; p++)
         theSum += valueSet[p];
       
       return theSum;
   }

   public float average()
   {
       float avg = 0;
       
       if (position > 0)
         avg = sum() / position;
       
       return avg;
   }
}
