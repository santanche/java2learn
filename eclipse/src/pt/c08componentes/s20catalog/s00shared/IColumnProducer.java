package pt.c08componentes.s20catalog.s00shared;

public interface IColumnProducer {
  String getTitle();
  
  double[] requestValues();
  String[] requestNominals();
}
