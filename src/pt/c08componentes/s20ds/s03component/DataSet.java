package pt.c08componentes.s20ds.s03component;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class DataSet {

  private String dataSource = null;

  private Instances instances = null;
  
  public DataSet() {
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

}
