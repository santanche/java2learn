package pt.c08componentes.s21catalogml.s30projection;

import pt.c08componentes.s21catalogml.s00shared.IColumnProducer;

public interface IProjectionServices extends IColumnProducer {
  String getAttribute();
  void setAttribute(String attribute);
}