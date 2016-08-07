package pt.c08componentes.s10statistics.s02interface;

/**
 * Interface for a Statistics Class that registers a set of numbers
 * and calculates the sum and average of these numbers. 
 * 
 * @author Andre Santanche
 */
public interface IStatistics {
   /**
    * Inserts a value into the set.
    * @param value the value to be inserted into the set
    */
    public void insertValue(float value);

    
    /**
     * Calculates the sum of the values in the set. Returns zero if the set is empty.
     * @return sum of the values in the set
     */
    public float sum();
  
    
    /**
     * Calculates the average of the values in the set. Returns zero if the set is empty.
     * @return average of the values in the set
     */
    public float average();
}
