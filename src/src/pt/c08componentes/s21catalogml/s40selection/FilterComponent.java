package pt.c08componentes.s21catalogml.s40selection;

public abstract class FilterComponent implements IFilter {
  private double valueParameter;
  private String nominalParameter;

  public double getValueParameter() {
    return valueParameter;
  }

  public void setValueParameter(double valueParameter) {
    this.valueParameter = valueParameter;
  }

  public String getNominalParameter() {
    return nominalParameter;
  }

  public void setNominalParameter(String nominalParameter) {
    this.nominalParameter = nominalParameter;
  }
  
  public boolean filter(double toEvaluate) {
    /* write your filter here */
    
    return true;
  }

  public boolean filter(String toEvaluate) {
    /* write your filter here */
    
    return true;
  }
  
  public boolean filter(double toCompare1, double toCompare2) {
    /* write your filter here */
    
    return true;
  }
  
  public boolean filter(String toCompare1, String toCompare2) {
    /* write your filter here */
    
    return true;
  }
}
