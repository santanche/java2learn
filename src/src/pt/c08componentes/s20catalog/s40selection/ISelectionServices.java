package pt.c08componentes.s20catalog.s40selection;

import pt.c08componentes.s20catalog.s00shared.ITableProducer;

public interface ISelectionServices extends ITableProducer {
  String getAttribute();
  void setAttribute(String attributeA);
  public String getOperator();
  public void setOperator(String operator);
  public String getValue();
  public void setValue(String value);
  boolean isNominalComparison();
  void setNominalComparison(boolean nominalComparison);
}