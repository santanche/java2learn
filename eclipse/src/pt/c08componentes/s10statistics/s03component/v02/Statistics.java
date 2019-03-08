package pt.c08componentes.s10statistics.s03component.v02;

/**
 * Registers a set of numbers and calculates the sum and average of these numbers.
 * 
 * @author Andre Santanche
 */
public class Statistics implements IStatistics, IStatisticsProperties {
   public final static int STANDARD_SIZE = 50;
   
   private double valueSet[];
   private int size = STANDARD_SIZE,
               last = -1;
   
   /*
    * Constructor
    **************/

   public Statistics() {
	   this(STANDARD_SIZE);
   }
   
   public Statistics(int size)    {
      super();
      this.size = size;
      valueSet = new double[size];
   }
   
   /* Property
    **********/
   
   public int getSize( ) {
	   return size;
   }
   
   public void setSize(int size) {
	   if (size != this.size) {
         double newValueSet[] = new double[size];
         if (last > -1)
        	 System.arraycopy(valueSet, 0, newValueSet, 0, last+1);
         valueSet = newValueSet;
	   }
   }
   
   public int getLast() {
       return last;
   }
   
   public double[] getValueSet() {
	   return valueSet;
   }

   public void setValueSet(double[] valueSet) {
	   this.valueSet = valueSet;
	   size = valueSet.length;
	   last = size - 1;
   }
   
   public double getValueSet(int index) {
	   return (index <= last) ? valueSet[index] : 0;
   }
   
   public void setValueSet(int index, double value) {
	   int position = (index <= last) ? index : last + 1;
	   if (position < size) {
		   valueSet[position] = value;
	       if (position == last + 1)
		       last++;
	   }
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
