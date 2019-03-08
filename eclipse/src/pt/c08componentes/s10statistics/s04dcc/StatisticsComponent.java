package pt.c08componentes.s10statistics.s04dcc;

import java.util.Vector;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

/**
 * Registers a set of numbers and calculates the sum and average of these numbers.
 * 
 * @author Andre Santanche
 */
@Component(id = "<http://purl.org/dcc/pt.c08componentes.s10statistics.s04dcc.StatisticsComponent>",
           provides = {"<http://purl.org/dcc/pt.c08componentes.s10statistics.s04dcc.IStatistics>"})
public class StatisticsComponent extends ComponentBase implements IStatistics
{
    private Vector<Float> valueSet;
    
    /*
     * Constructor
     **************/
    
    public StatisticsComponent()
    {
        super();
        valueSet = new Vector<Float>();
    }

    /*
     * IStatistics Interface
     ***********************/
    
    /**
     * 
     */
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
