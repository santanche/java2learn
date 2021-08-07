package pt.c08componentes.s01chartseq.s02sequences;

import pt.c08componentes.s01chartseq.s02sequences.chart.GraphicBarChart;
import pt.c08componentes.s01chartseq.s02sequences.chart.IBarChart;
import pt.c08componentes.s01chartseq.s02sequences.sequence.Fibonacci;
import pt.c08componentes.s01chartseq.s02sequences.sequence.GeometricProgression;
import pt.c08componentes.s01chartseq.s02sequences.sequence.IMathRatioSequence;
import pt.c08componentes.s01chartseq.s02sequences.sequence.IMathSequence;

public class App02ChartSequence {
   public static void main(String args[]) {
      System.out.println("Geometric Progression:");
      
      IMathRatioSequence gp = new GeometricProgression();
      gp.setInitial(1);
      gp.setRatio(2);
      
      IBarChart bcg = new GraphicBarChart();
      bcg.setFilled(true);
      bcg.setN(5);
      
      bcg.connect(gp);
      bcg.plot();
      
      System.out.println("\nFibonacci Sequence:");
      
      IMathSequence fb = new Fibonacci();
      fb.setInitial(1);
      
      IBarChart bcf = new GraphicBarChart();
      bcf.setFilled(true);
      bcf.setN(5);
      
      bcf.connect(fb);
      bcf.plot();
   }
}
