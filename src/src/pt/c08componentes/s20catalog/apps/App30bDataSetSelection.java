package pt.c08componentes.s20catalog.apps;

import pt.c08componentes.s20catalog.s10ds.DataSetComponent;
import pt.c08componentes.s20catalog.s10ds.IDataSet;
import pt.c08componentes.s20catalog.s20console.ConsoleComponent;
import pt.c08componentes.s20catalog.s20console.IConsole;
import pt.c08componentes.s20catalog.s40selection.ISelection;
import pt.c08componentes.s20catalog.s40selection.SelectionComponent;

public class App30bDataSetSelection {
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
        
        IConsole console = new ConsoleComponent();
        console.connect(selection);
        console.update();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
