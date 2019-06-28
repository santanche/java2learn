package pt.c08componentes.s21catalogml.apps;

import pt.c08componentes.s21catalogml.s10ds.DataSetComponent;
import pt.c08componentes.s21catalogml.s10ds.IDataSet;
import pt.c08componentes.s21catalogml.s20console.ConsoleComponent;
import pt.c08componentes.s21catalogml.s20console.IConsole;
import pt.c08componentes.s21catalogml.s40selection.IFilter;
import pt.c08componentes.s21catalogml.s40selection.ISelection;
import pt.c08componentes.s21catalogml.s40selection.SelectionComponent;
import pt.c08componentes.s21catalogml.s40selection.filters.FilterEqualComponent;

public class App30bDataSetSelection {
  public static void main(String args[])
  {
      try {
        IDataSet dataset = new DataSetComponent();
        dataset.setDataSource("db/datasets/zombie/complete/zombie-health-spreadsheet-ml-training.csv");
        
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
