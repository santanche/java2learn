package pt.c08componentes.s20catalog.apps;

import pt.c08componentes.s20catalog.s10ds.DataSetComponentWeka;
import pt.c08componentes.s20catalog.s10ds.IDataSet;
import pt.c08componentes.s20catalog.s20console.ConsoleComponent;
import pt.c08componentes.s20catalog.s20console.IConsole;

public class App20aDataSetConsole {
  public static void main(String args[])
  {
      try {
        IDataSet dataset = new DataSetComponentWeka();
        dataset.setDataSource("eclipse/db/datasets/zombie/complete/zombie-health-spreadsheet-ml-training.csv");
        
        IConsole console = new ConsoleComponent();
        console.connect(dataset);
        
        console.update();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
