package pt.c08componentes.s40industry.s01local.monitor;

import pt.c08componentes.s40industry.s01local.observer.IObserver;

public interface IDisplay extends IObserver {
	public int getLimit();
	public void setLimit(int limit);
	
	public String getLabel();
	public void setLabel(String label);
}
