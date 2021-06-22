package pt.c06patterns.factory.s10components;

import java.util.Scanner;

import pt.c06patterns.factory.s10components.chart.BarChartFactory;
import pt.c06patterns.factory.s10components.chart.IBarChart;
import pt.c06patterns.factory.s10components.chart.exception.PlotException;
import pt.c06patterns.factory.s10components.sequence.IMathSequenceRatio;
import pt.c06patterns.factory.s10components.sequence.MathSequenceFactory;

public class App05ChartSequence {
   public static void main(String args[]) {
      System.out.print("Progression type (arithmetic or geometric): ");
      Scanner keyboard = new Scanner(System.in);
      String sequenceType = keyboard.nextLine();
      
      System.out.print("Chart type (console ou graphic): ");
      String chartType = keyboard.nextLine();
      
      keyboard.close();
      
      IMathSequenceRatio gp = MathSequenceFactory.createSequenceRatio(sequenceType);
      gp.setInitial(1);
      gp.setRatio(2);
      
      try {
         IBarChart bcg = BarChartFactory.create(chartType);
         bcg.setFilled(true);
         bcg.setN(7);
         bcg.connect(gp);
         bcg.plot();
      } catch (PlotException error) {
         System.err.println("*** Error: " + error.getMessage());
      }
   }
}
