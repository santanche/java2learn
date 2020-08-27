package pt.c08componentes.s21catalogml.apps;

import pt.c08componentes.s21catalogml.s10ds.DataSetComponent;
import pt.c08componentes.s21catalogml.s10ds.IDataSet;
import pt.c08componentes.s21catalogml.s20console.ConsoleComponent;
import pt.c08componentes.s21catalogml.s20console.IConsole;

public class App20aDataSetConsole {
  public static void main(String args[])
  {
      try {
        IDataSet dataset = new DataSetComponent();
        dataset.setDataSource("db/datasets/zombie/complete/zombie-health-spreadsheet-ml-training.csv");
        
        IConsole console = new ConsoleComponent();
        console.connect(dataset);
        
        console.update();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
