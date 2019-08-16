package pt.c08componentes.s40industry.s02listener.statistics;

import java.util.ArrayList;
import java.util.Vector;

import pt.c08componentes.s40industry.s02listener.observer.TemperatureEvent;
import pt.c08componentes.s40industry.s02listener.observer.TemperatureListener;
import pt.c08componentes.s40industry.s02listener.observer.TemperatureSubject;

/**
 * Registers a set of numbers and calculates the sum and average of these numbers.
 * 
 * @author Andre Santanche
 */
public class Statistics implements IStatistics, TemperatureSubject {
   private Vector<Float> valueSet;
   
   private ArrayList<TemperatureListener> observerList = new ArrayList<TemperatureListener>();
   
   /*
    * Constructor
    **************/
   
   public Statistics()
   {
       super();
       valueSet = new Vector<Float>();
   }

   public void update(TemperatureEvent temperature) {
	   insertValue(temperature.getTemperature());
	   notifyObservers((int)average());
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
   
   public void attach(TemperatureListener observer) {
   	   observerList.add(observer);
   }
   
   private void notifyObservers(int average) {
	   TemperatureEvent tempEv = new TemperatureEvent(this, average);
   	   for (TemperatureListener o : observerList) {
			o.update(tempEv);
		}
   }
}
