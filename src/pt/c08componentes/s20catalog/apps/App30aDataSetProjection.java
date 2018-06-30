package pt.c08componentes.s20catalog.apps;

import pt.c08componentes.s20catalog.s10ds.DataSetComponent;
import pt.c08componentes.s20catalog.s10ds.IDataSet;
import pt.c08componentes.s20catalog.s20console.ConsoleComponent;
import pt.c08componentes.s20catalog.s20console.IConsole;
import pt.c08componentes.s20catalog.s30projection.IProjection;
import pt.c08componentes.s20catalog.s30projection.ProjectionComponent;

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

        projection.setAttribute("name");
        projection.setTitle("Name");
        console.update();
        
        projection.setAttribute("age");
        projection.setTitle("Age");
        console.update();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
