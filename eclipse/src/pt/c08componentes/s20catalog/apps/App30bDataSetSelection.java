package pt.c08componentes.s20catalog.apps;

import pt.c08componentes.s20catalog.s10ds.DataSetComponentWeka;
import pt.c08componentes.s20catalog.s10ds.IDataSet;
import pt.c08componentes.s20catalog.s20console.ConsoleComponent;
import pt.c08componentes.s20catalog.s20console.IConsole;
import pt.c08componentes.s20catalog.s40selection.IFilter;
import pt.c08componentes.s20catalog.s40selection.ISelection;
import pt.c08componentes.s20catalog.s40selection.SelectionComponent;
import pt.c08componentes.s20catalog.s40selection.filters.FilterEqualComponent;

public class App30bDataSetSelection {
  public static void main(String args[])
  {
      try {
        IDataSet dataset = new DataSetComponentWeka();
        dataset.setDataSource("eclipse/db/datasets/zombie/complete/zombie-health-spreadsheet-ml-training.csv");
        
        ISelection selection = new SelectionComponent();
        selection.connect(dataset);
        selection.setAttributeA("diagnostic");
        
        IFilter filter = new FilterEqualComponent();
        filter.setNominalParameter("bacterial_infection");
        selection.connect(filter);

        IConsole console = new ConsoleComponent();
        console.connect(selection);
        console.update();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
