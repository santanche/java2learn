package pt.c08componentes.s40industry.s02listener.app;

import java.util.Scanner;

import pt.c08componentes.s40industry.s02listener.monitor.Display;
import pt.c08componentes.s40industry.s02listener.monitor.IDisplay;
import pt.c08componentes.s40industry.s02listener.observer.TemperatureSubject;
import pt.c08componentes.s40industry.s02listener.statistics.IStatistics;
import pt.c08componentes.s40industry.s02listener.statistics.Statistics;
import pt.c08componentes.s40industry.s02listener.termometer.ITermometer;
import pt.c08componentes.s40industry.s02listener.termometer.TermometerRandom;

public class AppIndustryLocal02 {
	public static void main(String[] args) {
		ITermometer termometer = new TermometerRandom();
		IStatistics statistics = new Statistics();
		IDisplay display = new Display();
		
		display.setLabel("Temperatura media");
		display.setLimit(70);

		((TemperatureSubject)termometer).attach(statistics);
		((TemperatureSubject)statistics).attach(display);

		termometer.start();
		
        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();
        teclado.close();
	}
}
