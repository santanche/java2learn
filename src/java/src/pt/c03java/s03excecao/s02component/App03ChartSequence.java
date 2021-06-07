package pt.c03java.s03excecao.s02component;

import pt.c03java.s03excecao.s02component.chart.BarChart;
import pt.c03java.s03excecao.s02component.chart.IBarChart;
import pt.c03java.s03excecao.s02component.chart.UnsupportedNegativeNumber;
import pt.c03java.s03excecao.s02component.sequence.ArithmeticProgression;
import pt.c03java.s03excecao.s02component.sequence.IMathSequenceRatio;

public class App03ChartSequence {
   public static void main(String args[]) {
      System.out.println("Arithmetic Progression:");
      
      IMathSequenceRatio gp = new ArithmeticProgression();
      gp.setInitial(5);
      gp.setRatio(-1);
      
      IBarChart bcg = new BarChart();
      bcg.setFilled(true);
      bcg.setCharacter('#');
      bcg.setN(7);
      
      bcg.connect(gp);
      
      try {
         bcg.plot();
      } catch (UnsupportedNegativeNumber error) {
         System.err.println("*** Error: " + error.getMessage());
      }
   }
}
