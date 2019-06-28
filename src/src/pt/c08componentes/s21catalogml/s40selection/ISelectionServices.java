package pt.c08componentes.s21catalogml.s40selection;

import pt.c08componentes.s21catalogml.s00shared.IInstancesProducer;

public interface ISelectionServices extends IInstancesProducer {
  String getAttributeA();
  void setAttributeA(String attributeA);
  String getAttributeB();
  void setAttributeB(String attributeB);
  boolean isNominalComparison();
  void setNominalComparison(boolean nominalComparison);
}