package pt.c08componentes.s21catalogml.s00shared;

import pt.c08componentes.s21catalogml.s50chart.ChartParameter;

public interface IColumnProducerReceptacle {
  public void connect(IColumnProducer producer);
  public void connect(IColumnProducer producer, ChartParameter role);
}
