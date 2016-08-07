package pt.c08componentes.s10statistics.s01class;

import java.util.Vector;

/**
 * Registers a set of numbers and calculates the sum and average of these numbers.
 * 
 * @author Andre Santanche
 */
public class Statistics {
   private Vector<Float> valueSet;
   
   /*
    * Constructor
    **************/
   
   public Statistics()
   {
       super();
       valueSet = new Vector<Float>();
   }

   /*
    * IStatistics Interface
    ***********************/
   
   public void insertValue(float value)
   {
       valueSet.add(value);
   }

   public float sum()
   {
       float theSum = 0.0f;
       
       for (float value : valueSet)
           theSum += value;
       
       return theSum;
   }

   public float average()
   {
       float avg = 0;
       
       if (valueSet.size() > 0)
           avg = sum() / valueSet.size();
       
       return avg;
   }
}
