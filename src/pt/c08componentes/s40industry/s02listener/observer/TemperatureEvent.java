package pt.c08componentes.s40industry.s02listener.observer;

import java.awt.AWTEvent;

public class TemperatureEvent extends AWTEvent {
	private static final long serialVersionUID = 2219754253396988107L;
	
	public static final int TEMPERATURE_EVENT = 1;

	private int temperature;

	public TemperatureEvent(Object source, int temperature) {
		super(source, TEMPERATURE_EVENT);
		this.temperature = temperature;
	}
	
	public int getTemperature() {
		return temperature;
	}
}
