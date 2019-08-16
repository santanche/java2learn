package pt.c08componentes.s20catalog.apps;

import pt.c08componentes.s20catalog.s10ds.DataSetComponent;
import pt.c08componentes.s20catalog.s10ds.IDataSet;
import pt.c08componentes.s20catalog.s30projection.IProjection;
import pt.c08componentes.s20catalog.s30projection.ProjectionComponent;
import pt.c08componentes.s20catalog.s50chart.ChartBubbleComponent;
import pt.c08componentes.s20catalog.s50chart.IChart;

public class App40aDataSetChart {
  public static void main(String args[])
  {
      try {
        IDataSet dataset = new DataSetComponent();
        dataset.setDataSource("db/datasets/zombie/complete/zombie-health-spreadsheet-ml-training.csv");
        
        IProjection projection = new ProjectionComponent();
        projection.connect(dataset);
        String attributes[] = {"days_recovery", "age"};
        projection.setAttributes(attributes);
        
        IChart chart = new ChartBubbleComponent();
        chart.setTitle("Zombie Health");
        chart.setXTitle("Days Recovery");
        chart.setYTitle("Age");
        chart.connect(projection);
        
        boolean status = chart.start();
        if (!status)
          System.out.println("*** nao foi possivel criar o grafico ***");
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

}
