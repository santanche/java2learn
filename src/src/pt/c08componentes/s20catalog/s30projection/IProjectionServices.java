package pt.c08componentes.s20catalog.s30projection;

import pt.c08componentes.s20catalog.s00shared.ITableProducer;

public interface IProjectionServices extends ITableProducer {
  String[] getAttributes();
  void setAttributes(String attribute[]);
}