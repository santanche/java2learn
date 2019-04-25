package pt.c08componentes.s20catalog.apps;

import pt.c08componentes.s20catalog.s10ds.DataSetComponentWeka;
import pt.c08componentes.s20catalog.s10ds.IDataSet;
import pt.c08componentes.s20catalog.s30projection.IProjection;
import pt.c08componentes.s20catalog.s30projection.ProjectionComponent;
import pt.c08componentes.s20catalog.s50chart.ChartBubbleComponent;
import pt.c08componentes.s20catalog.s50chart.ChartParameter;
import pt.c08componentes.s20catalog.s50chart.IChart;

public class App40aDataSetChart {
  public static void main(String args[])
  {
      try {
        IDataSet dataset = new DataSetComponentWeka();
        dataset.setDataSource("eclipse/db/datasets/zombie/complete/zombie-health-spreadsheet-ml-training.csv");
        
        IProjection projectionDays = new ProjectionComponent();
        projectionDays.connect(dataset);
        projectionDays.setAttribute("days_recovery");
        projectionDays.setTitle("days of recovery");
        
        IProjection projectionAge = new ProjectionComponent();
        projectionAge.connect(dataset);
        projectionAge.setAttribute("age");
        System.out.println(projectionAge);

        IChart chart = new ChartBubbleComponent();
        chart.setTitle("Zombie Health");
        chart.connect(projectionDays, ChartParameter.X_AXIS);
        chart.connect(projectionAge, ChartParameter.Y_AXIS);
        
        boolean status = chart.start();
        if (!status)
          System.out.println("*** nao foi possivel criar o grafico ***");
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

}
