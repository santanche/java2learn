package pt.c08componentes.s40industry.s01local.statistics;

import java.util.ArrayList;
import java.util.Vector;

import pt.c08componentes.s40industry.s01local.observer.IObserver;
import pt.c08componentes.s40industry.s01local.observer.ISubject;

/**
 * Registers a set of numbers and calculates the sum and average of these numbers.
 * 
 * @author Andre Santanche
 */
public class Statistics implements IStatistics, ISubject {
   private Vector<Float> valueSet;
   
   private ArrayList<IObserver> observerList = new ArrayList<IObserver>();
   
   /*
    * Constructor
    **************/
   
   public Statistics()
   {
       super();
       valueSet = new Vector<Float>();
   }

   public void update(int value) {
	   insertValue(value);
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
   
   public void attach(IObserver observer) {
   	   observerList.add(observer);
   }
   
   private void notifyObservers(int average) {
   	for (IObserver o : observerList) {
			o.update(average);
		}
   }
}
