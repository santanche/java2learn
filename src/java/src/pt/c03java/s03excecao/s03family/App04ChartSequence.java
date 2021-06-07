package pt.c03java.s03excecao.s03family;

import pt.c03java.s03excecao.s03family.chart.BarChart;
import pt.c03java.s03excecao.s03family.chart.IBarChart;
import pt.c03java.s03excecao.s03family.chart.exception.PlotException;
import pt.c03java.s03excecao.s03family.sequence.ArithmeticProgression;
import pt.c03java.s03excecao.s03family.sequence.IMathSequenceRatio;

public class App04ChartSequence {
   public static void main(String args[]) {
      System.out.println("Arithmetic Progression:");
      
      IMathSequenceRatio gp = new ArithmeticProgression();
      gp.setInitial(5);
      gp.setRatio(-1);
      
      try {
         IBarChart bcg = new BarChart();
         bcg.setFilled(true);
         bcg.setCharacter('#');
         bcg.setN(7);
         
         bcg.connect(gp);
      
         bcg.plot();
      } catch (PlotException error) {
         System.err.println("*** Error: " + error.getMessage());
      }
   }
}
