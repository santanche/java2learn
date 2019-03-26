package pt.c08componentes.s20catalog.s20console;

import pt.c08componentes.s20catalog.s00shared.IColumnProducer;
import pt.c08componentes.s20catalog.s00shared.IInstancesProducer;
import pt.c08componentes.s20catalog.s50chart.ChartParameter;

public class ConsoleComponent implements IConsole {
  private IInstancesProducer iProducer;
  IColumnProducer cProducer;
  
  public void connect(IInstancesProducer producer) {
    iProducer = producer;
  }
  
  public void connect(IColumnProducer producer) {
    cProducer = producer;
  }
  
  public void connect(IColumnProducer producer, ChartParameter role) {
    cProducer = producer;
  }
  
  public void update() {
    if (iProducer != null)
      System.out.println(iProducer.requestInstancesWeka());
    if (cProducer != null) {
      System.out.println("=====" + cProducer.getTitle() + "=====");
      String[] columns = cProducer.requestNominals();
      if (columns != null)
        for (String c : columns)
          System.out.println(c);
    }
  }
}
