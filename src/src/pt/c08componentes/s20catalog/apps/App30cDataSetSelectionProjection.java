package pt.c08componentes.s20catalog.apps;

import pt.c08componentes.s20catalog.s10ds.DataSetComponent;
import pt.c08componentes.s20catalog.s10ds.IDataSet;
import pt.c08componentes.s20catalog.s20console.ConsoleComponent;
import pt.c08componentes.s20catalog.s20console.IConsole;
import pt.c08componentes.s20catalog.s30projection.IProjection;
import pt.c08componentes.s20catalog.s30projection.ProjectionComponent;
import pt.c08componentes.s20catalog.s40selection.ISelection;
import pt.c08componentes.s20catalog.s40selection.SelectionComponent;

public class App30cDataSetSelectionProjection {
  public static void main(String args[])
  {
      try {
        IDataSet dataset = new DataSetComponent();
        dataset.setDataSource("db/datasets/zombie/complete/zombie-health-spreadsheet-ml-training.csv");
        
        ISelection selection = new SelectionComponent();
        selection.connect(dataset);
        selection.setAttribute("diagnostic");
        selection.setOperator("=");
        selection.setValue("bacterial_infection");
        
        IProjection projection = new ProjectionComponent();
        String[] attributes = {"name", "age"};
        projection.setAttributes(attributes);
        projection.connect(selection);

        IConsole console = new ConsoleComponent();
        console.connect(projection);
        console.update();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
