package pt.c08componentes.s15industry.s01local.termometer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import pt.c08componentes.s15industry.s01local.observer.IObserver;
import pt.c08componentes.s15industry.s01local.observer.ISubject;

public class TermometerRandom implements ITermometer, ISubject, ActionListener {
	public final static int STANDARD_INTERVAL = 1000;
	
    private int interval = STANDARD_INTERVAL;
    
    private Timer metro;
    private ArrayList<IObserver> observerList = new ArrayList<IObserver>();
    
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
    
    public void attach(IObserver observer) {
    	observerList.add(observer);
    }
    
    public void actionPerformed(ActionEvent evt) {
    	int temp = (int)(Math.random() * 130);
    	notifyObservers(temp);
    }
    
    private void notifyObservers(int temp) {
    	for (IObserver o : observerList) {
			o.update(temp);
		}
    }
}
