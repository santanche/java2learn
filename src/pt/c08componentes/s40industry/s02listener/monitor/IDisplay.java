package pt.c08componentes.s40industry.s02listener.monitor;

import pt.c08componentes.s40industry.s02listener.observer.TemperatureListener;

public interface IDisplay extends TemperatureListener {
	public int getLimit();
	public void setLimit(int limit);
	
	public String getLabel();
	public void setLabel(String label);
}
