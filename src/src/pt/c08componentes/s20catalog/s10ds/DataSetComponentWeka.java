package pt.c08componentes.s20catalog.s10ds;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class DataSetComponentWeka implements IDataSet {

  private String dataSource = null;
  private Instances instancesWeka = null;
  private String[] attributes = null;
  private String[][] instances = null;
  
  public DataSetComponentWeka() {
    /* nothing */
  }

  public String getDataSource() {
    return dataSource;
  }

  public void setDataSource(String dataSource) {
    this.dataSource = dataSource;
    if (dataSource == null) {
      instancesWeka = null;
      attributes = null;
      instances = null;
    } else
      readDS();
  }
  
  public String[] requestAttributes() {
    if (attributes == null && instancesWeka != null)
      convertAttributes();
    return attributes;
  }
  
  private void convertAttributes() {
    int nAttr = instancesWeka.numAttributes();
    attributes = new String[nAttr];
    for (int a = 0; a < nAttr; a++)
      attributes[a] = instancesWeka.attribute(a).name();
  }
  
  public String[][] requestInstances() {
    if (instances == null && instancesWeka != null)
      convertInstances();
    return instances;
  }
  
  private void convertInstances() {
    int nAttr = instancesWeka.numAttributes();
    int nInst = instancesWeka.size();
    instances = new String[nInst][];
    
    for (int i = 0; i < nInst; i++) {
      instances[i] = new String[nAttr];
      for (int a = 0; a < nAttr; a++)
        instances[i][a] = (instancesWeka.attribute(a).isNominal())?
                            instancesWeka.get(i).stringValue(a) :
                            Double.toString(instancesWeka.get(i).value(a));
    }
  }
  
  public Instances requestInstancesWeka() {
    return instancesWeka;
  }
  
  private void readDS() {
    try {
      attributes = null;
      instances = null;
      DataSource wekads = new DataSource(dataSource);
      instancesWeka = wekads.getDataSet();
      // setting class attribute if the data format does not provide this information
      // For example, the XRFF format saves the class attribute information as well
      if (instancesWeka.classIndex() == -1)
        instancesWeka.setClassIndex(instancesWeka.numAttributes() - 1);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public String toString() {
    return (instancesWeka == null ? "*** empty ***" : instancesWeka.toString());
  }

}
