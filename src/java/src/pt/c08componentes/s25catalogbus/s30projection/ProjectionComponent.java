package pt.c08componentes.s25catalogbus.s30projection;

import pt.c08componentes.s25catalogbus.s00shared.ITableProducer;

public class ProjectionComponent implements IProjection {
  private ITableProducer provider;
  
  private String attributes[] = null;
  
  public String[] getAttributes() {
    return attributes;
  }

  public void setAttributes(String attributes[]) {
    this.attributes = attributes;
  }
  
  public void connect(ITableProducer provider) {
    this.provider = provider;
  }
  
  public String[] requestAttributes() {
    return attributes;
  }
  
  public String[][] requestInstances() {
    String[][] instances = null;
    
    if (provider != null) {
      String[][] allInstances = provider.requestInstances();
      if (allInstances != null  && attributes != null) {
        instances = new String[allInstances.length][];
        
        // busca a posicao dos atributos selecionados na tabela original
        String[] allAttributes = provider.requestAttributes();
        int attrPos[] = new int[attributes.length];
        for (int as = 0; as < attributes.length; as++) {
          int aa;
          for (aa = 0; aa < allAttributes.length &&
               !attributes[as].equalsIgnoreCase(allAttributes[aa]); aa++)
            /* nothing */;
          if (aa < allAttributes.length)
            attrPos[as] = aa;
          else
            attrPos[as] = -1;
        }
        
        // filtra atributos selecionados
        for (int i = 0; i < allInstances.length; i++) {
          instances[i] = new String[attributes.length];
          for (int as = 0; as < attributes.length; as++)
            if (attrPos[as] > -1)
              instances[i][as] = allInstances[i][attrPos[as]];
        }
      }
    }
    
    return instances;
  }
}
