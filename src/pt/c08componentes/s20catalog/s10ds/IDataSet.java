package pt.c08componentes.s20catalog.s10ds;

import pt.c08componentes.s20catalog.s00shared.IInstancesProducer;

public interface IDataSet extends IInstancesProducer {
  public String getDataSource();
  public void setDataSource(String dataSource);
}
