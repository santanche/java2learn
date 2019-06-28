package pt.c08componentes.s21catalogml.s00shared;

public interface IColumnProducer {
  String getTitle();
  
  double[] requestValues();
  String[] requestNominals();
}
