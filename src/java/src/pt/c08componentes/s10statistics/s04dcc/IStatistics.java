package pt.c08componentes.s10statistics.s04dcc;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;

/**
 * Interface for a Statistics Component that registers a set of numbers
 * and calculates the sum and average of these numbers. 
 * 
 * @author Andre Santanche
 */
@ComponentInterface("<http://purl.org/dcc/pt.c08componentes.s10statistics.s04dcc.IStatistics>")
public interface IStatistics extends ISupports
{
	/**
	 * Insert a value into the set.
	 * @param value the value to be inserted into the set
	 */
    public void insertValue(float value);

    
    /**
     * Calculate the sum of the values in the set. Return zero if the set is empty.
     * @return sum of the values in the set
     */
    public float sum();
  
    
    /**
     * Calculate the average of the values in the set. Return zero if the set is empty.
     * @return average of the values in the set
     */
    public float average();
    
}
