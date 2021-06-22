package pt.c06patterns.factory.s10components.chart;

public class BarChartFactory {
   
   public static IBarChart create(String type) {
      IBarChart chart = null;
      
      if (type.equalsIgnoreCase("console"))
         chart = new ConsoleBarChart();
      else if (type.equalsIgnoreCase("graphic"))
         chart = new GraphicBarChart();
      
      return chart;
   }

}
