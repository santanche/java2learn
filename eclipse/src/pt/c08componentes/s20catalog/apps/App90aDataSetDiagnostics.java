package pt.c08componentes.s20catalog.apps;

import pt.c08componentes.s20catalog.s10ds.DataSetComponentWeka;
import pt.c08componentes.s20catalog.s10ds.IDataSet;
import pt.c08componentes.s20catalog.s90ml.AnamnesisRegisterComponent;
import pt.c08componentes.s20catalog.s90ml.DiagnosticsComponent;
import pt.c08componentes.s20catalog.s90ml.EHRConsoleComponent;
import pt.c08componentes.s20catalog.s90ml.IAnamnesisRegister;
import pt.c08componentes.s20catalog.s90ml.IDiagnostics;
import pt.c08componentes.s20catalog.s90ml.IEHRConsole;

public class App90aDataSetDiagnostics {
  public static void main(String args[])
  {
      try {
        IAnamnesisRegister anamnesis = new AnamnesisRegisterComponent();

        IDiagnostics diagnostics = new DiagnosticsComponent();
        anamnesis.connect(diagnostics);
        
        IEHRConsole console = new EHRConsoleComponent();
        diagnostics.connect(console);

        IDataSet dataset = new DataSetComponentWeka();
        dataset.setDataSource("eclipse/db/datasets/zombie/weka/zombie-health-spreadsheet-ml-training.arff");
        diagnostics.connect(dataset);
        
        anamnesis.start();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
