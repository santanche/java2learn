package pt.c08componentes.s20catalog.apps;

import pt.c08componentes.s20catalog.s10ds.DataSetComponentWeka;
import pt.c08componentes.s20catalog.s10ds.IDataSet;

public class App10aDataSetWeka {
  public static void main(String args[])
  {
      try {
        IDataSet ds = new DataSetComponentWeka();
        ds.setDataSource("eclipse/db/datasets/zombie/complete/zombie-health-spreadsheet-ml-training.csv");
        
        System.out.println(ds.requestInstancesWeka());
        
        System.out.println("=== Attributes ===");
        String attributes[] = ds.requestAttributes();
        for (int a = 0; a < attributes.length-1; a++)
          System.out.print(attributes[a] + ", ");
        System.out.println(attributes[attributes.length-1]);
        
        System.out.println();
        System.out.println("=== Instances ===");
        String instances[][] = ds.requestInstances();
        for (int i = 0; i < instances.length; i++) {
          for (int a = 0; a < attributes.length-1; a ++)
            System.out.print(instances[i][a] + ", ");
          System.out.println(instances[i][attributes.length-1]);
        }
        
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
