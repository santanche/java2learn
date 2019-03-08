package pt.c08componentes.s20catalog.s40selection;

public interface IFilter {
  public double getValueParameter();
  public void setValueParameter(double parameter);
  public String getNominalParameter();
  public void setNominalParameter(String parameter);
  
  public boolean filter(double toEvaluate);
  public boolean filter(String toEvaluate);
  public boolean filter(double toCompare1, double toCompare2);
  public boolean filter(String toCompare1, String toCompare2);
}
