package pt.c08componentes.s20catalog.s40selection;

import pt.c08componentes.s20catalog.s00shared.ITableProducer;

public interface ISelectionServices extends ITableProducer {
  String getAttributeA();
  void setAttributeA(String attributeA);
  String getAttributeB();
  void setAttributeB(String attributeB);
  boolean isNominalComparison();
  void setNominalComparison(boolean nominalComparison);
}