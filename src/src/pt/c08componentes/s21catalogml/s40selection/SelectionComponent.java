package pt.c08componentes.s21catalogml.s40selection;

import java.util.Enumeration;

import pt.c08componentes.s21catalogml.s00shared.IInstancesProducer;
import weka.core.Attribute;
import weka.core.Instances;

public class SelectionComponent implements ISelection {
  private IInstancesProducer provider;
  private IFilter filter;
  
  private String attributeA = null,
                 attributeB = null,
                 title = null;
  private boolean nominalComparison = true;
  
  @Override
  public String getAttributeA() {
    return attributeA;
  }

  @Override
  public void setAttributeA(String attributeA) {
    this.attributeA = attributeA;
  }
  
  @Override
  public String getAttributeB() {
    return attributeB;
  }

  @Override
  public void setAttributeB(String attributeB) {
    this.attributeB = attributeB;
  }

  @Override
  public boolean isNominalComparison() {
    return nominalComparison;
  }

  @Override
  public void setNominalComparison(boolean nominalComparison) {
    this.nominalComparison = nominalComparison;
  }

  public String getTitle() {
    String title = (this.title != null) ? this.title : attributeA;
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public void connect(IInstancesProducer provider) {
    this.provider = provider;
  }
  
  public void connect(IFilter filter) {
    this.filter = filter;
  }
  
  @Override
  public Instances requestInstances() {
    Instances filtered = null;
    
    if (attributeA != null) {
      Instances instances = provider.requestInstances();
      if (instances != null) {
        filtered = new Instances(instances);
      
        Attribute attrA = findAttribute(instances, attributeA);
    
        if (attrA != null) {
          Attribute attrB = (attributeB == null) ? null : findAttribute(instances, attributeB);

          int indexA = attrA.index(),
              indexB = (attrB == null) ? -1 : attrB.index();

          int size = instances.size();
          for (int i = size-1; i >= 0; i--) {
            boolean selected = false;
            
            if (indexB == -1)
              if (nominalComparison)
                selected = filter.filter(instances.get(i).stringValue(indexA));
              else
                selected = filter.filter(instances.get(i).value(indexA));
            else
              if (nominalComparison)
                selected = filter.filter(instances.get(i).stringValue(indexA), instances.get(i).stringValue(indexB));
              else
                selected = filter.filter(instances.get(i).value(indexA), instances.get(i).value(indexB));
            
            if (!selected)
              filtered.delete(i);
          }
        }
      }
    }
    
    return filtered;
  }
  
  private Attribute findAttribute(Instances instances, String attribute) {
    Attribute attrFinal = null;
    
    if (attribute != null) {
      Enumeration<Attribute> attrEnum = instances.enumerateAttributes();

      while (attrFinal == null && attrEnum.hasMoreElements()) {
        Attribute attr = attrEnum.nextElement();
        if (attribute.equalsIgnoreCase(attr.name()))
          attrFinal = attr;
      }
    }
    
    return attrFinal;
  }
  
  @Override
  public String toString() {
    Instances filtered = requestInstances();
    
    return (filtered == null ? "*** empty ***" : filtered.toString());
  }

}
