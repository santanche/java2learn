package pt.c08componentes.s20catalog.apps;

import pt.c08componentes.s20catalog.s10ds.DataSetComponent;
import pt.c08componentes.s20catalog.s10ds.IDataSet;

public class App10aDataSet {
  public static void main(String args[])
  {
      try {
        IDataSet ds = new DataSetComponent();
        ds.setDataSource("db/datasets/zombie/complete/zombie-health-spreadsheet-ml-training.csv");
        System.out.println(ds.requestInstances());
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
