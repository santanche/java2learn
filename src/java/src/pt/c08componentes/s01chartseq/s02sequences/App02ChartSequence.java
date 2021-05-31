package pt.c08componentes.s01chartseq.s02sequences;

import pt.c08componentes.s01chartseq.s02sequences.chart.BarChart;
import pt.c08componentes.s01chartseq.s02sequences.chart.IBarChart;
import pt.c08componentes.s01chartseq.s02sequences.sequence.Fibonacci;
import pt.c08componentes.s01chartseq.s02sequences.sequence.GeometricProgression;
import pt.c08componentes.s01chartseq.s02sequences.sequence.IMathSequence;
import pt.c08componentes.s01chartseq.s02sequences.sequence.IMathSequenceRatio;

public class App02ChartSequence {
   public static void main(String args[]) {
      System.out.println("Geometric Progression:");
      
      IMathSequenceRatio gp = new GeometricProgression();
      gp.setInitial(1);
      gp.setRatio(2);
      
      IBarChart bcg = new BarChart();
      bcg.setFilled(true);
      bcg.setCharacter('#');
      bcg.setN(5);
      
      bcg.connect(gp);
      bcg.plot();
      
      System.out.println("\nFibonacci Sequence:");
      
      IMathSequence fb = new Fibonacci();
      fb.setInitial(1);
      
      IBarChart bcf = new BarChart();
      bcf.setFilled(true);
      bcf.setCharacter('*');
      bcf.setN(5);
      
      bcf.connect(fb);
      bcf.plot();
   }
}
