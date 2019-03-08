package pt.c08componentes.s20catalog.s00shared;

import pt.c08componentes.s20catalog.s50chart.ChartParameter;

public interface IColumnProducerReceptacle {
  public void connect(IColumnProducer producer);
  public void connect(IColumnProducer producer, ChartParameter role);
}
