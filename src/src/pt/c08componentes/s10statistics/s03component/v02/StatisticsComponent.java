package pt.c08componentes.s10statistics.s03component.v02;

import java.util.Vector;

/**
 * Registers a set of numbers and calculates the sum and average of these numbers.
 * 
 * @author Andre Santanche
 */
public class StatisticsComponent implements IStatistics {
   private Vector<Double> valueSet;
   
   /*
    * Constructor
    **************/

   public StatisticsComponent() {
      super();
      valueSet = new Vector<Double>();
   }
   
   public StatisticsComponent(int capacity) {
      super();
      valueSet = new Vector<Double>(capacity);
   }

   /* Properties
    ************/
   
   public int getSize() {
       return valueSet.size();
   }
   
   public double[] getValueSet() {
      int size = valueSet.size();
      double result[] = new double[size];
      for (int d = 0; d < size; d++)
         result[d] = valueSet.get(d);
	   return result;
   }

   public void setValueSet(double[] valueSet) {
      for (int d = 0; d < valueSet.length; d++)
         this.valueSet.add(valueSet[d]);
   }
   
   public double getValueSet(int index) {
	   return (index < getSize()) ? valueSet.get(index) : 0;
   }
   
   public void setValueSet(int index, double value) {
	   int position = (index < getSize()) ? index : getSize();
	   if (position < getSize())
		   valueSet.set(index, value);
	   else
	      valueSet.add(value);
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
