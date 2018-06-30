package pt.c08componentes.s20catalog.s10ds;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class DataSetComponent implements IDataSet {

  private String dataSource = null;

  private Instances instances = null;
  
  public DataSetComponent() {
    /* nothing */
  }

  public String getDataSource() {
    return dataSource;
  }

  public void setDataSource(String dataSource) {
    this.dataSource = dataSource;
    if (dataSource == null)
      instances = null;
    else
      readDS();
  }
  
  public Instances requestInstances() {
    return instances;
  }
  
  private void readDS() {
    try {
      DataSource wekads = new DataSource(dataSource);
      instances = wekads.getDataSet();
      // setting class attribute if the data format does not provide this information
      // For example, the XRFF format saves the class attribute information as well
      if (instances.classIndex() == -1)
        instances.setClassIndex(instances.numAttributes() - 1);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public String toString() {
    return (instances == null ? "*** empty ***" : instances.toString());
  }

}
