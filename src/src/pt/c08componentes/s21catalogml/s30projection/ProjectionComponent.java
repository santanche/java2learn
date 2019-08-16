package pt.c08componentes.s21catalogml.s30projection;

import java.util.Enumeration;

import pt.c08componentes.s21catalogml.s00shared.IInstancesProducer;
import weka.core.Attribute;
import weka.core.Instances;

public class ProjectionComponent implements IProjection {
  private IInstancesProducer provider;
  
  private String attribute = null,
                 title = null;
  
  /* (non-Javadoc)
   * @see pt.c08componentes.s20catalog.s20projection.IProjectionSimple#getAttribute()
   */
  @Override
  public String getAttribute() {
    return attribute;
  }

  /* (non-Javadoc)
   * @see pt.c08componentes.s20catalog.s20projection.IProjectionSimple#setAttribute(java.lang.String)
   */
  @Override
  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }
  
  public String getTitle() {
    String title = (this.title != null) ? this.title : attribute;
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public void connect(IInstancesProducer provider) {
    this.provider = provider;
  }
  
  /* (non-Javadoc)
   * @see pt.c08componentes.s20catalog.s20projection.IProjectionSimple#projectAttributeValues()
   */
  @Override
  public double[] requestValues() {
    double[] attributeValues = null;
    
    if (provider != null) {
      Instances instances = provider.requestInstances();
      
      Attribute attr = findAttribute(instances);
      if (attr != null) {
        int index = attr.index();
        if (index != -1)
          attributeValues = instances.attributeToDoubleArray(index);
      }
    }
    
    return attributeValues;
  }
  
  /* (non-Javadoc)
   * @see pt.c08componentes.s20catalog.s20projection.IProjectionSimple#projectAttributeNominals()
   */
  @Override
  public String[] requestNominals() {
    String[] nominals = null;
    Instances instances = provider.requestInstances();
    
    Attribute attr = findAttribute(instances);
    
    boolean isNominal = attr.isNominal();
    
    if (attr != null) {
      int index = attr.index();

      if (index != -1) {
        nominals = new String[instances.size()];
        for (int i = 0; i < nominals.length; i++)
          nominals[i] = (isNominal)?
                          instances.get(i).stringValue(index) :
                          Double.toString(instances.get(i).value(index));
      }
    }
    
    return nominals;
  }
  
  private Attribute findAttribute(Instances instances) {
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
    String output = "***** empty *****";
    
    Instances instances = provider.requestInstances();
    Attribute attr = findAttribute(instances);
    
    if (attr != null) {
      output = "===== " + getTitle() + " =====\n";
      if (attr.isNominal()) {
        String[] values = requestNominals();
        if (values != null) {
          for (String val: values)
            output += val + "\n";
        }
      } else {
        double[] values = requestValues();
        if (values != null) {
          for (double val: values)
            output += val + "\n";
        }
      }
    }
    
    return output;
  }
}
