package pt.c08componentes.s01chartseq.s01start;

import pt.c08componentes.s01chartseq.s01start.chart.BarChart;
import pt.c08componentes.s01chartseq.s01start.chart.IBarChart;
import pt.c08componentes.s01chartseq.s01start.sequence.GeometricProgression;
import pt.c08componentes.s01chartseq.s01start.sequence.IGeometricProgression;

public class App01ChartSequence {
   public static void main(String args[]) {
      IGeometricProgression gp = new GeometricProgression();
      gp.setInitial(1);
      gp.setRatio(2);
      
      IBarChart bc = new BarChart();
      bc.setFilled(true);
      bc.setCharacter('#');
      bc.setN(5);
      
      bc.connect(gp);
      bc.plot();
   }
}
