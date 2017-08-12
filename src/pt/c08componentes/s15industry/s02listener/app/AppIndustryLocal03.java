package pt.c08componentes.s15industry.s02listener.app;

import java.util.Scanner;

import pt.c08componentes.s15industry.s02listener.monitor.Display;
import pt.c08componentes.s15industry.s02listener.monitor.IDisplay;
import pt.c08componentes.s15industry.s02listener.observer.TemperatureSubject;
import pt.c08componentes.s15industry.s02listener.statistics.IStatistics;
import pt.c08componentes.s15industry.s02listener.statistics.Statistics;
import pt.c08componentes.s15industry.s02listener.termometer.ITermometer;
import pt.c08componentes.s15industry.s02listener.termometer.TermometerRandom;

public class AppIndustryLocal03 {
	public static void main(String[] args) {
		ITermometer termometer = new TermometerRandom();
		IStatistics statistics = new Statistics();
		IDisplay displayTemperatura = new Display(),
				 displayMedia = new Display();
		
		displayTemperatura.setLabel("Temperatura");
		displayTemperatura.setLimit(70);
		displayMedia.setLabel("Temperatura media");
		displayTemperatura.setLimit(70);

		((TemperatureSubject)termometer).attach(displayTemperatura);
		((TemperatureSubject)termometer).attach(statistics);
		((TemperatureSubject)statistics).attach(displayMedia);

		termometer.start();
		
        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();
        teclado.close();
	}
}
