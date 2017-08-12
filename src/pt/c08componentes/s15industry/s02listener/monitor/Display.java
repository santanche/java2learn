package pt.c08componentes.s15industry.s02listener.monitor;

import pt.c08componentes.s15industry.s02listener.observer.TemperatureEvent;

public class Display implements IDisplay {
	
	public final static int STANDARD_LIMIT = 80;
	public final static String STANDARD_LABEL = "Valor";
	
	private int limit = STANDARD_LIMIT;
	private String label = STANDARD_LABEL;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public void update(TemperatureEvent temperature) {
		System.out.print("             " + label + ": "+temperature.getTemperature() + "; Cor: ");
		if (temperature.getTemperature() < limit)
			System.out.println("Verde");
		else
			System.out.println("Vermelho");
		System.out.println("------------------");
	}

}