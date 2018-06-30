package pt.c08componentes.s20catalog.s30projection;

import pt.c08componentes.s20catalog.s00shared.IColumnProducer;

public interface IProjectionServices extends IColumnProducer {
  String getAttribute();
  void setAttribute(String attribute);
}