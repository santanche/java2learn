package pt.c08componentes.s25catalogbus.apps;

import pt.c08componentes.s25catalogbus.s10ds.DataSetComponent;
import pt.c08componentes.s25catalogbus.s10ds.IDataSet;
import pt.c08componentes.s25catalogbus.s20console.ConsoleComponent;
import pt.c08componentes.s25catalogbus.s20console.IConsole;
import pt.c08componentes.s25catalogbus.s30projection.IProjection;
import pt.c08componentes.s25catalogbus.s30projection.ProjectionComponent;

public class App30aDataSetProjection {
  public static void main(String args[])
  {
      try {
        IDataSet dataset = new DataSetComponent();
        dataset.setDataSource("db/datasets/zombie/complete/zombie-health-spreadsheet-ml-training.csv");
        
        IProjection projection = new ProjectionComponent();
        projection.connect(dataset);

        IConsole console = new ConsoleComponent();
        console.connect(projection);

        String[] attributes = {"name", "age"};
        projection.setAttributes(attributes);
        console.update();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
