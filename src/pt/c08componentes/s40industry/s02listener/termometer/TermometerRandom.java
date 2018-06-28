package pt.c08componentes.s40industry.s02listener.termometer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import pt.c08componentes.s40industry.s02listener.observer.TemperatureEvent;
import pt.c08componentes.s40industry.s02listener.observer.TemperatureListener;
import pt.c08componentes.s40industry.s02listener.observer.TemperatureSubject;

public class TermometerRandom implements ITermometer, TemperatureSubject, ActionListener {
	public final static int STANDARD_INTERVAL = 1000;
	
    private int interval = STANDARD_INTERVAL;
    
    private Timer metro;
    private ArrayList<TemperatureListener> observerList = new ArrayList<TemperatureListener>();
    
    public int getInterval() {
    	return interval;
    }
    
    public void setInterval(int interval) {
    	this.interval = interval;
    	metro.setDelay(interval);
    }
    
    public TermometerRandom() {
        metro = new Timer(interval, this);
    }
    
    public void start() {
        metro.start();
    }
    
    public void stop() {
        metro.stop();
    }
    
    public void attach(TemperatureListener observer) {
    	observerList.add(observer);
    }
    
    public void actionPerformed(ActionEvent evt) {
    	int temp = (int)(Math.random() * 130);
    	notifyObservers(temp);
    }
    
    private void notifyObservers(int temp) {
    	TemperatureEvent tempEv = new TemperatureEvent(this, temp);
    	for (TemperatureListener o : observerList) {
			o.update(tempEv);
		}
    }
}
