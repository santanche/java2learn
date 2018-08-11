package pt.c08componentes.s20catalog.apps;

import pt.c08componentes.s20catalog.s10ds.DataSetComponent;
import pt.c08componentes.s20catalog.s10ds.IDataSet;
import pt.c08componentes.s20catalog.s90ml.DiagnosticsComponent;
import pt.c08componentes.s20catalog.s90ml.IDiagnostics;

public class App90aDataSetDiagnostics {
  public static void main(String args[])
  {
	  double[] symptoms = {0, 0, 1, 1, 1, 1, 1, 0};
      try {
        IDataSet dataset = new DataSetComponent();
        dataset.setDataSource("db/datasets/zombie/weka/zombie-health-spreadsheet-ml-training.arff");
        
        IDiagnostics diagnostics = new DiagnosticsComponent();
        diagnostics.connect(dataset);
        
        diagnostics.diagnose(symptoms);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
