package pt.c08componentes.s25catalogbus.s40selection;

import java.util.ArrayList;

import pt.c08componentes.s25catalogbus.s00shared.ITableProducer;

public class SelectionComponent implements ISelection {
  private ITableProducer provider;
  
  private String attribute = null,
                 operator = null,
                 value = null;
  private boolean nominalComparison = true;
  
  public String getAttribute() {
    return attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }
  
  public String getOperator() {
    return operator;
  }
  
  public void setOperator(String operator) {
    this.operator = operator;
  }
  
  public String getValue() {
    return value;
  }
  
  public void setValue(String value) {
    this.value = value;
  }
  
  public boolean isNominalComparison() {
    return nominalComparison;
  }

  public void setNominalComparison(boolean nominalComparison) {
    this.nominalComparison = nominalComparison;
  }

  public void connect(ITableProducer provider) {
    this.provider = provider;
  }
  
  public String[] requestAttributes() {
    return (provider == null) ? null : provider.requestAttributes();
  }
  
  public String[][] requestInstances() {
    ArrayList<String[]> instances = null;
    
    if (provider != null) {
      String[][] allInstances = provider.requestInstances();
      
      if (allInstances != null) {
        // busca a posicao dos atributos selecionados na tabela original
        String[] allAttributes = provider.requestAttributes();
        int atrPos;
        for (atrPos = 0; atrPos < allAttributes.length &&
             !attribute.equalsIgnoreCase(allAttributes[atrPos]); atrPos++)
          /* nothing */;
        if (atrPos < allAttributes.length) {
          instances = new ArrayList<String[]>();
          
          for (String[] ai: allInstances) {
            boolean match = false;
            if (nominalComparison) {
              switch (operator.charAt(0)) {
                case '=': if (ai[atrPos].equalsIgnoreCase(value))
                       match = true;
                     break;
                case '<': if (ai[atrPos].compareTo(value) < 0)
                       match = true;
                     break;
                case '>': if (ai[atrPos].compareTo(value) > 0)
                       match = true;
                     break;
                case '!': if (!ai[atrPos].equalsIgnoreCase(value))
                     match = true;
                     break;
              }
            } else {
              switch (operator.charAt(0)) {
                case '=': if (Double.parseDouble(ai[atrPos]) == Double.parseDouble(value))
                            match = true;
                          break;
                case '<': if (Double.parseDouble(ai[atrPos]) < Double.parseDouble(value))
                            match = true;
                          break;
                case '>': if (Double.parseDouble(ai[atrPos]) > Double.parseDouble(value))
                            match = true;
                          break;
                case '!': if (Double.parseDouble(ai[atrPos]) != Double.parseDouble(value))
                            match = true;
                          break;
              }
            }
            if (match)
              instances.add(ai);
                
          }
        }
      }
    }
    
    return (instances == null) ? null : instances.toArray(new String[1][]);
  }
}
