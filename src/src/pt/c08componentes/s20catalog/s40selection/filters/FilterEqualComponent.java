package pt.c08componentes.s20catalog.s40selection.filters;

import pt.c08componentes.s20catalog.s40selection.FilterComponent;

public class FilterEqualComponent extends FilterComponent {
  @Override
  public boolean filter(double toEvaluate) {
    boolean result = false;
    
    if (toEvaluate == getValueParameter())
      result = true;
    
    return result;
  }

  public boolean filter(String toEvaluate) {
    boolean result = false;
    
    if (toEvaluate.equalsIgnoreCase(getNominalParameter()))
      result = true;
    
    return result;
  }
  
  public boolean filter(double toCompare1, double toCompare2) {
    boolean result = false;
    
    if (toCompare1 == toCompare2)
      result = true;
    
    return result;
  }
  
  public boolean filter(String toCompare1, String toCompare2) {
    boolean result = false;
    
    if (toCompare1.equalsIgnoreCase(toCompare2))
      result = true;
    
    return result;
  }
}
