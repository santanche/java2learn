package pt.c08componentes.s15industry.s01local.app;

import java.util.Scanner;

import pt.c08componentes.s15industry.s01local.monitor.Display;
import pt.c08componentes.s15industry.s01local.monitor.IDisplay;
import pt.c08componentes.s15industry.s01local.observer.ISubject;
import pt.c08componentes.s15industry.s01local.statistics.IStatistics;
import pt.c08componentes.s15industry.s01local.statistics.Statistics;
import pt.c08componentes.s15industry.s01local.termometer.ITermometer;
import pt.c08componentes.s15industry.s01local.termometer.TermometerRandom;

public class AppIndustryLocal02 {
	public static void main(String[] args) {
		ITermometer termometer = new TermometerRandom();
		IStatistics statistics = new Statistics();
		IDisplay display = new Display();
		
		display.setLabel("Temperatura media");
		display.setLimit(70);

		((ISubject)termometer).attach(statistics);
		((ISubject)statistics).attach(display);

		termometer.start();
		
        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();
        teclado.close();
	}
}
